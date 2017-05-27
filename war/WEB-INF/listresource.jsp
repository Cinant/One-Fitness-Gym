<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="one.gym.underground.*"%>
<%@ page import="java.util.List"%>
<% List<Resource> resource = (List<Resource>)request.getAttribute("resource");%>
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
			
			<div class="Title"><p>Mostrando <%= resource.size() %> recursos registrados</p></div>
			<div class="Heading">
			<div ><p>Nombre</p></div>
			
			</div>

				<%for( Resource c : resource ) {%>
			
					<p><%= c.getName() %></p>1--
					<%= c.getId() %>
			
				<%}%>
			
		
		
		</div>
		
	</body>
</html>