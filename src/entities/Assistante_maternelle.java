package entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

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
	public static HashSet<Assistante_maternelle> liste_assistante = new HashSet<>();

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
		liste_assistante.add(this);
	}
	
	public Assistante_maternelle() {
		compteur ++;
		this.id_assistante_maternelle = compteur;
		liste_assistante.add(this);
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

	
	public static void afficherListeAssistantes() {
	    System.out.println("=== Liste des assistantes maternelles enregistrées ===");

	    if (liste_assistante.isEmpty()) {
	        System.out.println("Aucune assistante n'est enregistrée pour le moment.");
	        return;
	    }

	    for (Assistante_maternelle a : liste_assistante) {
	        System.out.println("ID : " + a.id_assistante_maternelle 
	                + " | Nom : " + a.nom 
	                + " " + a.prenom 
	                + " | Téléphone : " + a.telephone 
	                + " | Mail : " + a.mail);
	    }
	}
	
	public static Assistante_maternelle rechercherParId(int id) {

	    for (Assistante_maternelle a : liste_assistante) {
	        if (a.id_assistante_maternelle == id) {
	        	
	    	    System.out.println("L'assistante avec l'ID " + id );
	            return a; // assistante trouvée
	        }
	    }

	    System.out.println("L'assistante avec l'ID " + id + " n'existe pas dans la liste.");
	    return null;
	}

	
	
}
