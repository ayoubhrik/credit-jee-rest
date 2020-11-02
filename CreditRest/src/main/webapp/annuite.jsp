<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page language="java"  import="model.Client" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
			<title>Annuite</title>
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
			if(session.getAttribute("client")==null) {
				response.sendRedirect("login");
			}else{
				Client client = (Client) (session.getAttribute("client"));
			
			%>
				<header class="app-header">
					<a href="annuite" class="header-element">
						<div class="link">Annuite</div>
					</a>
					<a href="capital" class="header-element">
						<div class="link">Capital</div>
					</a>
					<a href="duree" class="header-element">
						<div class="link">Duree</div>
					</a>
					<a href="credit" class="header-element">
						<div class="link">Credit</div>
					</a>
					<div class="header-element">
						<div class="user-block dropdown">
							<div id="user-block-toggle" class="dropdown-toggle">
					         <div class="user-icon" onclick="toggle()">
					         	<ion-icon name="person-outline"></ion-icon>
					         </div>
					         
					       
					        </div>
					        <div id="user-block-content" class="dropdown-content">
					          <div class="dropdown-header">
								<%= client.getNom() +" "+ client.getPrenom() %>
					            <h6>Adresse: <%= client.getAdresse()%></h6>
					             <h6>Ville: <%= client.getVille()%></h6>
					              <h6>Telephone: <%= client.getTel()%></h6>
					              <h6>Email: <%= client.getMail()%></h6>
					              <a href="logout" class="logout">
					             	<ion-icon name="log-out-outline"></ion-icon>
					              	<span>Log out</span>
					              </a>
					          </div>
					        </div>
						</div>
					</div>
</header>

				<%
			
			if(request.getAttribute("annuite")!=null) {
				%>
				
				<div class="result-message">
						
				        <h1>Annuite Calculee :
				        <span><%= request.getAttribute("annuite") %></span></h1>
				 </div>
				<%
				
			}else{
			
			}
			%>
				<div class="bodywrapper">
				<form action="annuite" method="post">
						<div class="inner-block has-padding">
							<div class="block-header">
								<div class="block-title">
									Calcul Annuite 
								</div>
							</div>
							<div class="block-content">
								<div class="is-grid grid-3">
									<div class="form-group">
										<label class="form-label">Capital :</label>
										<input type="text" name="capital">
											<!---->
										</div>
										<div class="form-group">
											<label class="form-label">Taux :</label>
											<input type="text" name="taux">
												<!---->
											</div>
											<div class="form-group">
												<label class="form-label">Duree :</label>
												<input type="text" name="duree">
													
												</div>
											</div>
										</div>
										
											<div class="block-button">
												
												<input type="submit" class="button primary-button" name="submit" value="Calculer et Sauvegarder">
											</div>
										
					</div>
					</form>
				</div>
			 
			<% 
			}
			%>
				
			<script>
			function toggle() {
			  var x = document.getElementById("user-block-content");
			  if (x.style.opacity == 1) {
				  x.style.opacity = 0;
			  } else {
				  x.style.opacity = 1;
			  }
			}
			</script>
			
			</body>
		</html>