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
String friendid = (String)session.getAttribute("userid");
OnlyDAO only = new OnlyDAO();
%>

<section>
<jsp:useBean id="UserLicenseDataBean" class="sougou.UserLicenseDataBean" scope="session" />
<h2>　</h2>
<div align="center">
<br>
<table border="1">
<% 
if(only.getFriendstate(userid,friendid).equals("NOT NULL")){
	}else{
		String error = "相手のIDを登録していません";
		session.setAttribute("Error", error);
		getServletContext().getRequestDispatcher("/error.jsp").forward(request,response);
	}
if(only.getUserstate(userid,friendid).equals("NOT NULL")){
	}else{
		String error = "フレンド相互登録がされていません";
		session.setAttribute("Error", error);
		getServletContext().getRequestDispatcher("/error.jsp").forward(request,response);
	}
%>
<tr><th>資格ID</th><th>資格名</th></tr>
<%
ArrayList<UserLicenseBean> userlicenseArray = UserLicenseDataBean.getUserLicenseArray();
UserDAO user = new UserDAO();
LicenseDAO license = new LicenseDAO();
for(UserLicenseBean record : userlicenseArray){
	if(friendid.equals(record.getUserid())){
		if(record.getLicensepass().equals("合格")){
%>
<tr>
<td><div align="center"><%=record.getLicenseid()%></div></td>
<td><div align="center"><a href="License?id=<%=record.getLicenseid()%>"><%=only.getLicensename(record.getLicenseid())%></a></div></td>

</tr>
<%
		}
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