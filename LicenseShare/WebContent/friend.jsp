<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="sougou.*"%>
<%@ page import="sougou.link.*"%>
<%@ page import="sougou.dao.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.io.FileReader"%>
<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.text.DecimalFormat"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LicenseShare</title>
<link rel="stylesheet" href="css/style.css">
<link rel="shortcut icon" href="images/favicon.ico"/>
<script type="text/javascript"> 
<!-- 
function check(){
	if(window.confirm('解除しますか？')){
		return true;
	}else{
		return false;
	}
}
-->
</script>
<style type="text/css">
p.br { line-height: 50%; }
div.br {
  width: 330px;
  word-wrap: break-word;
}
</style>
</head>
<body id="top">

<div id="container">

<br>
<%
OnlyDAO only = new OnlyDAO();
UserDAO user = new UserDAO();
String userid = request.getRemoteUser();
%>
<div id="contents">

<div id="main">

<section>
<h2>　</h2>
<jsp:useBean id="FriendDataBean" class="sougou.FriendDataBean" scope="session" />
<div align="center">
<br>
<table border="1">
<tr><th>フレンドID</th><th>フレンド名</th><th>解除</th></tr>
<%
ArrayList<FriendBean> friendArray = FriendDataBean.getFriendArray();
for(FriendBean record : friendArray){
	if(record.getFriendid().equals(userid)){
		if(record.getCheck().equals("comp")){
%>
<tr>
<td><div align="center"><%=record.getUserid()%></div></td>
<td><div align="center"><a href="Browse?id=<%=record.getUserid()%>"><%=only.getUsername(record.getUserid())%></a></div></td>

<td><div align="center">
<form action="FriendDeleteServlet" method="post" onSubmit="return check()">
<input type="hidden" name="userid" value="<%=record.getUserid()%>">
<input type="hidden" name="friendid" value="<%=record.getFriendid()%>">
<input type="submit" value="" style="WIDTH: 20px; HEIGHT: 20px"></form>
</div></td>

</tr>
<%
		}
	}
	if(record.getUserid().equals(userid)){
		if(record.getCheck().equals("comp")){
%>
<tr>
<td><div align="center"><%=record.getFriendid()%></div></td>
<td><div align="center"><a href="Browse?id=<%=record.getFriendid()%>"><%=only.getUsername(record.getFriendid())%></a></div></td>

<td><div align="center">
<form action="FriendDeleteServlet" method="post" onSubmit="return check()">
<input type="hidden" name="userid" value="<%=request.getRemoteUser()%>">
<input type="hidden" name="friendid" value="<%=record.getFriendid()%>">
<input type="submit" value="" style="WIDTH: 20px; HEIGHT: 20px"></form>
</div></td>

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