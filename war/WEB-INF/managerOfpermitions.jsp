<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="one.gym.underground.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.TreeMap"%>
<% List<KindOfPerson> koperson = (List<KindOfPerson>)request.getAttribute("koperson");%>
<% List<Resource> resource = (List<Resource>)request.getAttribute("resource");
	HttpSession misesion = request.getSession();
	Person p = (Person)misesion.getAttribute("person");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimun-scale=1.0">
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
		<div class="Title">
			<p>
				Mostrando
				<%= koperson.size() %>
				tipos de Persona
			</p>
		</div>
		<div class="Heading">
			<div>
				<p>Nombre</p>
			</div>

		</div>

		<%for( KindOfPerson c : koperson ) {%>

			<h2><%= c.getName()%></h2>
			<% List<Link> e = new ArrayList<Link>(c.getPermision()); %>
			<br>
			<% if(!c.getPermision().isEmpty()) { %>
				<% for(int i = 0; i<resource.size(); i++) {%>
					<% gg: 
						for(int j=0; j<e.size(); j++) {
							long as = Long.parseLong(e.get(j).getName()) ;%>
						<% //if(5==5) {%>
						<% if(resource.get(i).getId().getId() == Long.parseLong(e.get(j).getName())) {%>
					
							<%= e.get(j).getName() %>
							<h3><%= resource.get(i).getName() %></h3>
							<form action="/savepermitions" method="post">
							<% if(resource.get(i).getKind().equals("crud")){ %>
								Crear:Si<input type="radio" name="activec" value="true" <% if(e.get(j).isC()){ %> checked<%} %> >  No<input type="radio" name="activec" value="false" <% if(!e.get(j).isC()){ %> checked<%} %>><br>
								Ver:Si<input type="radio" name="activer" value="true" <% if(e.get(j).isR()){ %> checked<%} %>>  No<input type="radio" name="activer" value="false" <% if(!e.get(j).isR()){ %> checked<%} %>><br>
								Editar:Si<input type="radio" name="activeu" value="true" <% if(e.get(j).isU()){ %> checked<%} %>>  No<input type="radio" name="activeu" value="false" <% if(!e.get(j).isU()){ %> checked<%} %>><br>
								Eliminar:Si<input type="radio" name="actived" value="true" <% if(e.get(j).isD()){ %> checked<%} %>>  No<input type="radio" name="actived" value="false" <% if(!e.get(j).isD()){ %> checked<%} %>><br>
							<%}else{ 
							System.out.println(resource.get(i).getKind());
							System.out.println(e.get(j).getKind());
							System.out.println(e.get(j).isCanI());%>
								Puede: Si<input type="radio" name="canI" value="true" <% if(e.get(j).isCanI()){ %> checked<%} %>>  No<input type="radio" name="canI" value="false" <% if(!e.get(j).isCanI()){ %> checked<%} %>><br> 
							<%} %>
							<input type="hidden" name="kind" value='<%= resource.get(i).getKind() %>'>
							<input type="hidden" name="id" value='<%= e.get(j).getName() %>'>
							<input type="hidden" name="idm" value='<%= c.getId().getId() %>'>
							<input type="submit" value='Guardar permisos de <%= e.get(j).getName()+" para "+c.getName() %>'>
							</form>
						<%break gg;%><%
						}else if(j==e.size()-1){%>
							<h3><%= resource.get(i).getName() %></h3>
							<form action="/savepermitions" method="post">
							<%if (resource.get(i).getKind().equals("crud")){ %>	
								Crear:Si<input type="radio" name="activec" value="true">  No<input type="radio" name="activec" value="false" checked><br>
								Ver:Si<input type="radio" name="activer" value="true">  No<input type="radio" name="activer" value="false" checked><br>
								Editar:Si<input type="radio" name="activeu" value="true">  No<input type="radio" name="activeu" value="false" checked><br>
								Eliminar:Si<input type="radio" name="actived" value="true">  No<input type="radio" name="actived" value="false" checked><br>
							<%}else{ %>
								Puede: Si<input type="radio" name="canI" value="true" >  No<input type="radio" name="canI" value="false"  checked><br>
							<%} %>	
							<input type="hidden" name="kind" value='<%= e.get(j).getKind() %>'>
							<input type="hidden" name="id" value='<%= resource.get(i).getId().getId() %>'>
							<input type="hidden" name="idm" value='<%= c.getId().getId() %>'>
							<input type="submit" value='Guardar permisos de <%= resource.get(i).getId().getId()+" para "+c.getName() %>'>
							</form>
						
						<%} %>
					<%} %>
				<%} %>
			<%} else{
				for(Resource r : resource) {%>
					<h3><%= r.getName() %></h3>
					<form action="/savepermitions" method="post">
					Crear:Si<input type="radio" name="activec" value="true">  No<input type="radio" name="activec" value="false" checked><br>
					Ver:Si<input type="radio" name="activer" value="true">  No<input type="radio" name="activer" value="false" checked><br>
					Editar:Si<input type="radio" name="activeu" value="true">  No<input type="radio" name="activeu" value="false" checked><br>
					Eliminar:Si<input type="radio" name="actived" value="true">  No<input type="radio" name="actived" value="false" checked><br>
					<input type="hidden" name="id" value='<%= r.getId().getId() %>'>
					<input type="hidden" name="idm" value='<%= c.getId().getId() %>'>
					<input type="submit" value='Guardar permisos de <%= r.getName()+" para "+c.getName() %>'>
					</form>
				<%} %>
			<%} %>
		<%}%>
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