<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" media="screen" href="styles/login.css" />
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<jsp:include page="navbar.jsp" />

<main>
<form action="login.do" method="POST" class="logins">
	User Name:
	<input type="text" placeholder="Enter User Name"  name="username" required="required" class="un">
	<br>
	Password:
	<input type="password" placeholder="Enter Password"  name="password" required="required" class="pw">
	<br>
	<button type="submit" class="login-button btn" >Login </button>
</form>
<form action="register" class="register-button">
<button type="submit" class="btn"> Create an Account</button>
</form>
</main>
    <script src="main.js"></script>
</body>
</html>