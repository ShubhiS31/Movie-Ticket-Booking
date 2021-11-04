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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>

<style>
h6 {
	color: GREEN;
	align: center;
}
</style>

<script src="backNoWork.js" type="text/javascript"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">
				<br> <br>

				<%
					response.setHeader("Pragma", "no-cache");
					response.setHeader("Cache-Control", "no-store");
					response.setHeader("Expires", "0");
					response.setDateHeader("Expires", -1);
					session.invalidate();
				%>
				<h6 align="center">YOU ARE SUCCESSFULLY LOGGED OUT OF THE
					APPLICATION..........!</h6>
				<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
				<script type="text/javascript">
				swal("LOGGED OUT SUCCESFULLY!", " " ,"success");
				</script>
				<br> <br>
				<div>
					<form action="login">
						<input class="form-control btn btn-success" type="submit"
							value="Take me back to Login" />
					</form>
				</div>
</body>
</html>
