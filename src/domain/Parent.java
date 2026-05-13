package domain;

import java.time.LocalDate;

public class Parent {
	public int idParent = 0;
	public String nom;
	public String prenom;
	public LocalDate dateNaiss;
	public String metier;
	public String adresse;
	public String mail;
	public String telephone;
	public String sexe;
	
	
	public Parent(String nom, String prenom, LocalDate dateNaiss, String metier, String adresse,
			String mail, String telephone, String sexe) {
		super();
		idParent++;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaiss = dateNaiss;
		this.metier = metier;
		this.adresse = adresse;
		this.mail = mail;
		this.telephone = telephone;
		this.sexe = sexe;
	}


	public int getIdParent() {
		return idParent;
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


	public LocalDate getDateNaiss() {
		return dateNaiss;
	}


	public void setDateNaiss(LocalDate dateNaiss) {
		this.dateNaiss = dateNaiss;
	}


	public String getMetier() {
		return metier;
	}


	public void setMetier(String metier) {
		this.metier = metier;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	
}
