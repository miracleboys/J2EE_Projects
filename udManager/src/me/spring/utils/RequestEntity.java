package me.spring.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class RequestEntity {
	public static Map<String, Object> resolve(HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		byte[] entityArray = request.getInputStream().readAllBytes();
		String entityString = new String(entityArray, "UTF-8");
		String contentType = request.getContentType();
		String boundaryTag = "boundary=";
		int boundaryTagStartPosition = contentType.indexOf(boundaryTag);
		String boundary = "--" + contentType.substring(boundaryTagStartPosition + boundaryTag.length());
		int boundaryLength = boundary.length();
		String endBoundary = boundary + "--";
		String boundaryCheck = "";
		String subEntity = "";
		List subEntities = new ArrayList();
		List subEntitiesParsed = new ArrayList();
		result.put("contentType", contentType);
		result.put("boundary", boundary);
		result.put("contentLength", request.getContentLength());
		result.put("entity", entityString);
		while (true) {
			boundaryTagStartPosition = entityString.indexOf(boundary);
			boundaryCheck = entityString.substring(boundaryTagStartPosition,
					boundaryTagStartPosition + boundaryLength + 2);
			if (boundaryCheck.equals(endBoundary)) {
				break;
			}
			entityString = entityString.substring(boundaryTagStartPosition + boundaryLength + 2);
			boundaryTagStartPosition = entityString.indexOf(boundary);
			subEntity = entityString.substring(0, boundaryTagStartPosition);
			subEntities.add(subEntity);
			subEntitiesParsed.add(resolveEntity(subEntity));
		}
		result.put("subEntities", subEntities);
		result.put("subEntitiesParsed", subEntitiesParsed);
		return result;
	}

	private static Map<String, Object> resolveEntity(String entity) {
		Map<String, Object> result = new HashMap<String, Object>();
		String[] lines = entity.split("\r\n");
		int lineIndex = 0;
		boolean isEntityBegin = false;
		String entityValue = "";
		for (String line : lines) {
			if (line.isEmpty() & !isEntityBegin) {
				isEntityBegin = true;
				continue;
			}
			if (isEntityBegin) {
				if (lineIndex != lines.length - 2) {
					entityValue += line + "\r\n";
				} else {
					entityValue += line;
					break;
				}
			} else {
				String[] params = line.split(":");
				String[] valuePairs = params[1].split(";");
				for (String valuePair : valuePairs) {
					if (valuePair.indexOf("=") > -1) {
						String[] values = valuePair.split("=");
						result.put(values[0], values[1]);
					}
				}
			}
			lineIndex++;
		}
		result.put("entity", entityValue);
		return result;
	}

	public static Map<String, Object> saveSingleFile(HttpServletRequest request, CommonsMultipartFile file) {
		Map<String, Object> result = new HashMap<String, Object>();
		String originalFilename = file.getOriginalFilename();
		String savingFolder = request.getServletContext().getRealPath("/WEB-INF/savedFiles");
		String savingFilename = savingFolder + "/" + DigestUtils.md5Hex(originalFilename);
		String fileType = file.getContentType();
		Long fileSize = file.getSize();
		double doubleFileSize = fileSize.doubleValue() / 1024;
		DecimalFormat df = new DecimalFormat("###,###.##");

		result.put("fileType", fileType);
		result.put("originalFilename", originalFilename);
		result.put("codeFilename", DigestUtils.md5Hex(originalFilename));
		result.put("savingFilename", savingFilename);
		result.put("fileSize", df.format(doubleFileSize));
		File newFile = new File(savingFilename);
		try {
			file.transferTo(newFile);
			result.put("resultCode", 0);
			result.put("resultMsg", "文件上传成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("resultCode", -1);
			result.put("resultMsg", e.getMessage());
		}
		return result;
	}

	public static void openFiles(Map<String, Object> fileObj, HttpServletRequest request,
			HttpServletResponse response) {
		File file = new File((String) fileObj.get("savingFilename"));
		if (!file.exists()) {
			response.setStatus(404);
			return;
		}
		response.setHeader("Cache-Control", "max-age=0");
		response.setHeader("Content-Disposition", "inline; filename=" + fileObj.get("codeFilename"));
		response.setHeader("Last-Modified", String.valueOf(file.lastModified()));
		response.setContentLength(new Long(file.length()).intValue());
		response.setCharacterEncoding("UTF-8");

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(file));
			if (((String) fileObj.get("originalFilename")).contains("txt")) {
				response.setContentType("text/plain");
			}
			response.setCharacterEncoding(StandardCharsets.UTF_8.name());
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] bits = new byte[2048];
			int len = 0;
			while ((len = bis.read(bits)) != -1) {
				bos.write(bits, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null) {
					bis.close();
				}
				if (bos != null) {
					bos.close();
				}
			} catch (IOException ioe) {
				// ignore
			}
		}
	}

	public static boolean deleteFiles(Map<String, Object> map) {
		boolean flag = false;
		File file = new File((String) map.get("savingFilename"));
		if (file.isFile() && file.exists()) {
			flag = file.delete();
		}

		return flag;

	}

	public static ResponseEntity download(String savingFilename, String filename) {
		HttpHeaders headers = new HttpHeaders();
		HttpStatus statusCode = HttpStatus.OK;
		byte[] data = null;
		try {
			data = FileUtils.readFileToByteArray(new File(savingFilename));
			filename = URLEncoder.encode(filename, "UTF-8");
			// Content-Disposition:inline|attachment
			headers.set("Content-Type", "application/octet-stream");
			headers.set("Content-Disposition", "attachment;filename=" + filename);
		} catch (Exception e) {
			e.printStackTrace();
			headers.set("Content-Type", "text/html;charset=utf-8");
			try {
				data = e.getMessage().getBytes("UTF-8");
			} catch (UnsupportedEncodingException uee) {
				data = e.getMessage().getBytes();
			}
		}
		return new ResponseEntity<byte[]>(data, headers, statusCode);
	}

}
