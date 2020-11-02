package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import model.Client;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("register.jsp");
        view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		register(request, response);
		
	}
    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	if ("POST".equalsIgnoreCase(request.getMethod()) && request.getParameter("submit") != null) {

    	String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String adresse = request.getParameter("adresse");
        String ville = request.getParameter("ville");
        String tel = request.getParameter("tel");
        String mail = request.getParameter("mail");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setAdresse(adresse);
        client.setMail(mail);
        client.setTel(tel);
        client.setVille(ville);
        client.setPassword(password);
        client.setUsername(username);
        
        String FULL_PATH = "http://"+request.getServerName()+"/api/credit/addclient/";
		ResteasyClient rs = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = rs.target(FULL_PATH);
        Response resp = target.request().post(Entity.entity(client, "application/json"));
        resp.close();
        response.sendRedirect("login");
    	}
    }

}
