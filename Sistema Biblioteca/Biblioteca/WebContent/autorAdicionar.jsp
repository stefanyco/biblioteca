<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap.min.css" rel="stylesheet">
<title>*** Novo Autor ***</title>
</head>
<body>
	<div class="page-header col-md-12">
		<h1>Novo Autor</h1>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<form action="autor?acao=cadastrar" class="form-horizontal" method="post">
					
					<div class="form-group">
						<label for="nome" class="col-xs-2 control-label">Nome:</label>
						<div class="col-xs-5">
							<input type="text" class="form-control" name="nome" required maxlength="50">
						</div>
					</div>
					<div class="form-group">
						<label for="sobrenome" class="col-xs-2 control-label">Sobrenome:</label>
						<div class="col-xs-5">
							<input type="text" class="form-control" name="sobrenome" required maxlength="50">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-offset-2 col-xs-10">
							<button type="submit" class="btn btn-primary">Cadastrar</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>