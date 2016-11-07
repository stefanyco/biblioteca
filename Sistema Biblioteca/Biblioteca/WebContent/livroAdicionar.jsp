<%@page import="biblioteca.entities.Autor"%>
<%@page import="biblioteca.dao.AutorDAO"%>
<%@page import="biblioteca.entities.Editora"%>
<%@page import="biblioteca.dao.EditoraDAO"%>
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
<title>*** Novo Livro ***</title>
</head>
<body>
	<div class="page-header col-md-12">
		<h1>Novo Livro</h1>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<form action="livro?acao=cadastrar" class="form-horizontal" method="post">
					<div class="form-group">
						<label for="titulo" class="col-xs-2 control-label">Titulo:</label>
						<div class="col-xs-8">
							<input type="text" class="form-control" name="titulo" required maxlength="50">
						</div>
					</div>
					<div class="form-group">
						<label for="edicao" class="col-xs-2 control-label" >Edição:</label>
						<div class="col-xs-2">
							<input type="number" class="form-control" name="edicao" id="edicao">
						</div>
					</div>
					<div class="form-group">
						<label for="ano" class="col-xs-2 control-label" >Ano:</label>
						<div class="col-xs-2">
							<input type="number" class="form-control" name="ano" id="ano">
						</div>
					</div>
					<div class="form-group">
						<label for="qtd" class="col-xs-2 control-label" >Quantidade:</label>
						<div class="col-xs-2">
							<input type="number" class="form-control" name="qtd" id="qtd">
						</div>
					</div>
					<div class="form-group">
							<label for="categoria" class="col-xs-2 control-label">Categoria:</label>
							<div class="col-xs-5">
								<select class="form-control" name="idCategoria">
									<option></option>
									<%
										CategoriaDAO dao = new CategoriaDAO();
										List<Categoria> categorias = dao.listarTodos();

										for (Categoria categoria : categorias) {
									%>
									<option value="<%=categoria.getNome()%>">
										<%=categoria.getNome()%>
									</option>

									<%
										}
									%>
								</select>
							</div>
					</div>
					<div class="form-group">
						<label for="editora" class="col-xs-2 control-label">Editora:</label>
							<div class="col-xs-5">
								<select class="form-control" name="idEditora">
								<option></option>
									<%
										EditoraDAO editoraDAO = new EditoraDAO();
										List<Editora> editoras = editoraDAO.listarTodos();
										for (Editora editora : editoras){
									%>
										<option value="<%=editora.getNome()%>">
											<%=editora.getNome()%>
										</option>
									
									<%
										}
									%>
								</select>
							</div>	
					</div>
					<div class="form-group">
						<label for="autor" class="col-xs-2 control-label">Autor:</label>
							<div class="col-xs-5">
								<select class="form-control" name="idAutor" required>
									<option></option>
									<%
										AutorDAO autorDAO = new AutorDAO();
										List<Autor> autores = autorDAO.listarTodos();
										for (Autor autor : autores){
									%>
										<option value="<%=autor.getIdAutor()%>">
											<%=autor.getNome()%> <%=autor.getSobrenome()%>
										</option>
									
									<%
										}
									%>
								</select>
							</div>	
					</div>
					<div class="form-group">
						<label for="titulo" class="col-xs-2 control-label">Sinopse:</label>
						<div class="col-xs-8">
							<textarea rows="5" cols="5" class="form-control" name="sinopse" id="sinopse"></textarea>
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