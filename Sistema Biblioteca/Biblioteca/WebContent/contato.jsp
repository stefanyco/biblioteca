<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta content="width=device-width, initial-scale=1.0">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="bootstrap.min.css" rel="stylesheet">
	<title>Contato</title>
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

	</div>
	<!-- /container -->
	<div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="page-header"><h1>Contato</h1></div>
                </div>
            </div>
            
            <div class="row contato">
                <div class="col-xs-12">
                    <p class="bg-success aviso">Preencha o formulário abaixo para entrar em contato com a Biblioteca!</p>
                </div>
            </div>
            
            <div class="row contato">
                <div class="col-xs-12">
                    
                    <form name="frmContato" id="formContato">
                        <div class="row">
                            <div class="col-md-6">
                                
                                <div class="form-group">
                                    <input type="text" class="form-control input-lg" placeholder="Nome: *" required />
                                </div>
                                
                                <div class="form-group">
                                    <input type="email" class="form-control input-lg" placeholder="E-mail: *" required />
                                </div>
                                
                                <div class="form-group">
                                    <input type="tel" class="form-control input-lg" placeholder="Telefone: " />
                                </div>
                                
                            </div>
                            <div class="col-md-10">
                                <textarea class="form-control input-lg" placeholder="Sua mensagem: *" required></textarea>
                            </div>
                        </div> 
                        <div class="row">
                            <div class="col-sm-6">
                                <button type="submit" class="btn btn-success btn-lg">Enviar</button>
                            </div>
                        </div>
                    </form>
                    
                </div>
            </div>
        </div>
      </section>      
</body>
</html>