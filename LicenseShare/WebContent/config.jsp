<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="sougou.dao.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LicenseShare</title>
<link rel="stylesheet" href="css/style.css">
<link rel="shortcut icon" href="images/favicon.ico"/>
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
String userid = request.getRemoteUser();
%>
<form action="UserUpdateServlet" method="post" onSubmit="return check()">
<p class="br"><input type="text" name="userid" value="<%= userid %>" readonly required></p>
<p class="br"><input type="text" name="username" value="<%= only.getUsername(userid) %>" placeholder="名前" required><br></p>
<p class="br"><input type="password" name="oldpasswd" value="" placeholder="パスワード　10文字以下" maxlength="10" required><br></p>
<p class="br"><input type="password" name="newpasswd1" value="" placeholder="新パスワード1　10文字以下" maxlength="10" required><br></p>
<p class="br"><input type="password" name="newpasswd2" value="" placeholder="新パスワード2　10文字以下" maxlength="10" required><br></p>
<p class="br"><input type="submit" value="更新">　<input type="reset"></p>
</form>
</div>
</div>
<!--/main-->

<div id="sub">

<div align="center">
<ul class="submenu mb10">
<li><a href="index.jsp">ホーム</a></li>
<li><a href="LicenseListServlet">資格一覧</a></li>
<li><a href="AddLicenseServlet">資格追加</a></li>
<li><a href="ProfileServlet">プロフィール</a></li>
<li><a href="config.jsp">設定</a></li>
<li><a href="logout.jsp">ログアウト</a></li>
</ul>

<%
if(request.isUserInRole("admin")==true){
%>
<ul class="submenu mb10">
<li><a href="admin.jsp">管理者用</a></li>
</ul>
<%
}
%>

<img src="images/logo.png" width="200" height="50">

</div>
</div>
<!--/sub-->

</div>
<!--/contents-->

</div>
<!--/container-->

</body>
</html>