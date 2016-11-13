<%@page import="biblioteca.dao.CategoriaDAO"%>
<%@page import="biblioteca.entities.Categoria"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap.min.css" rel="stylesheet">
<title>*** Categorias ***</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="page-header">
				<h1>
					<small>Categorias</small>
				</h1>
			</div>
			<div class="col-xs-12">
				<div class="table-responsive">
				<a href="categoriaAdicionar.jsp" class="btn btn-primary btn-lg">Nova Categoria</a>
					<table
						class="table table-bordered table-striped table-hover table-condensed">
						<thead>
							<tr style="color: white" bgcolor="SteelBlue" align="center">
								<td>Código</td>
								<td>Descrição</td>
								<td colspan="2">Ações</td>
							</tr>
						</thead>
						<%
							CategoriaDAO dao = new CategoriaDAO();
							List<Categoria> categorias = dao.listarTodos();
							
							for (Categoria categoria: categorias){
								
							
						%>
						<tbody>
							<tr>
								<td align="center"><%=categoria.getIdCategoria() %></td>
								<td><%=categoria.getNome() %></td>
								<td><a href="categoria?acao=editar&id=<%=categoria.getIdCategoria() %>">Alterar</a></td>
								<td>
									<a href="categoria?acao=remover&id=<%=categoria.getIdCategoria() %>">Remover</a>
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