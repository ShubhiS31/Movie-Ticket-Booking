<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Login Page</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<style>
h3 {
	color: red;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">
				<br>
				<br>
				<h1 align="center" class="text-info">Welcome to Movie Ticket
					Booking!</h1>
				<br>
				<h2 align="center" text="b" font-size="3em">REGISTER HERE</h2>
				<br> <br> <h3 align = "center">${message}</h3>
				<br>
				<form action="/registerUser" method="POST">
					<input name="username" class="form-control" title="Username"
					value="" placeholder="Username " size="30" maxlength="50" required = "required" /> <br>
					<input name="password" type="password" class="form-control"
						title="Password" placeholder="Password" value="" size="30"
						maxlength="48" required = "required" /> <br> <input
						class="form-control btn btn-success" type="submit"
						value="REGISTER" />
				</form>
				<br>
				<form action="login">
				<input
						class="form-control btn btn-success" type="submit"
						value="BACK TO LOGIN" /></form>
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