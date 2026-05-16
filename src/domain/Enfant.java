package domain;
import java.time.LocalDate; 

public class Enfant {
	public static int compteur = 0;
	public int idEnfant;
	public String nom;
	public String prenom;
	public LocalDate dateNaiss;
	public String sexe;
	public String remarque;
	
	
	public Enfant(String nom, String prenom, LocalDate dateNaiss, String sexe, String remarque) {
		super();
		compteur ++;
		idEnfant = compteur;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaiss = dateNaiss;
		this.sexe = sexe;
		this.remarque = remarque;
	}


	public int getIdEnfant() {
		return idEnfant;
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


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public String getRemarque() {
		return remarque;
	}


	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	
}
