<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="one.gym.underground.*"%>
<%@ page import="java.util.List"%>
<% List<Person> person = (List<Person>)request.getAttribute("person");%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimun-scale=1.0">
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/myStyle.css">
		<title></title>
	</head>
	<body>
		<div class="container">
			
			<div class="Title"><p>Mostrando <%= person.size() %> Personas</p></div>
			<div class="Heading">
			<div >Nombre</div>
			
			</div>
			
			
			

				<%for( Person c : person ) {%>
				<form action="/findperson" method="post">
					<p><%= c.getName() %></p>
					<p><%= c.getId() %></p>
					<p><%= c.getId().getId() %></p>
					<p><%= c.getBirthday() %></p>
					<input type="hidden" name="key" value='<%= c.getId().getId() %>'>
					<p><%= c.getSurName() %></p>
					<p><%= c.getMail() %></p>
					<p>Activo: </p>
					<% if(c.isActive()){ %>
					<p>Si</p>
					<%}
					else {%><p>No</p><%
					} %>
					<input type="submit" value="Editar">
				</form>
				<%} %>
				
			
			
		
		
		</div>
		
	</body>
</html>