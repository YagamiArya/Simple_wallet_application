<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>Arya's Wallet</title>
</head>
<body>
	<div class="container">
		<br>

		<div class="jumbotron"
			style="background-color: crimson; color: white;">
			<h1 class="display-4">Arya's Wallet</h1>
			<p class="lead">This is a simple wallet application.</p>
		</div>
		<div class="">
			<div class="row">
				<div class="col-md">
					<div class="jumbotron" style="background-color: green; color:white;">Welcome to the Wallet!
						<div><h2>${msg }</h2></div>
					</div>
				</div>
				<div class="col-md">
					<div class="container">
						<form action="registerUser" method="post">
							<div class="form-group">
								<label for="userId">UserId</label> <input type="text"
									class="form-control"  placeholder="Enter User ID"
									name="userId" required="required">
							</div>
							<div class="form-group">
								<label for="password">Password:</label> 
								<input type="password"
									class="form-control"  placeholder="Enter password"
									name="password" required="required">
							</div>
							<div class="form-group">
								<label for="name">Name:</label> 
								<input type="text"
									class="form-control"  placeholder="Enter Your Name"
									name="name" id="name" required="required">
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
							<button type="reset" class="btn btn-danger">Reset</button>
							
						</form>
					</div>
</body>
</html>

</div>
</div>
</div>
</div>

</body>
</html>