package entities;

import java.math.BigDecimal;
import java.util.Date;

public class Assistante_maternelle {

	public int id_assistante_maternelle;
	public String nom;
	public String prenom;
	public String telephone;
	public String mail;
	public Date date_naiss;
	public BigDecimal salaire;
	public char sexe;
	public String adresse;

	public static int compteur = 0;

	public Assistante_maternelle( String nom, String prenom, String telephone, String mail,
			Date date_naiss, BigDecimal salaire, char sexe, String adresse) {
		compteur ++;
		this.id_assistante_maternelle = compteur;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.mail = mail;
		this.date_naiss = date_naiss;
		this.salaire = salaire;
		this.sexe = sexe;
		this.adresse = adresse;
	}

	public int getId_assistante_maternelle() {
		return id_assistante_maternelle;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getDate_naiss() {
		return date_naiss;
	}

	public void setDate_naiss(Date date_naiss) {
		this.date_naiss = date_naiss;
	}

	public BigDecimal getSalaire() {
		return salaire;
	}

	public void setSalaire(BigDecimal salaire) {
		this.salaire = salaire;
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Assistante_maternelle [id_assistante_maternelle=" + id_assistante_maternelle + ", nom=" + nom
				+ ", prenom=" + prenom + ", telephone=" + telephone + ", mail=" + mail + ", date_naiss=" + date_naiss
				+ ", salaire=" + salaire + ", sexe=" + sexe + ", adresse=" + adresse + "]";
	}

	
}
