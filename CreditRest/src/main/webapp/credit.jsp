<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ page language="java"  import="model.Client" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
			<title>Credit</title>
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
	<div class="table-wrapper">
	<%
	if(request.getAttribute("creditslist")==null){
		out.print("<h1>Vous n'avez aucun crédit</h1>");
	}else{
	%>
		<div class="table-body">
	<table class="table sortable">
		<thead>
			<tr>
				<th>ID</th>
				<th>Annuite</th>
				<th>Montant</th>
				<th>Duree</th>
				<th>Taux</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach var="credit" items="${creditslist}" varStatus="loop">
			<tr>
				<td>
				${loop.index}
				</td>
				<td>
					${credit.get("annuite")}
				</td>
				<td>${credit.get("montant")}</td>
				<td>
					${credit.get("duree")}
				</td>
				<td>
					${credit.get("taux")}
				</td>
				<td><a href="deletecredit?id=${credit.get('numcredit')}" class="action-button">
				<ion-icon name="close-circle" class="icon-auth"></ion-icon>
				</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
	<%
	}
	%>

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