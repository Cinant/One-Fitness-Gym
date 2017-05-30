<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="one.gym.underground.*"%>
<%@ page import="java.util.List"%>
<% List<KindOfPerson> koperson = (List<KindOfPerson>)request.getAttribute("koperson");%>
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
			<form action="/saveperson" method="post">
				Nombre:<input name="name" type="text"><br>
				Apellidos:<input name="surName" type="text"><br>
				Correo:<input name="mail" type="email"><br>
				Dirección: <input name="address" type="text"><br>
				Fecha de nacimiento: <input name="birthday" type="date"><br>
				Tipo de usuario: 
				<select name="koperson">
				<%for( KindOfPerson c : koperson ) {%>
			
					<option value="<%= c.getId().getId()%>"><%= c.getName() %></option>
			
				<%}%>
				
				</select><br>
				Activo: <br>
				<input type="radio" name="active" value="si" checked>Si<br>
				<input type="radio" name="active" value="no">No<br>
				<input type="submit" value="Registrar">
			</form>
		</div>
		
	</body>
</html>