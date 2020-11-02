package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import model.Client;
import model.Credit;

/**
 * Servlet implementation class AnnuiteServlet
 */
@WebServlet("/annuite")
public class AnnuiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnuiteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("annuite.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ("POST".equalsIgnoreCase(request.getMethod()) && request.getParameter("submit") != null) {
			String tauxS = request.getParameter("taux");
			String capitalS = request.getParameter("capital");
			String dureeS = request.getParameter("duree");
			try {
			double taux = Double.parseDouble(tauxS);
			double capital = Double.parseDouble(capitalS);
			int duree = Integer.parseInt(dureeS);
			
			final String REST_ANNUITE = "http://localhost:8080/api/credit/get_annuite/"+capital+"/"+taux+"/"+duree;
			final ResteasyClient c = new ResteasyClientBuilder().build();
			final ResteasyWebTarget target = c.target(REST_ANNUITE);
			double annuite = target.request().get(Double.class);
			request.setAttribute("annuite",annuite);
			
			HttpSession session  = request.getSession();
			Client client = (Client) (session.getAttribute("client"));
			Credit credit = new Credit(null,capital,duree,taux,annuite,null,client.getUsername());
			final String REST_ADD_CREDIT = "http://localhost:8080/api/credit/addcredit";
			final ResteasyWebTarget target2 = c.target(REST_ADD_CREDIT);
			Response resp = target2.request().post(Entity.entity(credit, "application/json"));
			resp.close();
			}catch(NumberFormatException e) {
				
			}

			RequestDispatcher view = request.getRequestDispatcher("annuite.jsp");
            view.forward(request, response);
		}
	}

}
