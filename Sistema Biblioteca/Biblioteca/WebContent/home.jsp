<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">

		<!-- Static navbar -->
		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"><img src="livros.png"/></a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="login.jsp">Login</a></li>
					<li><a href="contato.jsp">Contato</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid --> </nav>

		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>Biblioteca Online</h1>
			<p>Bem-vindo ao portal Biblioteca Online da Faculdade Impacta</p>
		</div>


		<!-- /container -->

		<div class="col-md-3">
			<input type="text" class="form-control" placeholder="Por Categoria"> </br>
			<input type="text" class="form-control"  placeholder="Por Titulo"> </br> 
			<input type="text" class="form-control" placeholder="Por Autor"> </br>
			<input type="text" class="form-control" placeholder="Por Editora"> </br>
			<button type="submit" class="btn btn-primary form-control">Buscar</button>
		</div>

		<div class="col-md-9">

			<!-- Livros -->
			<div class="alert alert-success">Livros</div>

		</div>
	</div>

</body>
</html>