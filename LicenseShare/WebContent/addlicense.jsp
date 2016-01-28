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
<script type="text/javascript"> 
<!-- 
function check(){
	if(window.confirm('登録しますか？')){
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
<jsp:useBean id="LicenseDataBean" class="sougou.LicenseDataBean" scope="session" />
<div align="center">
<br>
<form action="UserLicenseInsertServlet" method="post" onSubmit="return check()">
<p class="br"><select name="licenseid">
<%
ArrayList<LicenseBean> licenseArray = LicenseDataBean.getLicenseArray();
LicenseDAO license = new LicenseDAO();
for(LicenseBean record : licenseArray){
%>
<option value="<%= record.getLicenseid() %>"><%= record.getLicensename() %></option>
<%
}
%>
</select>　<input type="number" name="count" min="1" max="100000" placeholder="受験回数" required></p>
<p class="br"><textarea rows="5" cols="50" name="comment" placeholder="感想"></textarea></p>
<p class="br"><input type="submit" value="登録">　<input type="reset"></p>
</form>
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