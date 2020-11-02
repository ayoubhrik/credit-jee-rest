package model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "TClient")
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private String username;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "adresse")
	private String adresse;
	@Column(name = "ville")
	private String ville;
	@Column(name = "tel")
	private String tel;
	@Column(name = "mail")
	private String mail;
	@Column(name = "password")
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Client() {
	
	}
	@Override
	public String toString() {
		return "Client [username=" + username + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", ville=" + ville + ", tel=" + tel + ", mail=" + mail + ", password=" + password + "]";
	}
	
	
}
