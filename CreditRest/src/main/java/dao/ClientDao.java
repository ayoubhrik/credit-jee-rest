package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import model.Client;

public class ClientDao {

	 public int addClient(Client user) {
		 String INSERT_CLIENT_SQL = "INSERT INTO tclient" +
		            "  (username , adresse, mail, nom, password, prenom,tel,ville) VALUES " +
		            " (?, ?, ?, ?, ?,?,?,?);";

		        int result = 0;

		       
		        Connection connection = DB.getConnection();
		        try  {		            
		        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_SQL);
		        	preparedStatement.setString(1, user.getUsername());
		            preparedStatement.setString(2, user.getAdresse());
		            preparedStatement.setString(3, user.getMail());
		            preparedStatement.setString(4, user.getNom());
		            preparedStatement.setString(5, user.getPassword());
		            preparedStatement.setString(6, user.getPrenom());
		            preparedStatement.setString(7, user.getTel());
		            preparedStatement.setString(8, user.getVille());
		            System.out.println(preparedStatement);
		            // Step 3: Execute the query or update query
		            result = preparedStatement.executeUpdate();

		        } catch (SQLException e) {
		            
		        }
		        return result;
	 }

	 
	 public Client find(String username,String password) {
	        boolean status = false;
	        Client client = null;

	        Connection connection = DB.getConnection();
	        try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	        try
	        {
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select * from tclient where username = ? and password = ? ");
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);

	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();
	            System.out.println(rs);
	            status = rs.next();
	            if(status) {
	            	client = new Client();
	            	 client.setUsername(rs.getString(1));
	            	 client.setAdresse(rs.getString(2));
	            	 client.setMail(rs.getString(3));
	            	 client.setNom(rs.getString(4));
	            	 client.setPassword(rs.getString(5));
	            	 client.setPrenom(rs.getString(6));
	            	 client.setTel(rs.getString(7));
	            	 client.setVille(rs.getString(8));
	            }else {
	            	client = null;
	            }
	            
	            System.out.println(status);

	        } catch (SQLException e) {

	        }
	        return client;
	    }
}
