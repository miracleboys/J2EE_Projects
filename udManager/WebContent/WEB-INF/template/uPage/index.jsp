<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="scheme" value="${pageContext.request.scheme}" />
<c:set var="serverName" value="${pageContext.request.serverName}" />
<c:set var="serverPort" value="${pageContext.request.serverPort}" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="basePath" value="${scheme}://${serverName}:${serverPort}${contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文件下载管理</title>
</head>
<body>
<div class="head">
	<div>
	<form action="${basePath}/udload/uploadSingle" method="post" enctype="multipart/form-data" target="">
		文件上传：<input name="file1" type="file" value="浏览..."/>
		<input type="submit" value="上传文件"/>
	</form>
	</div>
</div>
<div class="tablestyle" style="border:none;">
<table style="border-collapse:collapse;width:100%">
	<tr>
		<th style="width:6%">index</th>
		<th style="width:12%">文件原始名</th>
		<th style="width:24%">文件存储名</th>
		<th style="width:12%">文件类型</th>
		<th style="width:10%">文件大小</th>
		<th style="width:6%">状态码</th>
		<th style="width:20%">状态描述</th>
		<th style="width:10%">操作</th>
	</tr>
	<c:forEach var="item" items="${list}" varStatus="status">
	<tr style="background:#000000">
		<th style="width:6%">${status.index}</th>
		<th style="width:12%">${item.originalFilename}</th>
		<th style="width:24%">${item.codeFilename}</th>
		<th style="width:12%">${item.fileType}</th>
		<th style="width:10%">${item.fileSize}KB</th>
		<th style="width:6%">${item.resultCode}</th>
		<th style="width:20%">${item.resultMsg}</th>
		<th style="width:10%">
			<button onclick="location.href='${basePath}/udload/open?fileId=${status.index}'">查看</button>
			<button onclick="location.href='${basePath}/udload/download?filename=${item.codeFilename}&fileId=${status.index}'">下载</button>
			<button onclick="location.href='${basePath}/udload/deleteFiles?fileId=${status.index}'">删除</button>
		</th>
	
	</tr>
	</c:forEach>	
	
</table>
</div>
</body>
<style type="text/css">
*{
	padding:0px;
}
.head{
	display:flex;
	align-items:center;
	justify-content: center;
	background-color:rgb(4,57,94);
	color:#FFFFFF;
	height:40px;

}
.tablestyle{
	border:none;
	background-color:rgb(0,122,204);
	height:36px;
	
}
.tablestyle,th{
	color:#ffffff;
	font-size:12px;
	text-align:center;
	line-height:36px;
	border:solid #ffffff 1px;
}
</style>
</html>