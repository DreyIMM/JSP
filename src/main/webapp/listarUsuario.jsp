<%@page import="com.mangement.bean.User"%>
<%@page import="java.util.List"%>
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

	

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: black">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> UVA - PROJETO </a>
			</div>
			
		</nav>
	</header>
	<br>

	<div class="row">

		<div class="container">
			<h3 class="text-center">Alunos</h3>
			<hr>
			<div class="container text-left">
				<a href="UserServlet?acao=formIncluir" class="btn btn-success">Novo</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<td>Id</<td>
						<td>Nome</td>
						<td>Matricula</td>
						<td>Idade</td>
						<td>Ação</td>
					</tr>
				</thead>
				<tbody>
				
<% 
	List<User> lista = (List<User>)  request.getAttribute("lista");
    for(User u: lista) {
%>
					<tr>
							<td><%=u.id%></td>
							<td><%=u.nome%></td>
							<td><%=u.matricula%></td>
							<td><%=u.idade%></td>
							<td>
								<a href="UserServlet?acao=formAlterar&id=<%=u.id%>"    class="btn btn-primary btn-sm">Alterar</a>
								<a href="UserServlet?acao=excluir&id=<%=u.id%>"    class="btn btn-danger btn-sm">Excluir</a>
							</td>
					</tr>
				
				<%
				    }
				%>
				
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>