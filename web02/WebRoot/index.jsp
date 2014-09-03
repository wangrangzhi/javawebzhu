<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎登录音乐商店</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <style type="text/css">
  #apDiv1 {
	position: absolute;
	left: 126px;
	top: 39px;
	width: 712px;
	height: 204px;
	z-index: 1;
}
  #apDiv2 {
	position: absolute;
	left: 171px;
	top: 60px;
	width: 126px;
	height: 40px;
	z-index: 2;
}
  #apDiv3 {
	position: absolute;
	left: 312px;
	top: 58px;
	width: 392px;
	height: 45px;
	z-index: 3;
}
  #apDiv4 {
	position: absolute;
	left: 167px;
	top: 119px;
	width: 129px;
	height: 39px;
	z-index: 4;
}
  #apDiv5 {
	position: absolute;
	left: 311px;
	top: 122px;
	width: 394px;
	height: 38px;
	z-index: 5;
}
  #apDiv6 {
	position: absolute;
	left: 167px;
	top: 178px;
	width: 542px;
	height: 47px;
	z-index: 6;
}
  </style>
  </head>
  
  <body>
  <form action="servlet/LoginServlet" method="post">
  <div id="apDiv1"></div>
  <div id="apDiv2">账户：</div>
  <div id="apDiv3">
    <input type="text" name="loginName" id="loginName">
  </div>
  <div id="apDiv4">密码：</div>
  <div id="apDiv5">
    <input type="password" name="loginPwd" id="loginPwd">
  </div>
  <div id="apDiv6">
    <input type="submit" name="button" id="button" value="提交">
    <input type="reset" name="button2" id="button2" value="重置">
  </div>
  </form>
  </body>
</html>
