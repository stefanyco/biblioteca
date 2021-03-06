<%@page import="biblioteca.dao.EditoraDAO"%>
<%@page import="biblioteca.entities.Editora"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap.min.css" rel="stylesheet">
<title>*** Editoras ***</title>
</head>
<body>
	<jsp:include page="cabecalhoMenu.jsp" />
	<div class="container">
		<div class="row">
			<div class="page-header">
				<h1>
					<small>Editoras</small>
					<br/>
					<a href="editoraAdicionar.jsp" class="btn btn-default">Nova Editora</a>
				</h1>
			</div>
			<div class="col-xs-12">
				<div class="table-responsive">
				
					<table
						class="table table-bordered table-striped table-hover table-condensed">
						<thead>
							<tr style="color: white" bgcolor="SteelBlue" align="center">
								<td>C�digo</td>
								<td>Descri��o</td>
								<td colspan="2">A��es</td>
							</tr>
						</thead>
						<%
							EditoraDAO dao = new EditoraDAO();
							List<Editora> editoras = dao.listarTodos();
							
							for (Editora editora: editoras){
								
							
						%>
						<tbody>
							<tr>
								<td align="center"><%=editora.getIdEditora() %></td>
								<td><%=editora.getNome() %></td>
								<td><a href="editora?acao=editar&id=<%=editora.getIdEditora() %>">Alterar</a></td>
								<td>
									<a href="editora?acao=remover&id=<%=editora.getIdEditora() %>">Remover</a>
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