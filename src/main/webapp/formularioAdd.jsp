<%@page import="com.mangement.bean.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<title>Alunos</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<h1>Dados do Aluno</h1>

<%
	User u = (User)request.getAttribute("dado");
%>

<form action="UserServlet" method="post" class="form">

			<input type="hidden" name="acao" value='<%=(u==null)? "incluir":"alterar"%> '>
			
		    <input name="id" type="number" value='<%=(u==null)? " " :u.id%>'>
		  	
		    <div class="mb-3">
		    	<label class="form-label">Nome:</label>
		    	<input class="form-control" type="text" name="nome" value='<%=(u==null)?"":u.nome%>'>
		    </div>
		    
		     <div class="mb-3">
		    	<label class="form-label">Idade:</label>
		    	<input class="form-control" type="number" name="idade" value='<%=(u==null)?"":u.idade%>'>
		    </div>
		    
		    <div class="mb-3">
		    	<label class="form-label">Matricula:</label>
		    	<input class="form-control" type="text" name="matricula" value='<%=(u==null)?"":u.matricula%>'>
		    </div>
		    
		        
		    <button type="submit" class="btn btn-primary">Salvar</button>
</form>

</body>
</html>