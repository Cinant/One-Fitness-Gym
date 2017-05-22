<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
							<%--
								if (per > 3) {
							--%>
							<li class="active"><button type="button" id="reg">Registrar</button></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button"> Mostrar: <span
									class="caret"></span></a>
								<ul class="dropdown-menu">
									<%--
										if (per > 4) {
									--%>
									<li><a href="mostrarA">Administradores</a></li>
									<%--
										}
									--%>
									<li><a href="mostrarS">Secretarias</a></li>
									<li><a href="mostrarT">Trainers</a></li>
									<li class="divider"></li>
									<li><a href="mostrarC">Clientes</a></li>
								</ul></li>
							<%--
								}
							--%>
							<li><a href="">Misión</a></li>
							<li><a href="">Visión</a></li>
							<li><a href="">Contacto</a></li>

							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button"> Temas <span
									class="caret"></span>
							</a>
								<ul class="dropdown-menu">
									<li><a href="#">Building</a></li>
									<li><a href="#">Building</a></li>
									<li class="divider"></li>
									<li><a href="">Building</a></li>
								</ul></li>
						</ul>
						<%--
							if (per == 0) {
						--%>
						<form method="post" action="/login"
							class="navbar-form navbar-right" role="login">
							<div class="form-group">
								<label class="control-label" for="mail">Correo:</label> <input
									type="email" name="mail">
							</div>
							<div class="form-group">
								<label class="control-label" for="pass">DNI:</label> <input
									type="password" name="dni">
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-default">Entrar</button>
							</div>
						</form>
						<%--
							} else {
						--%>
						<div class="navbar-form navbar-right">
							<div class="form-group">
								<a href="/close"><button type="button"
										class="btn btn-warning">Salir</button></a>
							</div>
						</div>
						<%--
							}
						--%>
					</div>
				</div>

			</nav>
		</header>
	</div>
	<div class="container">
		<%--
			if (per > 0) {
		--%>
		<!-- h3>
			Bienvenido:
			<%--
			out.print(hom);
		--%>
		</h3>
		<h4>
			Tu tipo es:
			<%--
			out.print(misesion.getAttribute("tipo"));
		--%>
		</h4-->
		<%--
			}
		--%>
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