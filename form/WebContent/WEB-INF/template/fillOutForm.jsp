<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<title>宠物基本信息填写</title>
</head>
<body>
<form:form modelAttribute="pet" method="post" action="${basePath}/pet/formResult" target="_blank">
	宠物昵称：<form:input path="name" htmlEscape="false" cssClass="base input" /><br><br>
	宠物年龄：<form:input path="age" htmlEscape="false" cssClass="base input" /><br><br>
	宠物种类：<form:select path="type" items="${types}" cssClass="base select" /><br><br>
	宠物性别：<form:radiobuttons path="gender" items="${genders}" cssClass="base radio" style="display: inline-block;padding: 20px;"/><br><br>
	宠物服务：<form:checkboxes path="service" items="${ services }" delimiter=" ♥ " cssClass="base checkbox" /><br><br>
	宠物主页：<form:input path="webPage" htmlEscape="false" cssClass="base input" /><br><br>
	主人姓名：<form:input path="master" htmlEscape="false" cssClass="base input" /><br><br>
	主人电话：<form:input path="phone" htmlEscape="false" cssClass="base input" /><br><br>
	主人邮箱：<form:input path="mail" htmlEscape="false" cssClass="base input" /><br><br>
	<hr>
	<input type="submit" class="base button" />
    <input type="reset" class="base button" />
	
</form:form>
</body>
</html>