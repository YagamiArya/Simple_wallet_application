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
		<c:if test="${msg!= null }">
			<div class="alert alert-success" role="alert"><h3>${msg}</h3></div>
		</c:if>
		<div class="text-center">
			<p>Welcome to the wallet please sign in or register to
				countinue...</p>
			<p class="lead">
				<a href="signInPage" class="btn btn-success">Sign in</a> <a
					href="registerPage" class="btn btn-primary">Register</a>
			</p>
		</div>
	</div>

</body>
</html>