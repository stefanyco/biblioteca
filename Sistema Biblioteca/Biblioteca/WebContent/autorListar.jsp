<%@page import="biblioteca.dao.AutorDAO"%>
<%@page import="biblioteca.entities.Autor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap.min.css" rel="stylesheet">
<title>*** Autores ***</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="page-header">
				<h1>
					<small>Autores</small>
				</h1>
			</div>
			<div class="col-xs-12">
				<div class="table-responsive">
				<a href="autorAdicionar.jsp" class="btn btn-primary btn-lg">Novo Autor</a>
					<table
						class="table table-bordered table-striped table-hover table-condensed">
						<thead>
							<tr style="color: white" bgcolor="SteelBlue" align="center">
								<td>Código</td>
								<td>Nome</td>
								<td>Sobrenome</td>
								<td colspan="2">Ações</td>
							</tr>
						</thead>
						<%
							AutorDAO dao = new AutorDAO();
							List<Autor> autores = dao.listarTodos();
							
							for (Autor autor: autores){
								
							
						%>
						<tbody>
							<tr>
								<td align="center"><%=autor.getIdAutor() %></td>
								<td><%=autor.getNome() %></td>
								<td><%=autor.getSobrenome() %></td>
								<td><a href="autor?acao=editar&id=<%=autor.getIdAutor() %>">Alterar</a></td>
								<td>
									<a href="autor?acao=remover&id=<%=autor.getIdAutor() %>">Remover</a>
								</td>
							</tr>
						</tbody>
						<%
							}
						%>
					</table>
				</div>
			</div>
		</div>
</body>
</html>