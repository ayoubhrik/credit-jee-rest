package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import db.DB;
import model.Credit;

public class CreditDao {

	public double annuelle(double taux) {
		return Math.pow(1+taux, (double)1/12)-1;
	}
	public double annuite(double capital,double t ,int duree) {
		double taux = annuelle(t);
		return (Math.pow(1+taux,duree)*taux*capital)/(Math.pow(1+taux,duree)-1);
	}
	public double capital(double annuite,double t ,int duree) {
		double taux = annuelle(t);
		return (Math.pow(1+taux,duree)*annuite-annuite)/(Math.pow(1+taux,duree)*taux);
	}
	public int duree(double capital,double annuite ,double t) {
		double taux = annuelle(t);
		return (int) ((Math.log(annuite/(annuite-taux*capital))/Math.log(1+taux))+0.5);
	}
	
	public List<Credit> getCreditsByUsername(String username) {
		List<Credit> credits = new ArrayList<Credit>();
		Connection connection = DB.getConnection();
		try {
			String CREDITS_BY_USERNAME = "select * from TCredit where username=?";
			PreparedStatement preparedStatement = connection.prepareStatement(CREDITS_BY_USERNAME);
			preparedStatement.setString(1, username);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Credit credit = new Credit();
				credit.setNumcredit(result.getInt("numcredit"));
				credit.setDatecredit(result.getDate("datecredit"));
				credit.setMontant(result.getDouble("montant"));
				credit.setDuree(result.getInt("duree"));
				credit.setTaux(result.getDouble("taux"));
				credit.setAnnuite(result.getDouble("annuite"));
				credit.setDateprever(result.getDate("dateprever"));
				credit.setUsername(result.getString("username"));
				credits.add(credit);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return credits;
	}


	public int addCredit(Credit credit) {
		String ADD_CREDIT_SQL = "INSERT INTO tcredit"
				+ "  (datecredit , montant, duree, taux, annuite, dateprever,username) VALUES "
				+ " (?,?, ?, ?, ?, ?,?);";

		int result = 0;
		Connection connection = DB.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(ADD_CREDIT_SQL,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setDate(1, credit.getDatecredit());
			preparedStatement.setDouble(2, credit.getMontant());
			preparedStatement.setInt(3, credit.getDuree());
			preparedStatement.setDouble(4, credit.getTaux());
			preparedStatement.setDouble(5, credit.getAnnuite());
			preparedStatement.setDate(6,credit.getDateprever());
			preparedStatement.setString(7, credit.getUsername());

			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
			ResultSet answer = preparedStatement.getGeneratedKeys();
			if(answer.next()) {
				result = answer.getInt(1);
			}
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int saveCredit(Credit credit) {
		String ADD_CREDIT_SQL = "INSERT INTO tcredit"
				+ "  (datecredit , montant, duree, taux, annuite, dateprever,username) VALUES "
				+ " (?, ?, ?, ?, ?,?,?);";

		int result = 0;
		Connection connection = DB.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(ADD_CREDIT_SQL);
			preparedStatement.setDate(1,credit.getDatecredit());
			preparedStatement.setDouble(2, credit.getMontant());
			preparedStatement.setInt(3, credit.getDuree());
			preparedStatement.setDouble(4, credit.getTaux());
			preparedStatement.setDouble(5, credit.getAnnuite());
			preparedStatement.setDate(6, credit.getDateprever());
			preparedStatement.setString(7, credit.getUsername());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			ResultSet answer = preparedStatement.getGeneratedKeys();
			if(answer.next()) {
				result = answer.getInt(1);
			}
			preparedStatement.close();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public void deleteCredit(int numcredit) {
		Connection connection = DB.getConnection();
		try {
			String DELETE_CREDIT = "DELETE FROM tcredit WHERE numcredit=?";
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CREDIT,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, numcredit);
			preparedStatement.execute();
			preparedStatement.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
