package web;

import java.io.IOException;
import java.util.ArrayList;

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

/**
 * Servlet implementation class CreditServlet
 */
@WebServlet("/credit")
public class CreditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession();
		if(session.getAttribute("client")==null) {
			response.sendRedirect("login");
		}else{
		Client client = (Client) (session.getAttribute("client"));
		final String REST_GET_CREDITS = "http://"+request.getServerName()+"/api/credit/getcredits_by_username/"+client.getUsername();
		final ResteasyClient c = new ResteasyClientBuilder().build();
		final ResteasyWebTarget target = c.target(REST_GET_CREDITS);
		ArrayList creditslist = target.request().get(ArrayList.class);
		request.setAttribute("creditslist",creditslist);
		RequestDispatcher view = request.getRequestDispatcher("credit.jsp");
        view.forward(request, response);
		}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
