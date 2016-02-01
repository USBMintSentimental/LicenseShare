<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="sougou.*"%>
<%@ page import="sougou.dao.UserDAO"%>
<%@ page import="sougou.dao.LicenseDAO"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LicenseShare</title>
<link rel="stylesheet" href="css/style.css">
<link rel="shortcut icon" href="images/favicon.ico"/>
<script type="text/javascript"> 
<!-- 
function check(){
	if(window.confirm('登録しますか？')){
		return true;
	}else{
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
<jsp:useBean id="LicenseDataBean" class="sougou.LicenseDataBean" scope="session" />
<div id="contents">

<div id="main">

<%
ArrayList<LicenseBean> licenseArray = LicenseDataBean.getLicenseArray();
LicenseBean record=new LicenseBean();
String licenseid = (String)session.getAttribute("licenseid");
UserDAO user = new UserDAO();
LicenseDAO license = new LicenseDAO();
%>

<section>
<h2>　</h2>
<div align="center">
<br>
<form action="LicenseInsertServlet" method="post" onSubmit="return check()">
<p class="br"><input type="text" name="licenseid" placeholder="ID" pattern="^[0-9A-Za-z--]+$" required></p>
<p class="br"><input type="text" name="licensename" placeholder="資格名" required></p>
<p class="br"><input type="text" name="licensegroup" value="" placeholder="団体名" required><br></p>
<p class="br"><input type="text" name="licenseprice" value="" placeholder="受験料" pattern="^[0-9]+$" maxlength="6" required><br></p>
<p class="br"><input type="submit" value="登録">　<input type="reset"></p>
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
</ul>

<div align="center">
<ul class="submenu mb10">
<li><a href="licenseinsert.jsp">資格追加</a></li>
</ul>

<img src="images/logo.png" width="200" height="50">

</div>
<!--/sub-->

</div>
</div>
<!--/sub-->

</div>
<!--/contents-->

</div>
<!--/container-->

</body>
</html>