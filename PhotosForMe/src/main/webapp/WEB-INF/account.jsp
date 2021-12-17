<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<nav class="navbar navbar-expand-sm">
			<img src="images/logo.png" alt="Photography For Me"
				class="img-responsive" /> <a class="navbar-brand" href="home">PhotographyForMe</a>
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
			<br> <br> <br> <br> <br> <br>
		</div>
		<div class="row">

			<div id="leftcolumnpage" class="col-sm-3">
				<img src="images/logo.png" alt="Photography For Me"
					class="img-responsive-profile-pic" />
				<c:if test="${not empty photographer }">
					<div class="row">
						<div class="col-sm-12">
							<p id="rating">Rating ${chs[0].rating }, ${user.firstName },
								${user.lastName } Location: ${user.address.city},
								${user.address.state})</p>
						</div>
					</div>
				</c:if>
				<div id="leftcolumntoprow" class="row">
					<div class=" d-flex justify-content-center">
						<div class="col-sm-12 ">column 1 Favorite photographers</div>
					</div>

				</div>

				<div id="leftcolumnmiddlerow" class="row">
					<button class="accordion">Open contract(s)</button>
					<div class="panel">
						<c:forEach var="contract" items="${user.contracts}">
							<c:if test="${contract.closed < 1 }">
								<p>${contract.title },${contract.description },
									${contract.location }, ${contract.eventStart },
									${contract.eventEnd }, ${contract.photoDeliveryBy }</p>
							</c:if>
						</c:forEach>
					</div>
				</div>

				<div id="leftcolumnbottomrow" class="row">
					<button class="accordion">Closed Contract(s)</button>
					<div class="panel">
						<c:forEach var="contract" items="${user.contracts}">
							<c:if test="${contract.closed > 0 }">
								<p>${contract.title },${contract.description },
									${contract.location }, ${contract.eventStart },
									${contract.eventEnd }, ${contract.photoDeliveryBy }</p>
							</c:if>
						</c:forEach>
					</div>

				</div>
				<c:if test="${not empty photographer  }">
					<!--Testing to see if they are a photographer to give a list of client account they worked with.  -->

					<div id="leftcolumntoprowphoto" class="row">
						<button class="accordion">Current client</button>
						<div class="panel">
							<c:forEach var="contract" items="${photographer.contracts}">
								<c:if test="${contract.closed < 1 }">
						<p>${contract.user.firstName}, ${contract.user.lastName }, ${contract.user.email }, ${contract.user.address.phone }</p>
						</c:if></c:forEach>
						</div>

					</div>
					<div id="leftcolumnbottomrowphoto" class="row">
						<button class="accordion">Previous Client(s)</button>
						<div class="panel">
							<c:forEach var="contract" items="${photographer.contracts}">
								<c:if test="${contract.closed > 0 }">
						<p>${contract.user.firstName}, ${contract.user.lastName }, ${contract.user.email }, ${contract.user.address.phone }</p>
						</c:if></c:forEach>
						</div>

					</div>
				</c:if>
			</div>

			<div id="middlecolumnpage" class="col-sm-6">
				<p>column 2</p>

				<c:if test="${not empty photographer}">
					<!--Testing to see if they are a photographer to give album editing of contract they have done.  -->
					<div id="middlecolumntoprow" class="row">
						<div class="col-sm-12 ">
							<img src="${photographer.businessLogo }" alt="Photography For Me"
								class="img-responsive" /> <a class="navbar-brand" href="#">photographer.businessLogo</a>
							<p>${photographer.description}</p>
						</div>
					</div>
					<div id="middlecolumnmiddlerow" class="row">
						<div class="col-sm-12 ">
							<c:forEach var="galler" items="${photographer.gallery }">
							<button class="accordion">${galler.title}</button>
						${galler.description}
						<div class="panel">
						<c:forEach var="image" items="${galler.images }">
						<img alt="${image.title}" src="${ image.urlLink}">
						</c:forEach>
						</div>
							</c:forEach>
						</div>
					</div>
				</c:if>

				<div id="middlecolumnbottomrow" class="row">
					<div class="col-sm-12">
						<p>User album(s)</p>
					</div>
				</div>


			</div>

			<div id="rightcolumnpage" class="col-sm-3">
				column 3 Welcome User(signed in)
				<c:if test="${not empty photographer }">
					<div id="contact">
						<button id=contactPhotographer type="button">Contact
							Photographer</button>
					</div>
				</c:if>
				<div id="rightcolumntoprow" class="row">
					<button class="accordion">Account Information</button>
					<div class="panel">
						<p>User name:</p>
						<input type="text" name="username" placeholder="Username">
						<p>Password:</p>
						<input type="text" name="password" placeholder="password">
						<p>Email address:</p>
						<input type="text" name="email" placeholder="email">
						<p>Address:</p>
						<input type="text" name="address" placeholder="address">
						<p>Payment information:</p>
						<input type="text" name="payment" placeholder="payment">
						<p>Profile Picture:</p>
						<input type="text" name="profilepic" placeholder="profilepic">
						<br>
						<button class="button">Update Account</button>

						<button class="button">Deactivate Account</button>
					</div>
				</div>
				<c:if test="${ not empty photographer }">
					<!--Testing to see if they are a photographer to give additional editing.  -->
					<div id="rightcolumnbottomrow" class="row">
						<button class="accordion">Update Profile Page</button>
						<div class="panel">
							<p>Navigation bar background color</p>
							<input type="text" name="navbackgroundcolor"
								placeholder="backgroundcolor">
							<p>Page background</p>
							<input type="text" name="pagebackgroundcolor"
								placeholder="backgroundcolor">
							<p>font color</p>
							<input type="text" name="fontcolor" placeholder="fontcolor">
							<p>nav font color</p>
							<input type="text" name="navfontcolor" placeholder="fontcolor">
							<p>border color</p>
							<input type="text" name="bordercolor" placeholder="bordercolor">
							<p>accordion default color</p>
							<input type="text" name="accordianbasecolor"
								placeholder="accordianbasecolor"> <br>
							<p>accordion hover/active color</p>
							<input type="text" name="hoveractivecolor"
								placeholder="hoveractivecolor"> <br>
							<button class="button">Update Profile Page</button>
						</div>
					</div>
				</c:if>
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