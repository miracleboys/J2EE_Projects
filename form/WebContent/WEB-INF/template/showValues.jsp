<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>提交数据</title>
</head>
<body>
学号：${student.code} <form:errors path="student.code" /><hr>
姓名：${student.name}<hr>
性别：<form:radiobuttons path="student.gender" items="${genders}" cssClass="base radio" disabled="true"/><hr>
身高：${student.height}<hr>
生日：${student.birth}<hr>
爱好：<form:checkboxes path="student.myHobby" items="${hobbies}" delimiter="♬"  cssClass="base checkbox" disabled="true"/><hr>


</body>
</html>