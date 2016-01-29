<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LicenseShare</title>
<link rel="stylesheet" href="css/style.css">
<link rel="shortcut icon" href="images/favicon.ico"/>
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
String e=(String)session.getAttribute("Except");
%>
<p><%= e %>
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

<ul class="submenu mb10">
<li><a href="CountRankingServlet">総受験回数ランキング</a></li>
<li><a href="PassRankingServlet">総所持資格ランキング</a></li>
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