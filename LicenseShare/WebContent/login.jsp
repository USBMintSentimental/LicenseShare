<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LicenseShare</title>
<style type="text/css">
</style>
</head>
<body>
<div align="center">
<h2>ログイン</h2>
<form action="j_security_check" method="post">
<br><input type="text" name="j_username" placeholder="ID" pattern="^[0-9A-Za-z]+$" autofocus required><br>
<br><input type="password" name="j_password" placeholder="パスワード" pattern="^[0-9A-Za-z]+$" required><br><br>
<input type="submit" value="ログイン">
<input type="reset">
</form>
<br>
<a href="index.jsp">画面が変わらない場合はこちらから</a><br>
<br>
<a href="http://<%= request.getLocalAddr() %>:8080/Register/">新規登録</a>
</div>
</body>
</html>