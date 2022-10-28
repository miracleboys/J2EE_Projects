package me.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import me.spring.utils.RequestEntity;

@Controller
@RequestMapping("/udload")
public class LessonController {
	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

	@RequestMapping(value = "index", produces = "text/html")
	public String page(Model model) throws Exception {
		System.out.print(list);
		model.addAttribute("list", list);
		return "uPage/index";
	}

	@RequestMapping(value = "/uploadSingle", produces = "text/html")
	public String uploadSingle(@RequestParam(value = "file1", required = false) CommonsMultipartFile file,
			HttpServletRequest request, Model model) {
		if (!file.isEmpty()) {
			list.add(RequestEntity.saveSingleFile(request, file));

		}
		return "redirect:/udload/index";
	}

	@RequestMapping("deleteFiles")
	public String deleteFiles(@RequestParam Integer fileId) {
		if (RequestEntity.deleteFiles(list.get(fileId))) {
			list.remove((int) fileId);
			System.out.print("文件删除成功");
		} else {
			System.out.print("文件上传失败");
		}
		return "redirect:/udload/index";
	}

	@RequestMapping(value = "/download")
	public ResponseEntity download(@RequestParam Integer fileId, HttpServletRequest request) {
		String savingFolder = request.getServletContext().getRealPath("/WEB-INF/savedFiles");
		Map<String, Object> fileObj = list.get(fileId);
		return RequestEntity.download((String) fileObj.get("savingFilename"), (String) fileObj.get("originalFilename"));
	}

	@RequestMapping("/open")
	public void openFile(@RequestParam Integer fileId, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> fileObj = list.get(fileId);
		RequestEntity.openFiles(fileObj, request, response);
	}

}