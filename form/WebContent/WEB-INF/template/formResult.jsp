<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>宠物基本信息</title>
</head>
<body>
	宠物昵称：${pet.name}<form:errors path="pet.name" /><br><br>
	宠物年龄：${pet.age}<form:errors path="pet.age" style = "padding:30px;"/><br><br>
	宠物种类：<form:select path="pet.type" items="${types}" cssClass="base select" disabled="true" /><br><br>
	宠物性别：<form:radiobuttons path="pet.gender" items="${genders}" cssClass="base radio" disabled="true"/><br><br>
	宠物服务：<form:checkboxes items="${services}" path="pet.service" delimiter="♥" cssClass="base checkbox" disabled="true"/><br><br>
	宠物主页：${pet.webPage}<form:errors path="pet.webPage" style = "padding:30px;"/><br><br>
	主人姓名：${pet.master}<form:errors path="pet.master" style = "padding:30px;"/><br><br>
	主人电话：${pet.phone}<form:errors path="pet.phone" style = "padding:30px;"/><br><br>
	主人邮箱：${pet.mail}<form:errors path="pet.mail" style = "padding:30px;"/><br><br>

</body>
</html>