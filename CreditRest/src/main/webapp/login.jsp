<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
			<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap"
	rel="stylesheet">
				<link type="text/css" href="css/style.css" rel="Stylesheet" />
				<script src="https://unpkg.com/ionicons@5.2.3/dist/ionicons.js"></script>
				 <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<%
response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
if(session.getAttribute("client")!=null) {
	response.sendRedirect("annuite");
}

%>
<div class="wrapper">
	<div class="auth-wrapper">
		<div class="auth-block">
			<div class="auth-block-title">
				Connectez-vous à votre compte
			</div>
			<div class="auth-block-body">
				<form action="login" method="POST">
					<div class="is-grid">
						<div class="form-group ">
							<div class="input-icon-holder">
								<ion-icon name="log-in" class="icon-auth"></ion-icon>
								<input type="text" name="username" value="" placeholder="Username" required="">
							</div>
													</div>
						<div class="form-group ">
							<div class="input-icon-holder">
								<ion-icon name="lock-closed" class="icon-auth"></ion-icon>
								<input type="password" name="password" placeholder="Password" required="">
							</div>
						</div>

						<div class="form-group">
							<button type="submit" name="submit" class="button primary-button">S'identifier</button>
						</div>
					</div>
				</form>
			</div>
			<div class="auth-block-footer">
				<p>Pas encore inscrit ?</p>
				<a href="register">S'inscrire maintenant</a>
			</div>
		</div>
	</div>
</div>
</body>
</html>