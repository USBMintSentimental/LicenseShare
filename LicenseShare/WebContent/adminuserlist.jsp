<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="sougou.admin.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="sougou.*"%>
<%@ page import="sougou.link.*"%>
<%@ page import="sougou.dao.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LicenseShare</title>
<link rel="stylesheet" href="css/style.css">
<link rel="shortcut icon" href="images/admin.ico"/>
<script type="text/javascript"> 
<!-- 
function check(){
	if(window.confirm('削除しますか？')){
		return true;
	}else{
		window.alert('キャンセルされました');
		return false;
	}
}
-->
</script>
</head>
<body id="top">

<div id="container">

<br>

<div id="contents">

<div id="main">

<section>
<h2>　</h2>
<jsp:useBean id="UserDataBean" class="sougou.UserDataBean" scope="session" />
<div align="center">
<br>
<table border="1">
<tr>
<th>ID</th>
<th>ユーザー名</th>
<th>ロール</th>
<th>更新</th>
<th>削除</th>
</tr>
<%
ArrayList<UserBean> userArray = UserDataBean.getUserArray();
UserDAO user = new UserDAO();
OnlyDAO only = new OnlyDAO();
for(UserBean record : userArray){
%>
<tr>
<td><div align="center">
<%=record.getUserid()%>
</div></td>

<td><div align="center">
<%=record.getUsername()%>
</div></td>

<td><div align="center">
<%=only.getRole(record.getUserid())%>
</div></td>

<td><div align="center">
<form action="UserUpdatePageServlet" method="post">
<input type="hidden" name="userid" value="<%=record.getUserid()%>">
<input type="submit" value="" style="WIDTH: 20px; HEIGHT: 20px"></form>
</div></td>

<td><div align="center">
<form action="UserDeleteServlet" method="post" onSubmit="return check()">
<input type="hidden" name="userid" value="<%=record.getUserid()%>">
<%
if(only.getRole(record.getUserid()).equals("admin")){
%>
<input type="submit" value="" style="WIDTH: 20px; HEIGHT: 20px" disabled>
<%
}else{
%>
<input type="submit" value="" style="WIDTH: 20px; HEIGHT: 20px">
<%
}
%>
</form></div></td>

</tr>
<%
}
%>
</table>
<br>

</div>
</div>
<!--/main-->

<div id="sub">

<div align="center">
<ul class="submenu mb10">
<li><a href="index.jsp">ホーム</a></li>
<li><a href="AdminUserListServlet">ユーザー管理</a></li>
<li><a href="AdminLicenseListServlet">資格管理</a></li>
</ul>

<img src="images/logo.png" width="200" height="50">

</div>
<!--/sub-->

</div>
<!--/contents-->

</div>
<!--/container-->

</body>
</html>