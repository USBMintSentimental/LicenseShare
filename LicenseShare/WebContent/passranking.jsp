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
<p class="br"><table border="1"><th>総所持資格ランキング</th></table></p>
<table border="1">
<tr><th>順位</th><th>ユーザーID</th><th>資格数</th></tr>
<jsp:useBean id="UserDataBean" class="sougou.UserDataBean" scope="session" />
<%
ArrayList<UserBean> userArray = UserDataBean.getUserArray();
UserDAO user = new UserDAO();
int rank=1;
for(UserBean record : userArray){
	if(record.getPass()>0){
%>
<tr>
<td><div align="center"><%=rank%></div></td>
<td><div align="center"><%=record.getUserid()%></div></td>
<td><div align="center"><%=record.getPass()%>個</div></td>
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
<li><a href="ProfileServlet">受験履歴</a></li>
<li><a href="config.jsp">設定</a></li>
<li><a href="logout.jsp">ログアウト</a></li>
</ul>

<%
only.setAccesscounter();
%>
<ul class="submenu mb10">
<li><a href="#">累計:<%= only.getAccesscounter() %>人目</a></li>
</ul>

<ul class="submenu mb10">
<li><a href="FriendServlet">友達一覧</a></li>
<li><a href="addfriend.jsp">友達申請</a></li>
<li><a href="FriendMutualServlet">友達認証</a></li>
</ul>

<ul class="submenu mb10">
<li><a href="CountRankingServlet">総受験回数ランキング</a></li>
<li><a href="PassRankingServlet">総所持資格ランキング</a></li>
</ul>

<%
session.setMaxInactiveInterval(-1);
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