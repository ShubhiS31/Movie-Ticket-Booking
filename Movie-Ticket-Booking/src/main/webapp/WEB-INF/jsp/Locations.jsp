
<%
	if (session != null) {
		if (session.getAttribute("userid") == null) {
			response.sendRedirect("Login.jsp");
		}
	}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<style>
h4 {
font-weight : bold;
color : #58D68D;
}

</style>

<title>Movie Ticket Booking</title>
</head>
<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">

		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link"
				href="/jsp/Locations.jsp">Home</a></li>

			<div>
				<form action="Logout" method="post">
					<button type="submit" class="btn btn-danger" value="logout">Logout</button>
				</form>
			</div>
			</li>
		</ul>
	</nav>
	<br>
	<br>
	<br>
	<br>

	<br>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">
				<form method="get" action="Movie">

					<div>
						<h4>Select your preferred location:</h4>


					</div>
					<br>

					<div >
						<c:forEach var="location" items="${locations}">
							<input type="radio" name="location"
								value="${location.locationId}-${location.locationName}" required>
							<c:out value="${location.locationName}"></c:out>
							<br>
						</c:forEach>
					</div>
					<br>

					<button type="submit" class="btn btn-success" value="Create">NEXT</button>
				</form>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

</body>
</html>