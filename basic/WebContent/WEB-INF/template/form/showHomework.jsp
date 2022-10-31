<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="scheme" value="${pageContext.request.scheme}"/>
<c:set var="serverName" value="${pageContext.request.serverName}"/>
<c:set var="serverPort" value="${pageContext.request.serverPort}"/>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="basePath" value="${scheme}://${serverName}:${serverPort}${contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${basePath}/css/main.css">
<meta charset="UTF-8">
<title>表单提交的数据清单</title>
</head>
<body>
	<form:form modelAttribute="pet" method="post" target="_blank">
		<spring:message code="pet.name"/>：${pet.name}<form:errors path="name" cssClass="form-left"/><br>
		<spring:message code="pet.age"/>：${pet.age}<form:errors path="age" cssClass="form-left"/><br>
		<spring:message code="pet.kind"/>：<form:select path="kind" items="${kinds}" cssClass="base select" disabled="true"/><br>
		<spring:message code="pet.gender"/>：<form:radiobuttons path="gender" items="${genders}" cssClass="base select" disabled="true"/><br>
		<spring:message code="pet.petService"/>：<form:checkboxes path="petService" items="${petServices}" delimiter="♥"  cssClass="base checkbox" disabled="true"/><br>
		<spring:message code="pet.indexPage"/>：${pet.indexPage}<form:errors path="indexPage" cssClass="form-left"/><br>
		<spring:message code="pet.master.name"/>：${pet.master.name}<form:errors path="master.name" cssClass="form-left"/><br>
		<spring:message code="pet.master.number"/>：${pet.master.number}<form:errors path="master.number" cssClass="form-left"/><br>
		<spring:message code="pet.master.email"/>：${pet.master.email}<form:errors path="master.email" cssClass="form-left"/><br>
	</form:form>

</body>

<style>

body {  

}
 
.base {
    font-size: 16px;
    font-family: "Microsoft YaHei";
}
 
.input {
   display: block;   
   padding: 5px; 
}
 
.checkbox {
   display: inline-block;   
   padding: 5px; 
}
 
.button{
    margin: 5px;
    padding: 5px;  
}
.form-left{
    margin: 15px;
    padding: 15px;  
    color: red;
}
</style>
</html>

