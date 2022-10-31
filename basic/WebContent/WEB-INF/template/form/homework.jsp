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
<title>学生信息</title>
</head>
<body>
	 <spring:message code="ServerLanguage"/>：<spring:message code="locale.displayCountry"/>, ${locale}
	<form action="${basePath}/homework/text" method="post">
	  	<spring:message code="currentLang"/>: <select name="lang">
	  				 <option value=""><spring:message code="choose"/></option>
				     <option value="zh_CN">中文</option>
				     <option value="ja_JP">日本語</option>
				     <option value="en_US">English</option>
			   		</select><br/>
	   <input type="submit" value="<spring:message code="confirm"/>">
	</form><hr>

    <form:form modelAttribute="pet" method="post" action="${basePath}/homework/showHomework" target="_blank">
       <spring:message code="pet.name"/>：<form:input path="name" cssClass="base input" /><br>
       <spring:message code="pet.age"/>：<form:input path="age" htmlEscape="false" cssClass="base input" /><br>
	   <spring:message code="pet.kind"/>：<form:select path="kind" items="${kinds}" cssClass="base select" /><br>
       <spring:message code="pet.gender"/>：<form:radiobuttons path="gender" items="${genders}" cssClass="base radio" /><br/>
       <spring:message code="pet.petService"/>：<form:checkboxes path="petService" items="${petServices}" delimiter="♥"  cssClass="base checkbox" /><br>   
       <spring:message code="pet.indexPage"/> ：<form:input path="indexPage" cssClass="base input" /><br>
 	   <spring:message code="pet.master.name"/>：<form:input path="master.name" cssClass="base input" /><br>
	   <spring:message code="pet.master.number"/> ：<form:input path="master.number" cssClass="base input" /><br> 
	   <spring:message code="pet.master.email"/>：<form:input path="master.email" cssClass="base input" /><br><hr>
       <input type="submit" class="base button" value="<spring:message code="submitForm"/>"/>
       <input type="reset" class="base button" value="<spring:message code="resetForm"/>"/>
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
   display: inline-block;   
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
</style>
</html>