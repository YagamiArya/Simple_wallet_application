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
<style type="text/css">
	a{
	text-decoration: none;
	color: white;
	}
	a:hover{
	text-decoration: none;
	color: white;
	}
</style>
	
<title>user's dashboard</title>
</head>
<body>
	<div class="container">
		<br>

		<div class="jumbotron"
			style="background-color: crimson; color: white;">
			<div class="float-right">
				<a href="logout" class="btn btn-default" style="padding:10px 20px;background-color:lightgrey; color:black; margin:0px 0px 0px 0px; border-radius:15px;">Log out</a>
			</div>
			<h1 class="display-4">Arya's Wallet</h1>
			<p class="lead">This is a simple wallet application.
			</p>
		</div>
		<div class="text-center">
			<div class="container-fluid">
				<h1 class="jumbotron" style="color:green; background-color:lightgrey; font-family:caveat; padding:10px; 
				margin:0px;">Welcome back ${user.getName()} </h1><br>
				<div class="row">
					<div class="col-sm-3 col-md-6 col-lg-4"
						style=" display:block;">
						<p style="height:200px; margin:0px; 	" class="border border-dark"><br><br>
						Your Account Balance is ${user.getBalance()} <img alt="paymentIcon" src="/Files/paymentIcon.png" height="20%;">
						<br><br>
						</p>
					</div>
					<div class="col-sm-9 col-md-6 col-lg-8"
						style="background-color: lightgrey; color:black;">
						<p>Make payments secure...</p>
						<div class="row row-cols-3">
							<div class="col">
								<a href="addMoney?userId=${user.getUserId() }"> <img alt="addMoney"
									src="/Files/deposit-icon.png" height="70px">
								<br>Deposit Money
								</a>
							</div>
							<div class="col">
								<a href="withdrawPage?userId=${user.getUserId() }"> <img alt="withdraw Money"
									src="/Files/withdraw.png" height="70px">
								<br>withdraw Money
								</a>
							</div>
							<div class="col">
								<a href="transactions?userId=${user.getUserId() }"> <img alt="transactions"
									src="/Files/transaction.png" height="70px">
								<br>view transactions
								</a>
							</div>
						</div>



					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>