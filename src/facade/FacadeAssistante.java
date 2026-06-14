package facade;

import java.time.LocalDate;

import java.time.LocalTime;

import entities.AssistanteMaternelle;
import entities.Contrat;
import entities.Enfant;
import entities.Parent;
import entities.Service;
import entities.Session;
import entities.Tarif;
import factory.ContratFactory;
import service.RecapitulatifMensuel;
import singleton.Configuration;


public class FacadeAssistante {

	private AssistanteMaternelle assistante;
	private GardeFacade gardeFacade;
	
	/* Constructeur */
	public FacadeAssistante(AssistanteMaternelle assistante) {
		this.assistante = assistante;
		this.gardeFacade = new GardeFacade(assistante);
	}

	/*  Consultation des informations de l'assistante  */

	/* les informations personnelles de l'assistante */
	public void afficherInfosAssistante() {
		System.out.println("=== Informations de l'assistante maternelle ===");
		System.out.println("Nom       : " + assistante.getNom());
		System.out.println("Prénom    : " + assistante.getPrenom());
		System.out.println("Téléphone : " + assistante.getTelephone());
		System.out.println("Mail      : " + assistante.getMail());
		System.out.println("Adresse   : " + assistante.getAdresse());
		System.out.println("Salaire   : " + assistante.getSalaire() + " €");
		System.out.println("Nombre de contrats : " + assistante.getContrats().size());
	}

	/*  Gestion des contrats  */

	/**
	 * Créer un contrat pour un enfant donné et un parent donné,
	 * et l'ajouter à la liste des contrats de l'assistante.
	 */
	public Contrat creerContrat(LocalDate dateDebut, LocalDate dateFin, String typeContrat,
			Enfant enfant, Parent parent, Tarif tarif, Service service) {

		Contrat contrat = ContratFactory.creerContrat(dateDebut, dateFin, typeContrat, enfant, parent);
		contrat.setTarif(tarif);
		contrat.setService(service);
		parent.ajouterContrat(contrat);
		assistante.ajouterContrat(contrat);

		System.out.println("Contrat num " + contrat.getId() + " créé pour l'enfant "
				+ enfant.getNom() + " " + enfant.getPrenom()
				+ " (parent " + parent.getNom() + ").");
		return contrat;
	}

	public void afficherContrats() {
		System.out.println("=== Contrats de " + assistante.getNom() + " " + assistante.getPrenom() + " ===");
		if (assistante.getContrats().isEmpty()) {
			System.out.println("(aucun contrat)");
			return;
		}
		int i = 1;
		for (Contrat c : assistante.getContrats()) {
			System.out.println("Contrat " + i + " : " + c.toString() + " [état=" + c.getEtat() + "]");
			i++;
		}
	}

	/* activer le contrat*/
	public void activerContrat(Contrat contrat) {
		contrat.activer();
	}

	/*suspendre le contrat */
	public void suspendreContrat(Contrat contrat) {
		contrat.suspendre();
	}

	/** Résilier le contrat */
	public void resilierContrat(Contrat contrat) {
		contrat.resilier();
	}

	/** Terminer le contrat */
	public void terminerContrat(Contrat contrat) {
		contrat.terminer();
	}

	/*Consulter l'état courant du contrat. */
	public String consulterEtatContrat(Contrat contrat) {
		return contrat.getEtat();
	}

	/*  Gestion des sessions de garde  */

	/**
	 * Enregistrer une session de garde déjà construite(arrivée + départ d'un enfant)
	 */
	public void enregistrerSession(Session session) {
		gardeFacade.ajouterSession(session);
	}

	/*enregistrer une session de garde à partir des informations de facon directe
	 */
	public Session enregistrerSession(LocalDate dateArrive, LocalTime heureArrive,
			LocalDate dateDepart, LocalTime heureDepart,
			Enfant enfant, Contrat contrat) {
		Session session = new Session(dateArrive, heureArrive, dateDepart, heureDepart);
		session.setEnfant(enfant);
		session.setContrat(contrat);
		gardeFacade.ajouterSession(session);
		return session;
	}

	/*  Récapitulatif et statistiques  */

	/* Cloturer le mois : déclenche la notification des abonnés (Observer) */
	public void cloturerMois(int mois, int annee) {
		gardeFacade.terminerMois(mois, annee);
	}

	/** Obtenir le récapitulatif d'un mois donné. */
	public RecapitulatifMensuel obtenirRecapitulatif(int mois, int annee) {
		return gardeFacade.obtenirRecapitulatif(mois, annee);
	}

	/** Afficher les statistiques sur une plage de mois. */
	public void afficherStatistiques(int moisDebut, int moisFin, int annee) {
		gardeFacade.afficherStatistiques(moisDebut, moisFin, annee);
	}

	/* ----- Configuration globale (Singleton) ----- */

	/** Afficher la configuration globale de l'application. */
	public void afficherConfiguration() {
		System.out.println(Configuration.getInstance().toString());
	}

	/** Mettre à jour le taux horaire par défaut. */
	public void modifierTauxHoraireDefaut(double tauxHoraire) {
		Configuration.getInstance().setTauxHoraireDefaut(tauxHoraire);
	}

	/** Mettre à jour le nombre maximal de repas autorisés par session. */
	public void modifierNbRepasMax(int nbRepasMax) {
		Configuration.getInstance().setNbRepasMax(nbRepasMax);
	}

	/** Mettre à jour le nombre maximal d'heures par session. */
	public void modifierNbHeuresMax(double nbHeuresMax) {
		Configuration.getInstance().setNbHeuresMax(nbHeuresMax);
	}
	
	

	/*liste de toutes les assistante*/
	public void  listeAssistantes() {
		entities.AssistanteMaternelle.afficherListeAssistantes();
	}
	
	/* chercher assistante */ 
	public AssistanteMaternelle rechercherParId(int id) {
		AssistanteMaternelle a ;
		a = entities.AssistanteMaternelle.rechercherParId(id);
		if(a != null) {
			System.out.println("-> Assistante  existante :  "+a.getNom());
			return  a;
		}else {
			System.out.println("-> Assistante non existante ");
			return null;
		}
	}  

	public AssistanteMaternelle getAssistante() {
		return assistante;
	}

	public GardeFacade getGardeFacade() {
		return gardeFacade;
	}
}
