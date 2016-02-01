<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="sougou.*"%>
<%@ page import="sougou.link.*"%>
<%@ page import="sougou.dao.*"%>
<%@ page import="java.text.DecimalFormat"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LicenseShare</title>
<link rel="stylesheet" href="css/style.css">
<link rel="shortcut icon" href="images/favicon.ico"/>
<style type="text/css">
p.br { line-height: 50%; }
</style>
</head>
<body id="top">

<div id="container">

<br>
<%
OnlyDAO only = new OnlyDAO();
%>
<div id="contents">

<div id="main">

<section>
<h2>　</h2>
<div align="center">
<p class="br"></p>
<p class="br"><table border="1"><th>総受験回数ランキング</th></table></p>
<table border="1">
<tr><th>順位</th><th>団体名</th><th>資格ID</th><th>資格名</th><th>受験料(税込)</th><th>受験回数</th></tr>
<jsp:useBean id="LicenseDataBean" class="sougou.LicenseDataBean" scope="session" />
<%
ArrayList<LicenseBean> licenseArray = LicenseDataBean.getLicenseArray();
UserDAO user = new UserDAO();
LicenseDAO license = new LicenseDAO();
int rank=1;
for(LicenseBean record : licenseArray){
	if(record.getLicensecount()>0){
%>
<tr>
<td><div align="center"><%=rank%></div></td>
<td><div align="center"><%=record.getLicensegroup()%></div></td>
<td><div align="center"><%=record.getLicenseid()%></div></td>
<td><div align="center"><a href="License?id=<%=record.getLicenseid()%>"><%=record.getLicensename()%></a></div></td>
<td><div align="center"><%=record.getLicenseprice()%>円</div></td>
<td><div align="center"><%=record.getLicensecount()%>回</div></td>
</tr>
<%
rank++;
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