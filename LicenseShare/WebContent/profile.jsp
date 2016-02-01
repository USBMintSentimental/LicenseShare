<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="sougou.*"%>
<%@ page import="sougou.link.*"%>
<%@ page import="sougou.dao.*"%>
<%@ page import="java.text.DecimalFormat"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LicenseShare</title>
<link rel="stylesheet" href="css/style.css">
<link rel="shortcut icon" href="images/favicon.ico"/>
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

<%
String userid = request.getRemoteUser();
%>

<section>
<jsp:useBean id="UserLicenseDataBean" class="sougou.UserLicenseDataBean" scope="session" />
<h2>　</h2>
<div align="center">
<br>
<table border="1">
<tr><th>資格ID</th><th>資格名</th><th>受験回数</th><th>削除</th></tr>
<%
ArrayList<UserLicenseBean> userlicenseArray = UserLicenseDataBean.getUserLicenseArray();
UserDAO user = new UserDAO();
LicenseDAO license = new LicenseDAO();
OnlyDAO only = new OnlyDAO();
for(UserLicenseBean record : userlicenseArray){
	if(userid.equals(record.getUserid())){
%>
<tr>
<td><div align="center"><%=record.getLicenseid()%></div></td>
<td><div align="center"><a href="License?id=<%=record.getLicenseid()%>"><%=only.getLicensename(record.getLicenseid())%></a></div></td>
<td><div align="center"><%=only.getLicenseusercount(record.getLicenseid(),request.getRemoteUser())%></div></td>

<td><div align="center">
<form action="UserLicenseDeleteServlet" method="post" onSubmit="return check()">
<input type="hidden" name="licenseid" value="<%=record.getLicenseid()%>">
<input type="hidden" name="userid" value="<%=request.getRemoteUser()%>">
<input type="hidden" name="licensepass" value="<%=record.getLicensepass()%>">
<input type="submit" value="" style="WIDTH: 20px; HEIGHT: 20px"></form>
</div></td>

</tr>
<%
	}
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
<li><a href="LicenseListServlet">資格一覧</a></li>
<li><a href="AddLicenseServlet">資格追加</a></li>
<li><a href="ProfileServlet">プロフィール</a></li>
<li><a href="config.jsp">設定</a></li>
<li><a href="logout.jsp">ログアウト</a></li>
</ul>

<%
DecimalFormat df = new DecimalFormat("000000");
only.setAccesscounter();
%>
<ul class="submenu mb10">
<li><a href="#"><%= df.format(only.getAccesscounter()) %></a></li>
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