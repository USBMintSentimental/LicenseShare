<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	if(window.confirm('更新しますか？')){
		return true;
	}else{
		window.alert('キャンセルされました');
		return false;
	}
}
-->
</script>
<style type="text/css">
p.br { line-height: 50%; }
</style>
</head>
<body id="top">

<div id="container">

<br>

<div id="contents">

<div id="main">

<section>
<h2>　</h2>
<div align="center">
<br>
<%
OnlyDAO only=new OnlyDAO();
%>
<form action="AdminUserUpdateServlet" method="post" onSubmit="return check()">
<p class="br"><input type="text" name="userid" value="<%= (String)session.getAttribute("userid") %>" readonly required></p>
<p class="br"><input type="text" name="username" value="<%= only.getUsername((String)session.getAttribute("userid")) %>" placeholder="名前" required><br></p>
<p class="br"><input type="password" name="passwd" value="<%= only.getPassword((String)session.getAttribute("userid")) %>" placeholder="名前" required><br></p>
<%
if(only.getRole((String)session.getAttribute("userid")).equals("admin")){
%>
<p class="br">
<select name="role">
<option value="admin">admin</option>
<option value="user">user</option>
</select>
</p>
<%
}else{
%>
<p class="br">
<select name="role">
<option value="user">user</option>
<option value="admin">admin</option>
</select>
</p>
<%
}
%>
<p class="br"><input type="submit" value="更新">　<input type="reset"></p>
</form>
</div>
</div>
<!--/main-->

<div id="sub">

<div align="center">
<ul class="submenu mb10">
<li><a href="index.jsp">ホーム</a></li>
<li><a href="AdminUserListServlet">ユーザー管理</a></li>
<li><a href="AdminLicenseListServlet">資格管理</a></li>
<li><a href="AdminUserLicenseListServlet">所持資格管理</a></li>
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