package model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TCredit")
public class Credit implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numcredit;
	@Column(name = "datecredit")
	private Date  datecredit;
	@Column(name = "montant")
	private double montant;
	@Column(name = "duree")
	private int duree;
	@Column(name = "taux")
	private double taux;
	@Column(name = "annuite")
	private double annuite;
	@Column(name = "dateprever")
	private Date  dateprever;
	@Column(name = "username")
	private String username;

	public int getNumcredit() {
		return numcredit;
	}
	public void setNumcredit(int numcredit) {
		this.numcredit = numcredit;
	}
	public Date getDatecredit() {
		return datecredit;
	}
	public void setDatecredit(Date datecredit) {
		this.datecredit = datecredit;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	public double getAnnuite() {
		return annuite;
	}
	public void setAnnuite(double annuite) {
		this.annuite = annuite;
	}
	public Date getDateprever() {
		return dateprever;
	}
	public void setDateprever(Date dateprever) {
		this.dateprever = dateprever;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Credit(int numcredit, Date datecredit, double montant, int duree, double taux, double annuite,
			Date dateprever, String username) {
		super();
		this.numcredit = numcredit;
		this.datecredit = datecredit;
		this.montant = montant;
		this.duree = duree;
		this.taux = taux;
		this.annuite = annuite;
		this.dateprever = dateprever;
		this.username = username;
	}
	public Credit(Date datecredit, double montant, int duree, double taux, double annuite,
			Date dateprever, String username) {
		this.datecredit = datecredit;
		this.montant = montant;
		this.duree = duree;
		this.taux = taux;
		this.annuite = annuite;
		this.dateprever = dateprever;
		this.username = username;
	}
	public Credit() {
		
	}
	@Override
	public String toString() {
		return "Credit [numcredit=" + numcredit + ", datecredit=" + datecredit + ", montant=" + montant + ", duree="
				+ duree + ", taux=" + taux + ", annuite=" + annuite + ", dateprever=" + dateprever + ", username="
				+ username + "]";
	}
	
	
}
