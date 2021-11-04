<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@page import="com.epam.booking.dto.SeatDTO"%>
<!DOCTYPE html>
<html>

<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>


<meta charset="ISO-8859-1">

<style>
h4 {
	font-weight: bold;
	color: #58D68D;
}
</style>
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

				<meta charset="ISO-8859-1">


				<script type="text/javascript">
					var mystorage = window.sessionStorage;
					window.onload = fun();
					function fun() {
						if (mystorage.getItem('loginStatus') === 'false')
							window.location.href = "/logout";
					}
					function countCheckboxes() {

						var inputElems = document
								.querySelectorAll('input[type="checkbox"]');

						var count = 0;
						for (var i = 0; i < inputElems.length; i++) {
							if (inputElems[i].checked === true) {
								count++;
							}
						}
						console.log(count);
						if (count < 1) {
							swal("Please select at least one seat!", {
								buttons : false,
								timer : 1000,
							});
							return false;
						}
						return true;
					}
				</script>

				<hr>
				<br>
				<h4 style="text-align: center">Please Choose Seats</h4>
				<form action="bookTicket" style="text-align: center" method="get"
					onSubmit="return countCheckboxes();">
					<hr style="width: 30%">
					<p>Screen This Side</p>
					<br>
					<%
						String seatNumbers = "";
						List<String> bookedSeats = (ArrayList) request.getAttribute("bookedSeats");
						List<SeatDTO> totalSeats = (List<SeatDTO>) request.getAttribute("totalSeats");
						for (SeatDTO entry : totalSeats) {
					%>
					<p><%=entry.getSeatType()%>
						<%
							for (int row = 1; row <= Integer.parseInt(entry.getSeatColumn()); row++) {
									if (bookedSeats.contains(entry.getSeatRow() + row)) {
						%>
						<input type="checkbox" name="seat" id="seat"
							value="<%=entry.getSeatRow() + row%>" disabled>
						<%
							} else {
						%>
						<input type="checkbox" name="seat" id="seat"
							value="<%=entry.getSeatRow() + row%>">
						<%
							}
								}
						%><br>
					</p>
					<%
						}
					%>



					<br>
					<button type="submit" class="btn btn-success" value="Create">NEXT</button>

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
					<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
				</form>
</body>

</html>