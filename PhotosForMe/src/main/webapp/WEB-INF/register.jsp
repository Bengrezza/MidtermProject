<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" media="screen" href="styles/register.css" />
<title>Register New Account | Photography For Me</title>
</head>
<body>
<jsp:include page="navbar.jsp" />
          
<div class="input">
			<form action="register.do" method="POST" >
				<label>Account Info:</label><br>
				<div class="inputs">
				<input type="text" placeholder="Enter User Name"  name="username" required="required"  >
				<input type="password" placeholder="Enter Password"  name="password" required="required"  > <br>
				<input type="text" placeholder="Enter First Name"  name="firstname" required="required"  >
				<input type="text" placeholder="Enter Last Name"  name="lastname" required="required"  ><br>
				<input type="text" placeholder="Enter Email"  name="email" required="required"  >
				<input type="text" placeholder="Role" name="role" required="required">
				<br><br><br><label>Address:</label><br>
				<input type="text" placeholder="Enter Street "  name="street" required="required"  >
				<input type="text" placeholder="Enter Street2 "  name="street2"   > <br>
				<input type="text" placeholder="Enter City "  name="city" required="required"  >
				<input type="text" placeholder="Enter State "  name="state" required="required"  > <br>
				<input type="number" placeholder="Enter Postal code "  name="postalcode" required="required" >
				<input type="text" placeholder="Enter Phone number "  name="phonenumber" required="required"  >
				</div>
				<br>
				<button type="submit" class="btn">Register</button>
			
			</form>
	</div>
	<form action="home">
		<button type="submit" class="home-btn btn">Home Page</button>
	</form>
	    <script src="main.js"></script>
</body>
</html>