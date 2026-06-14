package facade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.Contrat;
import entities.Enfant;
import entities.Parent;
import entities.Session;
import service.RecapitulatifMensuel;
import service.ServiceRecapitulatif;
import singleton.Configuration;

public class FacadeParent {

	private Parent parent;

	/* Constructeur */
	public FacadeParent(Parent parent) {
		this.parent = parent;
	}

	/******************************************************* consultation des informations du parent *********************************************************** */

	/* Afficher les informations personnelles du parent */
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
		System.out.println("Nombre de contrats        : " + parent.getNbContrats());
	}

	/*  Gestion des enfants */

	/* Afficher la liste de ses enfants inscrits. */
	public void afficher_enfant() {
		parent.afficherEnfant();
	}

	/**
	 * inscrire un nouvel enfant à l'assistante maternelle
	 */
	public void inscrireEnfant(Enfant enfant) {
		parent.ajouterEnfant(enfant);
		System.out.println("Enfant " + enfant.getNom() + " " + enfant.getPrenom()
				+ " inscrit pour le parent " + parent.getNom() + " " + parent.getPrenom() + ".");
	}

	/**
	 * ou bien à partir des informations directes
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

	/* Consulter l'état d'un de ses contrats. */
	public String consulterEtatContrat(Contrat contrat) {
		return contrat.getEtat();
	}

	/* Chercher un de ses contrats à partir de son ID. */
	public Contrat chercherContratParId(int id) {
		for (Contrat c : parent.getListeContrat()) {
			if (c.getId() != null && c.getId() == id) {
				return c;
			}
		}
		return null;
	}


	/************************************************************************ Récapitulatif mensuel ************************************* */

	/**
	 * Obtenir le récapitulatif mensuel concernant les sessions de garde
	 * des enfants de ce parent uniquement.
	 */
	public RecapitulatifMensuel obtenirRecapitulatif(int mois, int annee) {
		List<Session> sessionsDuParent = new ArrayList<>();
		for (Session s : Session.listeSessions) {
			if (s.getContrat() != null && s.getContrat().getParent() == parent) {
				sessionsDuParent.add(s);
			}
		}
		return new ServiceRecapitulatif().generer(sessionsDuParent, mois, annee);
	}


	/************************************************************************ Configuration globale (Singleton) ************************************* */

	/** Afficher la configuration globale de l'application. */
	public void afficherConfiguration() {
		System.out.println(Configuration.getInstance().toString());
	}


	/************************************************************************ Statiques de Parent ************************************* */

	/* liste de tous les parents */
	public void listeParents() {
		Parent.afficherListeParents();
	}

	/* chercher un parent par id */
	public Parent rechercherParId(long id) {
		Parent p = Parent.rechercherParId(id);
		if (p != null) {
			System.out.println("-> Parent existant : " + p.getNom());
			return p;
		} else {
			System.out.println("-> Parent non existant");
			return null;
		}
	}


	/* *********************************************************************** Identifiant  *******************************************************/

	public Parent getParent() {
		return parent;
	}
}
