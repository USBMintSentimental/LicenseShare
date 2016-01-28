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
<form action="LicenseUpdateServlet" method="post" onSubmit="return check()">
<p class="br"><input type="text" name="licenseid" value="<%= (String)session.getAttribute("licenseid") %>" placeholder="ID" pattern="^[0-9A-Za-z]+$" required></p>
<p class="br"><input type="text" name="licensename" value="<%= only.getLicensename((String)session.getAttribute("licenseid")) %>" placeholder="資格名" required><br></p>
<p class="br"><input type="text" name="licensegroup" value="<%= only.getLicensegroup((String)session.getAttribute("licenseid")) %>" placeholder="団体名" required><br></p>
<p class="br"><input type="text" name="licenseprice" value="<%= only.getLicenseprice((String)session.getAttribute("licenseid")) %>" placeholder="受験料" pattern="^[0-9]+$" required><br></p>
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