<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出错了！！！</title>
</head>
<body>
<div style="postion:relative;width:100%;;color:#ffffff">
	<div style="postion:absolute;width:40%;margin: 0 auto;text-align:center;background-color:rgb(204,204,204);;color:#000000">系统错误</div>
	<div style="postion:absolute;width:40%;margin: 0 auto;display:flex;align-items:center;
	justify-content: center;text-align:center">
		<div style="padding:10px;background-color:rgb(0,122,204);flex:2">状态代码</div>
		<div style="padding:10px;background-color:rgb(136,136,136);flex:1;">${code}</div>
	</div>
	<div style="postion:absolute;width:40%;margin: 0 auto;display:flex;align-items:center;
	justify-content: center;text-align:center">
		<div style="padding:10px;background-color:rgb(0,122,204);flex:2">状态描述</div>
		<div style="padding:10px;background-color:rgb(136,136,136);flex:1;">${msg}</div>
	</div>
	<div style="text-align:center">
		<button onclick="location.href='../udload/index'" style="margin-top:10px">点击返回文件列表</button>
	</div>
</div>
</body>
</html>