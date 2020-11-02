package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import model.Client;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getContextPath());
		RequestDispatcher view = request.getRequestDispatcher("login.jsp");
        view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			login(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if ("POST".equalsIgnoreCase(request.getMethod()) && request.getParameter("submit") != null) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String FULL_PATH = "http://"+request.getServerName()+"/api/credit/getclient/"+username+"/"+password;
		
		ResteasyClient rs = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = rs.target(FULL_PATH);
		Client cl = target.request().get(Client.class);
		if (cl != null) {
			HttpSession session = request.getSession();
            session.setAttribute("client",cl);
            response.sendRedirect("annuite");
			
		}else {
			response.sendRedirect("login");
		}
	}
	}

}
