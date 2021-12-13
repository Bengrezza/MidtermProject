<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-sm"></div>

		<div class="col-sm">
			<form action="register.do" method="POST" >
				<label>User Name:</label>
				<input type="text" placeholder="Enter User Name"  name="username" required="required"  >
				<input type="password" placeholder="Enter Password"  name="password" required="required"  >
				<input type="text" placeholder="Enter Email"  name="email" required="required"  >
				<input type="text" placeholder="Enter First Name"  name="firstname" required="required"  >
				<input type="text" placeholder="Enter Last Name"  name="lastname" required="required"  >
				Address
				<input type="text" placeholder="Enter Street "  name="street" required="required"  >
				<input type="text" placeholder="Enter Street2 "  name="street2" required="required"  >
				<input type="text" placeholder="Enter City "  name="city" required="required"  >
				<input type="text" placeholder="Enter State "  name="state" required="required"  >
				<input type="number" placeholder="Enter Postal code "  name="postalcode" required="required" >
				<input type="text" placeholder="Enter Phone number "  name="postalcode" required="required"  >
				
				<button type="submit" >Register </button>
			
			</form>
	
			<form action="home">
			<button type="submit"> Home Page</button>
			</form>
		</div>
		<div class="col-sm">
		</div>
	</div>
</div>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>