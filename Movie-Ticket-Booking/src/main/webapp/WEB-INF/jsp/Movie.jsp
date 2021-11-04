
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
	font-weight: bold;
	color: #58D68D;
}
</style>
<title>Movie Ticket Booking</title>
</head>
<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">

		<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" href="/">Home</a></li>

			<div>
				<form action="logout-success" method="post">
					<button type="submit" class="btn btn-danger">Logout</button>
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

				<h4>Please Choose your preferred Movie</h4>
				<form method="get" action="theater">
					<c:forEach var="movie" items="${movies}">
						<input type="radio" name="movie"
							value="${movie.movieId}-${movie.movieName}" required>
						<c:out value="${movie.movieName}"></c:out>
						<br>
					</c:forEach>
					<br>
					<button type="submit" class="btn btn-success" value="Create">NEXT</button>
				</form>
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