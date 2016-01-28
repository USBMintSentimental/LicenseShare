<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="sougou.*"%>
<%@ page import="sougou.dao.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LicenseShare</title>
<link rel="stylesheet" href="css/style.css">
<link rel="shortcut icon" href="images/favicon.ico"/>
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
OnlyDAO only = new OnlyDAO();
%>

<section>
<h2><%= only.getLicensename(licenseid) %></h2>
<div align="center">
<br>
<p class="br">団体名:<%= only.getLicensegroup(licenseid) %></p>
<p class="br">受験料:<%= only.getLicenseprice(licenseid) %>円(税込)</p>
<p class="br">登録日:<%= only.getLicensecreatedate(licenseid) %></p>
<br>
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