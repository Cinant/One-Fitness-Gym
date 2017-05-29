<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="one.gym.underground.*"%>
<%@ page import="java.util.List"%>
<% Person person = (Person)request.getAttribute("person"); %>
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
			<form action="/updateperson" method="post">
				Nombre:<input name="name" type="text" value='<%= person.getName() %>'><br>
				Apellidos:<input name="surName" type="text" value='<%= person.getSurName() %>'><br>
				Correo:<input name="mail" type="email" value='<%= person.getMail() %>'><br>
				Dirección: <input name="address" type="text" value='<%= person.getAddress() %>'><br>
				Fecha de nacimiento: <input name="birthday" type="date" value='<%= person.getBirthday() %>'><br>
				<input name="key" type="hidden" value='<%= person.getId().getId() %>'>
				Tipo de usuario: 
				<!--  select name="koperson">
				
				
				
				</select--><br>
				Activo: <br>
				<input type="radio" name="active" value="si" <% if(person.isActive()){ %>checked<%} %> >Si<br>
				<input type="radio" name="active" value="no" <% if(!person.isActive()){ %>checked<%} %>>No<br>
				<input type="submit" value="Guardar cambios">
			</form>
		</div>
		
	</body>
</html>