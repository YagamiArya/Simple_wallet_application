<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<style type="text/css">
a {
	text-decoration: none;
	color: white;
}

a:hover {
	text-decoration: none;
	color: white;
}
</style>

<title>Withdraw Money</title>
</head>
<body>
	<div class="container">
		<br>

		<div class="jumbotron"
			style="background-color: crimson; color: white; padding: 20px;">
			<div class="float-right">
				<a href="logout" class="btn btn-default"
					style="padding: 10px 20px; background-color: lightgrey; color: black; margin: 0px 0px 0px 0px; border-radius: 15px;">Log
					out</a>
			</div>
			<h1 class="display-4">Arya's Wallet</h1>
			<p class="lead">This is a simple wallet application.</p>
		</div>
		<div>
			<div class="container-fluid">
				<h4 class=""
					style="color: green; background-color: lightgrey; font-family: caveat; padding: 20px; margin: 0px;">
					View Transactions 
					<div class="float-right"><a href="dashboard?userId=${user.getUserId() }" class="btn btn-primary">Return to Dashboard</a></div>					
					</h4>
				<br>
				<div class="row">
					<div class="col-sm-3 col-md-6 col-lg-4" style="display: block;">
						<p style="height: 200px; margin: 0px; padding-left: 10px;"
							class="border border-dark">
							<br> <br> Your Account Balance is ${user.getBalance() }
							<img alt="paymentIcon" src="/Files/paymentIcon.png" height="20%;">
							<br> <br>
						</p>
					</div>
					<div class="col-sm-9 col-md-6 col-lg-8"
						style="background-color: lightgrey; color: black; padding: 20px;">
						<div class="row">
							<table class="table table-hover">
								<thead class="table-dark">
									<tr>
										<th>Id</th>
										<th>Date</th>
										<th>Type</th>
										<th>Amount</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${transactions }" var="transaction">
										<tr>
											<td>${transaction.transactionId }</td>
											<td>${transaction.dateOfTransaction }</td>
											<td>${transaction.transactionType }</td>
											<td>${transaction.transactionAmount }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<br>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>