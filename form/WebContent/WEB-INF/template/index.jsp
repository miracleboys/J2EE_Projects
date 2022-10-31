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
<title>我的表单</title>
</head>
<body>
	
<form:form modelAttribute="student" method="post" action="${basePath}/lesson/showValues" target="_blank">
        学号：<form:input path="code" htmlEscape="false" cssClass="base input" /><br>
        姓名：<form:input path="name" htmlEscape="false" cssClass="base input" /><br>
	性别：<form:radiobuttons path="gender" items="${genders}" cssClass="base radio" /><br/>
        身高：<form:input path="height" htmlEscape="false" cssClass="base input" /><br>
        生日：<form:input path="birth" htmlEscape="false" cssClass="base input" /><br>
        爱好：<form:checkboxes path="myHobby" items="${hobbies}" delimiter="♬"  cssClass="base checkbox" /><br>  
        <input type="submit" class="base button" />
        <input type="reset" class="base button" />
</form:form>
</body>
</html>