<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="one.gym.underground.*"%>
<%@ page import="java.util.List"%>
<% List<Person> person = (List<Person>)request.getAttribute("person");
HttpSession misesion = request.getSession();
	Person p = (Person)misesion.getAttribute("person");%>
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
		<br>
		<header>
			<nav class="navbar navbar-default navbar-fixed-top">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar-1">
							<span class="sr-only">Menu</span> <span class="icon-bar"></span>
							<span class="icon-bar"></span> <span class="icon-bar"></span>
						</button>
						<a href="/" class="navbar-brand">One Fitness Gym</a>
					</div>
					<div class="collapse navbar-collapse" id="navbar-1">
						<ul class="nav navbar-nav">
							<li><a href="/">Inicio</a></li>
							<li><a href="">Misión</a></li>
							<li><a href="">Visión</a></li>
							<li><a href="">Contacto</a></li>
							<%
								
								if (misesion.getAttribute("estado")!=null) {
							%>
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown" role="button"> <%=misesion.getAttribute("name")%>
										<span class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li><a href="/regperson">Registrar usuario</a></li>
									<li><a href="/registerKindOfPerson.jsp">Registrar tipo
											usuario</a></li>
									<li><a href="/regresource">Registrar resurso</a></li>
									<li><a href="/managepermitions">Administrar Permisos</a></li>
									<li><a href="/deleteall">Borrar todo</a></li>
									<li class="divider"></li>
									<li><a href="">Building</a></li>
									<li><a href="/closesesion">Cerrar sesión</a></li>
								</ul></li>
							<%
								}else{
							%>
							<li><a href="/gmail">Iniciar Sesión</a></li>
							<%} %>
							
						</ul>
						
					</div>
				</div>

			</nav>
		</header>
	</div>
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
	<div id="cuerpo"></div>
	<footer class="footer">
		<div class="container">
			<p>Copyright Anthony Juancarlo Rivas Chire 2017</p>
		</div>
	</footer>

	<script src="js/jquery-1.12.4.min.js"></script>
	<script src="js/script.js"></script>
	<script src="js/bootstrap.min.js"></script>
		
	</body>
</html>