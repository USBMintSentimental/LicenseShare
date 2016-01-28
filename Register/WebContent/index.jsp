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
<form action="UserInsertServlet" method="post">
<h2>新規登録</h2>
<br><input type="text" name="userid" maxlength="10" placeholder="ID" pattern="^[0-9A-Za-z]+$" autofocus required><br>
<br><input type="text" name="username" placeholder="名前" required><br>
<br><input type="password" name="passwd" placeholder="パスワード" pattern="^[0-9A-Za-z]+$" required><br><br>
<input type="submit" value="登録">
<input type="reset">
</form>
</div>
</body>
</html>