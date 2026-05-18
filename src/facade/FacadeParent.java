package facade;

import java.time.LocalDate;

import entities.Parent;
import entities.Enfant;

/* 
 * Le parent ne crée pas lui-même les contrats : c'est
 * l'assistante maternelle qui les crée (via FacadeAssistante).
 * Le parent peut juste les consulter. 
 */
public class FacadeParent {

	private Parent parent;

	public FacadeParent(Parent parent) {
		this.parent = parent;
	}

	/******************************************************* Consultation des informations du parent *********************************************************** */

	/** Afficher les informations personnelles du parent */
	public void afficherInfosParent() {
		System.out.println("=== Informations du parent ===");
		System.out.println("Nom      : " + parent.getNom());
		System.out.println("Prénom   : " + parent.getPrenom());
		System.out.println("Sexe     : " + parent.getSexe());
		System.out.println("Date naissance : " + parent.getDateNaiss());
		System.out.println("Métier   : " + parent.getMetier());
		System.out.println("Adresse  : " + parent.getAdresse());
		System.out.println("Mail     : " + parent.getMail());
		System.out.println("Téléphone: " + parent.getTelephone());
		System.out.println("Nombre d'enfants inscrits : " + parent.getNbEnfants());
	}

	/* ----- Gestion des enfants ----- */

	/** Afficher la liste de ses enfants inscrits. */
	public void afficher_enfant() {
		parent.afficherEnfant();
	}

	/**
	 * Inscrire un nouvel enfant à l'assistante maternelle
	 */
	public void inscrireEnfant(Enfant enfant) {
		parent.ajouterEnfant(enfant);
		System.out.println("Enfant " + enfant.getNom() + " " + enfant.getPrenom()
				+ " inscrit pour le parent " + parent.getNom() + " " + parent.getPrenom() + ".");
	}

	/**
	 * ou bien
	 */
	public Enfant inscrireEnfant(String nom, String prenom, LocalDate dateNaiss, char sexe) {
		Enfant enfant = new Enfant(nom, prenom, dateNaiss, sexe);
		inscrireEnfant(enfant);
		return enfant;
	}

	/************************************************************************ Consultation des contrats ************************************* */

	//Afficher la liste des contrats du parent
	public void afficher_contrat() {
		parent.afficherContrat();
	}

	/* *********************************************************************** Identifiant  *******************************************************/

	
	public Parent getParent() {
		return parent;
	}
}
