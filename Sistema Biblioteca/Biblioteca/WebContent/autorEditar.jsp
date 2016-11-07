<%@page import="biblioteca.entities.Autor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap.min.css" rel="stylesheet">
<title>*** Alterar Autor ***</title>
</head>
<body>
	<div class="page-header col-md-12">
		<h1>Alterar Autor</h1>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<form action="autor?acao=atualizar" class="form-horizontal"
					method="post">
					<%
						Autor autor = (Autor) request.getAttribute("autor");
					%>
					<div class="form-group">
						<label for="id" class="col-xs-2 control-label">Código:</label>
						<div class="col-xs-5">
							<input value="<%=autor.getIdAutor()%>" type="text"
								class="form-control" name="id" required readonly="true"
								maxlength="20">
						</div>
					</div>
					<div class="form-group">
						<label for="nome" class="col-xs-2 control-label">Nome:</label>
						<div class="col-xs-5">
							<input value="<%=autor.getNome()%>" type="text"
								class="form-control" name="nome" required maxlength="50">
						</div>
					</div>
					<div class="form-group">
						<label for="sobrenome" class="col-xs-2 control-label">Sobrenome:</label>
						<div class="col-xs-5">
							<input value="<%=autor.getSobrenome()%>" type="text"
								class="form-control" name="sobrenome" required maxlength="50">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-offset-2 col-xs-10">
							<button type="submit" class="btn btn-primary">Alterar</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>