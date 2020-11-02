import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.ClientDao;
import dao.CreditDao;
import model.Client;
import model.Credit;





@Path("credit")
public class CreditService {
		@Inject
	    private CreditDao creditDao = new CreditDao();
		@Inject
	    private ClientDao clientDao = new ClientDao();
		
		@Path("annuite")
	 	@POST
	    //@Produces(MediaType.APPLICATION_JSON)
	    public double annuite(@FormParam("capital") String str_capital, @FormParam("taux") String str_taux, @FormParam("duree") String str_duree) {

	        double a,capital = 0,taux = 0;
	        int duree = 0;
	        capital = Double.parseDouble(str_capital);
	        taux = Double.parseDouble(str_capital);
	        duree = Integer.parseInt(str_duree);
	        a = creditDao.annuite(capital, taux, duree);
	        return a;
	    }
		@Path("get_annuite/{capital}/{taux}/{duree}")
	 	@GET
	    //@Produces(MediaType.APPLICATION_JSON)
	    public double getAnnuite(@PathParam("capital") String str_capital, @PathParam("taux") String str_taux, @PathParam("duree") String str_duree) {
			System.out.println("str_capital :"+str_capital+ " - str_taux :"+str_taux+ " - str_duree:"+str_duree);

	        double a,capital = 0,taux = 0;
	        int duree = 0;
	        capital = Double.parseDouble(str_capital);
	        taux = Double.parseDouble(str_taux);
	        duree = Integer.parseInt(str_duree);
	        
	        a = creditDao.annuite(capital, taux, duree);
	        System.out.println(capital+ " "+taux+""+ " anuuité :"+a);
	        return a;
			
	    }
		@Path("get_capital/{annuite}/{taux}/{duree}")
	 	@GET
	    //@Produces(MediaType.APPLICATION_JSON)
	    public double getCapital(@PathParam("annuite") String str_annuite, @PathParam("taux") String str_taux, @PathParam("duree") String str_duree) {
			System.out.println("str_annuite :"+str_annuite+ " - str_taux :"+str_taux+ " - str_duree:"+str_duree);
	        
	        double a,annuite = 0,taux = 0;
	        int duree = 0;
	        annuite = Double.parseDouble(str_annuite);
	        taux = Double.parseDouble(str_taux);
	        duree = Integer.parseInt(str_duree);
	        
	        a = creditDao.capital(annuite, taux, duree);
	        
	        return a;
			
	    }
		@Path("get_duree/{annuite}/{taux}/{capital}")
	 	@GET
	    //@Produces(MediaType.APPLICATION_JSON)
	    public int getDuree(@PathParam("annuite") String str_annuite, @PathParam("taux") String str_taux, @PathParam("capital") String str_capital) {
			System.out.println("str_annuite :"+str_annuite+ " - str_taux :"+str_taux+ " - str_capital:"+str_capital);
	        
	       	int a;
	       	double annuite = 0,taux = 0;
	        double capital = 0;
	        annuite = Double.parseDouble(str_annuite);
	        taux = Double.parseDouble(str_taux);
	        capital = Double.parseDouble(str_capital);
	        
	        a = creditDao.duree(capital, annuite, taux);
	        
	        return a;
			
	    }
		
		
	    @POST
	    @Path("/addclient")
	    @Consumes("application/json")
	    public Response addClient(Client client) {
	    	clientDao.addClient(client);
	        return Response.status(200).entity(1).build();
	    }
	    
	    @GET
	    @Path("/getclient/{username}/{password}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Client getclient(@PathParam("username") String username,@PathParam("password") String password) {
	    	Client client = clientDao.find(username, password);
	    	return client;
	    }
	    

	    @POST
	    @Path("/addcredit")
	    @Consumes("application/json")
	    public int addCredit(Credit credit) {
	    	int c = creditDao.saveCredit(credit);
	        
	        return c;
	    }
	    
	    @Path("deletecredit/{id}")
	 	@GET
	    public void deleteClient(@PathParam("id") int creditnum) {
	    	creditDao.deleteCredit(creditnum);

	    }
	    @Path("getcredits_by_username/{username}")
	 	@GET
	 	@Produces(MediaType.APPLICATION_JSON)
	    public List<Credit> getCreditsByUsername(@PathParam("username") String username) {
	    	List<Credit> credits = creditDao.getCreditsByUsername(username);
	        if (!credits.isEmpty()) {
	            return credits;
	        } else {
	            return null;
	        }

	    }
	    
	    

}
