
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

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>

<meta charset="ISO-8859-1">
<style>
h2 {
	font-weight: bold;
	color: #58D68D;
}
</style>

<title>Movie Ticket Booking</title>

</head>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload="">


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
				<form action="#" method="get" style="text-align: center">



					<h2>Ticket Details</h2>
					<br>
					<p>
						BookingId:
						<c:out value="${data.getBookingId()}"></c:out>
					</p>
					<p>
						Movie Name:
						<c:out value="${data.getMovie()}"></c:out>
					</p>
					<p>
						Theater Name:
						<c:out value="${data.getTheater()}"></c:out>
					</p>
					<p>
						Booking Date:
						<c:out value="${data.getShowDate()}"></c:out>
					</p>
					<p>
						Show Time:
						<c:out value="${data.getShowTime()}"></c:out>
					</p>
					<p>
						No. Of Tickets:
						<c:out value="${data.getNoOfTickets()}"></c:out>
					</p>
					<p>
						Luxury Tickets:
						<c:out value="${data.getLuxuryTickets()}"></c:out>
					</p>
					<p>
						Premium Tickets:
						<c:out value="${data.getPremiumTickets()}"></c:out>
					</p>
					<p>
						Seat Numbers:
						<c:out value="${data.getSeatNumbers()}"></c:out>
					</p>
					<p>
						Screen:
						<c:out value="${data.getScreen()}"></c:out>
					</p>
					<p>
						Total Cost:
						<c:out value="${data.getTotalCost()}"></c:out>
					</p>
					<br>

					<h2>Thank you for Booking!!!</h2>



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
				<script type="text/javascript">
				history.pushState(null, document.title, location.href);
				window.addEventListener('popstate', function (event)
				{
				  history.pushState(null, document.title, location.href);
				});
				</script>
				<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
				<script type="text/javascript">
					swal(
							"CONGRATULATIONS!",
							"Your ticket is booked successfully and sent to your email!",
							"success");
				</script>
</body>

</html>