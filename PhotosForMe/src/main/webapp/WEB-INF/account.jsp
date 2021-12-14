<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" media="screen"
	href="styles/account.css" />
<meta charset="UTF-8">
<title>account page | Photography For Me</title>
</head>
<body>
	<div class="navbar">

		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<img src="images/logo.png" alt="Photography For Me"
				class="img-responsive" /> <a class="navbar-brand" href="#">Brand
				Name</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="home">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#"> View
							Photographers</a></li>
					<li class="nav-item"><a class="nav-link" href="home">Logout</a></li>
				</ul>
				<input type="text" placeholder="search...">
			</div>
		</nav>
	</div>
	<div id="container" class="container-fluid">
		<div id="header" class="row">
			<br> <br> <br> <br> <br>

		</div>
		<div class="row">
			<div id="leftcolumnpage" class="col-sm-4 my-3 border">
				<div id="leftcolumntoprow" class="row">
					<div class="col-sm-12 ">column 1 Favorite photographers,</div>
				</div>
				<br> <br> <br> <br> <br> <br> <br>
				<br> <br> <br> <br> <br> <br> <br>
				<br> <br> <br> <br> <br> <br> <br>
				<br>
				<div id="leftcolumnmiddlerow" class="row">
					<button class="accordion">active contract(s)(drop down
						menu of messages)</button>
					<div class="panel">
						<p>No active contract(s)</p>
					</div>
				</div>
				<br> <br> <br> <br> <br> <br> <br>
				<br> <br> <br> <br>
				<div id="leftcolumnbottomrow" class="row">
					<button class="accordion">Closed Contract(s)(drop down to
						view)</button>
					<div class="panel">
						<p>No closed contract(s)</p>
					</div>

				</div>
				<br> <br> <br> <br> <br> <br> <br>
				<br> <br> <br> <br> <br>

			</div>
			<div id="middlecolumnpage" class="col-sm-4 my-3 border">
				column 2
				<div class="row">
					<div class="col-sm-12 border">row 2 col 2.1</div>
				</div>
				<div class="row">
					<div class="col-sm-12  border">row 2 col 2.1</div>
				</div>
			</div>
			<div id="rightcolumnpage" class="col-sm-4 my-3 border">
				column 3 Welcome User(signed in)
				<div id="leftcolumnbottomrow" class="row">
					<button class="accordion">Account Information</button>
					<div class="panel">
						<p>Username</p>
						<input type="text" name="username" placeholder="Username">
						<p>Password</p>
						<input type="text" name="password" placeholder="password">
						<p>Email address</p>
						<input type="text" name="email" placeholder="email">
						<p>Address</p>
						<input type="text" name="address" placeholder="address">
						<p>Payment information</p>
						<input type="text" name="payment" placeholder="payment">
						<p>Profile Picture</p>
						<input type="text" name="profilepic" placeholder="profilepic">
						<br>
						<button class="button">Update Account</button>
						<button class="button">Deactivate Account</button>
					</div>
					<div class="panel">
					</div>
					<div class="panel">
					</div>
					<div class="panel">
					</div>
					<div class="panel">
					</div>
					<div class="panel">
					</div>
					<div class="panel">
					</div>
					<div class="panel">
					</div>
				</div>

			</div>


		</div>
	</div>

	<script>
		var acc = document.getElementsByClassName("accordion");
		var i;

		for (i = 0; i < acc.length; i++) {
			acc[i].addEventListener("click", function() {
				this.classList.toggle("active");
				var panel = this.nextElementSibling;
				if (panel.style.display === "block") {
					panel.style.display = "none";
				} else {
					panel.style.display = "block";
				}
			});
		}
	</script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
	<script src="main.js"></script>
</body>
</html>