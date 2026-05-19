package main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import entities.AssistanteMaternelle;
import entities.Contrat;
import entities.Enfant;
import entities.Parent;
import entities.Service;
import entities.Session;
import entities.Tarif;
import facade.FacadeAssistante;
import facade.FacadeParent;
import service.RecapitulatifMensuel;

public class Application {

	/**
	 * On garde une référence sur la FacadeAssistante de l'assistante de test numéro
	 * 1 pour qu'elle conserve ses sessions de test si l'utilisateur s'y connecte.
	 */
	private static FacadeAssistante facadeAssistanteTest1;

	public static void main(String[] args) {

		/* Initialisation des données de test (5 instances par classe) */
		try {
			initialiserDonneesDeTest();
		} catch (Exception e) {
			System.out.println(" Erreur lors de l'initialisation des données : " + e.getMessage());
		}

		Scanner s = new Scanner(System.in);

		System.out.print("== assistante (0)  ou parent (1)  == : ");

		int choix = s.nextInt();
		s.nextLine();

		if (choix == 0) {
			menuAssistante(s);
		} else if (choix == 1) {
			menuParent(s);
		} else {
			System.out.println(" Choix invalide. ");
		}

		s.close();
	}

	/*************************************************************************
	 * ASSISTANTE
	 * ********************************************************************
	 */

	public static void menuAssistante(Scanner s) {

		AssistanteMaternelle a = null;

		/**
		 * connexion ou creation en tant que assistante
		 */
		System.out.println(" 1: connexion ou 2: creation  : ");
		int choix = s.nextInt();
		s.nextLine();

		if (choix == 1) {
			System.out.print(" -> votre identifiant :  ");
			int id = s.nextInt();
			s.nextLine();
			a = AssistanteMaternelle.rechercherParId(id);
			if (a == null) {
				System.out.println(" Connexion impossible : assistante introuvable. ");
				return;
			}
		} else {

			a = new AssistanteMaternelle();

			System.out.print(" -> votre nom :  ");
			String nom = s.nextLine();
			System.out.println("");
			System.out.print(" -> votre prenom :  ");
			String prenom = s.nextLine();
			System.out.println("");
			System.out.print(" -> votre mail :  ");
			String mail = s.nextLine();
			System.out.println("");
			System.out.print(" -> votre numero de telephone :  ");
			String telephone = s.nextLine();
			System.out.println("");
			System.out.print(" -> votre adresse  :  ");
			String adresse = s.nextLine();
			System.out.println("");

			a.setNom(nom);
			a.setPrenom(prenom);
			a.setMail(mail);
			a.setTelephone(telephone);
			a.setAdresse(adresse);
		}

		/*
		 * Si on se connecte à l'assistante de test #1, on réutilise la FacadeAssistante
		 * déjà créée afin de garder les sessions de test pré-enregistrées.
		 */
		FacadeAssistante facadeAssistante;
		if (a.getId() == 1 && facadeAssistanteTest1 != null) {
			facadeAssistante = facadeAssistanteTest1;
		} else {
			facadeAssistante = new FacadeAssistante(a);
		}

		/* Boucle du menu */
		int operation;
		do {
			afficherMenuOperationsAssistante();
			operation = s.nextInt();
			s.nextLine();

			switch (operation) {

			case 1:
				System.out.println("-> Consulter les informations de l'assistante");
				facadeAssistante.afficherInfosAssistante();
				break;

			case 2: {
				System.out.println("-> Créer un contrat");

				/* informations du parent */
				System.out.println(" --- informations du parent --- ");
				System.out.print("	-> nom du parent : ");
				String nomP = s.nextLine();
				System.out.print("	-> prenom du parent : ");
				String prenomP = s.nextLine();
				System.out.print("	-> sexe du parent (M/F) : ");
				char sexeP = s.nextLine().charAt(0);
				System.out.print("	-> date de naissance du parent (AAAA-MM-JJ) : ");
				LocalDate dateNaissP = LocalDate.parse(s.nextLine());
				System.out.print("	-> metier du parent : ");
				String metierP = s.nextLine();
				System.out.print("	-> adresse du parent : ");
				String adresseP = s.nextLine();
				System.out.print("	-> mail du parent : ");
				String mailP = s.nextLine();
				System.out.print("	-> telephone du parent : ");
				String telP = s.nextLine();

				Parent parent = new Parent(nomP, prenomP, dateNaissP, metierP, adresseP, mailP, telP, sexeP);

				/* informations de l'enfant */
				System.out.println(" --- informations de l'enfant --- ");
				System.out.print("	-> nom de l'enfant : ");
				String nomE = s.nextLine();
				System.out.print("	-> prenom de l'enfant : ");
				String prenomE = s.nextLine();
				System.out.print("	-> date de naissance (AAAA-MM-JJ) : ");
				LocalDate dateNaissE = LocalDate.parse(s.nextLine());
				System.out.print("	-> sexe (M/F) : ");
				char sexeE = s.nextLine().charAt(0);

				Enfant enfant = new Enfant(nomE, prenomE, dateNaissE, sexeE);

				/* informations du contrat */
				System.out.println(" --- informations du contrat --- ");
				System.out.print("	-> date de debut (AAAA-MM-JJ) : ");
				LocalDate dateDebut = LocalDate.parse(s.nextLine());
				System.out.print("	-> date de fin (AAAA-MM-JJ) : ");
				LocalDate dateFin = LocalDate.parse(s.nextLine());
				System.out.print("	-> type de contrat : ");
				String typeC = s.nextLine();

				System.out.print("	-> tarif horaire (€/h) : ");
				double valTarif = s.nextDouble();
				s.nextLine();
				Tarif tarif = new Tarif(valTarif);

				/* services inclus */
				System.out.println(" --- services inclus --- ");
				Service service = new Service();

				System.out.print("	-> hygiene ? (o/n) : ");
				if (s.nextLine().equalsIgnoreCase("o")) {
					service.setHygiene(true);
					System.out.print("		-> prix hygiene : ");
					service.setPrixHygiene(s.nextDouble());
					s.nextLine();
				}
				System.out.print("	-> activite physique ? (o/n) : ");
				if (s.nextLine().equalsIgnoreCase("o")) {
					service.setActivitePhysique(true);
					System.out.print("		-> prix activite physique : ");
					service.setPrixActivitePhysique(s.nextDouble());
					s.nextLine();
				}
				System.out.print("	-> douche ? (o/n) : ");
				if (s.nextLine().equalsIgnoreCase("o")) {
					service.setDouche(true);
					System.out.print("		-> prix douche : ");
					service.setPrixDouche(s.nextDouble());
					s.nextLine();
				}
				System.out.print("	-> lecture ? (o/n) : ");
				if (s.nextLine().equalsIgnoreCase("o")) {
					service.setLecture(true);
					System.out.print("		-> prix lecture : ");
					service.setPrixLecture(s.nextDouble());
					s.nextLine();
				}
				System.out.print("	-> repas ? (o/n) : ");
				if (s.nextLine().equalsIgnoreCase("o")) {
					service.setRepas(true);
					System.out.print("		-> prix repas : ");
					service.setPrixRepas(s.nextDouble());
					s.nextLine();
				}

				facadeAssistante.creerContrat(dateDebut, dateFin, typeC, enfant, parent, tarif, service);
				break;
			}

			case 3:
				System.out.println("-> Afficher tous les contrats");
				facadeAssistante.afficherContrats();
				break;

			case 4: {
				System.out.println("-> Activer un contrat");
				facadeAssistante.afficherContrats();
				System.out.print("	-> id du contrat a activer : ");
				int idC = s.nextInt();
				s.nextLine();
				Contrat c = chercherContrat(a, idC);
				if (c != null) {
					facadeAssistante.activerContrat(c);
				} else {
					System.out.println(" Contrat introuvable. ");
				}
				break;
			}

			case 5: {
				System.out.println("-> Suspendre un contrat");
				facadeAssistante.afficherContrats();
				System.out.print("	-> id du contrat a suspendre : ");
				int idC = s.nextInt();
				s.nextLine();
				Contrat c = chercherContrat(a, idC);
				if (c != null) {
					facadeAssistante.suspendreContrat(c);
				} else {
					System.out.println(" Contrat introuvable. ");
				}
				break;
			}

			case 6: {
				System.out.println("-> Résilier un contrat");
				facadeAssistante.afficherContrats();
				System.out.print("	-> id du contrat a resilier : ");
				int idC = s.nextInt();
				s.nextLine();
				Contrat c = chercherContrat(a, idC);
				if (c != null) {
					facadeAssistante.resilierContrat(c);
				} else {
					System.out.println(" Contrat introuvable. ");
				}
				break;
			}

			case 7: {
				System.out.println("-> Terminer un contrat");
				facadeAssistante.afficherContrats();
				System.out.print("	-> id du contrat a terminer : ");
				int idC = s.nextInt();
				s.nextLine();
				Contrat c = chercherContrat(a, idC);
				if (c != null) {
					facadeAssistante.terminerContrat(c);
				} else {
					System.out.println(" Contrat introuvable. ");
				}
				break;
			}

			case 8: {
				System.out.println("-> Consulter l'état d'un contrat");
				facadeAssistante.afficherContrats();
				System.out.print("	-> id du contrat : ");
				int idC = s.nextInt();
				s.nextLine();
				Contrat c = chercherContrat(a, idC);
				if (c != null) {
					System.out
							.println(" Etat du contrat num " + idC + " : " + facadeAssistante.consulterEtatContrat(c));
				} else {
					System.out.println(" Contrat introuvable. ");
				}
				break;
			}

			case 9: {
				System.out.println("-> Enregistrer une session ");
				facadeAssistante.afficherContrats();
				System.out.print("	-> id du contrat associé : ");
				int idC = s.nextInt();
				s.nextLine();
				Contrat c = chercherContrat(a, idC);
				if (c == null) {
					System.out.println(" Contrat introuvable. ");
					break;
				}

				System.out.print("	-> date d'arrivée (AAAA-MM-JJ) : ");
				LocalDate dArr = LocalDate.parse(s.nextLine());
				System.out.print("	-> heure d'arrivée (HH:MM) : ");
				LocalTime hArr = LocalTime.parse(s.nextLine());
				System.out.print("	-> date de départ (AAAA-MM-JJ) : ");
				LocalDate dDep = LocalDate.parse(s.nextLine());
				System.out.print("	-> heure de départ (HH:MM) : ");
				LocalTime hDep = LocalTime.parse(s.nextLine());

				Session session = new Session(dArr, hArr, dDep, hDep);
				session.setContrat(c);
				session.setEnfant(c.getEnfant());
				facadeAssistante.enregistrerSession(session);
				System.out.println(" Session num " + session.getId() + " enregistrée. ");
				break;
			}

			case 10: {
				System.out.println("-> Enregistrer une session (données directes)");
				facadeAssistante.afficherContrats();
				System.out.print("	-> id du contrat associé : ");
				int idC = s.nextInt();
				s.nextLine();
				Contrat c = chercherContrat(a, idC);
				if (c == null) {
					System.out.println(" Contrat introuvable. ");
					break;
				}

				System.out.print("	-> date d'arrivée (AAAA-MM-JJ) : ");
				LocalDate dArr = LocalDate.parse(s.nextLine());
				System.out.print("	-> heure d'arrivée (HH:MM) : ");
				LocalTime hArr = LocalTime.parse(s.nextLine());
				System.out.print("	-> date de départ (AAAA-MM-JJ) : ");
				LocalDate dDep = LocalDate.parse(s.nextLine());
				System.out.print("	-> heure de départ (HH:MM) : ");
				LocalTime hDep = LocalTime.parse(s.nextLine());

				Session sess = facadeAssistante.enregistrerSession(dArr, hArr, dDep, hDep, c.getEnfant(), c);
				System.out.println(" Session num " + sess.getId() + " enregistrée. ");
				break;
			}

			case 11: {
				System.out.println("-> Cloturer un mois");
				System.out.print("	-> mois (1-12) : ");
				int mois = s.nextInt();
				System.out.print("	-> année : ");
				int annee = s.nextInt();
				s.nextLine();
				facadeAssistante.cloturerMois(mois, annee);
				break;
			}

			case 12: {
				System.out.println("-> Obtenir un récapitulatif mensuel");
				System.out.print("	-> mois (1-12) : ");
				int mois = s.nextInt();
				System.out.print("	-> année : ");
				int annee = s.nextInt();
				s.nextLine();
				RecapitulatifMensuel r = facadeAssistante.obtenirRecapitulatif(mois, annee);
				System.out.println(r);
				break;
			}

			case 13: {
				System.out.println("-> Afficher les statistiques");
				System.out.print("	-> mois début (1-12) : ");
				int mDeb = s.nextInt();
				System.out.print("	-> mois fin (1-12) : ");
				int mFin = s.nextInt();
				System.out.print("	-> année : ");
				int an = s.nextInt();
				s.nextLine();
				facadeAssistante.afficherStatistiques(mDeb, mFin, an);
				break;
			}

			case 14:
				System.out.println("-> Afficher la configuration globale");
				facadeAssistante.afficherConfiguration();
				break;

			case 15: {
				System.out.println("-> Modifier le taux horaire par défaut");
				System.out.print("	-> nouveau taux : ");
				double t = s.nextDouble();
				s.nextLine();
				facadeAssistante.modifierTauxHoraireDefaut(t);
				facadeAssistante.afficherConfiguration();
				break;
			}

			case 16: {
				System.out.println("-> Modifier le nombre maximal de repas");
				System.out.print("	-> nouveau nombre : ");
				int n = s.nextInt();
				s.nextLine();
				facadeAssistante.modifierNbRepasMax(n);
				facadeAssistante.afficherConfiguration();
				break;
			}

			case 17: {
				System.out.println("-> Modifier le nombre maximal d'heures par session");
				System.out.print("	-> nouveau nombre d'heures : ");
				double nh = s.nextDouble();
				s.nextLine();
				facadeAssistante.modifierNbHeuresMax(nh);
				facadeAssistante.afficherConfiguration();
				break;
			}

			case 18:
				System.out.println("-> Terminer le programme");
				break;

			default:
				System.out.println("-> Opération non prise en compte");
				break;
			}
		} while (operation != 18);

		System.out.println(" Programme terminé ! ");
	}
	
	
	

	/*************************************************************************
	 * PARENT ********************************************************************
	 */

	public static void menuParent(Scanner s) {

		Parent p = null;

		/**
		 * connexion ou creation en tant que parent
		 */
		System.out.println(" 1: connexion ou 2: creation  : ");
		int choix = s.nextInt();
		s.nextLine();

		if (choix == 1) {
			System.out.print(" -> votre identifiant :  ");
			int id = s.nextInt();
			s.nextLine();
			p = Parent.rechercherParId(id);
			if (p == null) {
				System.out.println(" Connexion impossible : parent introuvable. ");
				return;
			}
		} else {

			System.out.print(" -> votre nom :  ");
			String nom = s.nextLine();
			System.out.print(" -> votre prenom :  ");
			String prenom = s.nextLine();
			System.out.print(" -> votre sexe (M/F) :  ");
			char sexe = s.nextLine().charAt(0);
			System.out.print(" -> votre date de naissance (AAAA-MM-JJ) :  ");
			LocalDate dateNaiss = LocalDate.parse(s.nextLine());
			System.out.print(" -> votre metier :  ");
			String metier = s.nextLine();
			System.out.print(" -> votre adresse :  ");
			String adresse = s.nextLine();
			System.out.print(" -> votre mail :  ");
			String mail = s.nextLine();
			System.out.print(" -> votre numero de telephone :  ");
			String telephone = s.nextLine();

			p = new Parent(nom, prenom, dateNaiss, metier, adresse, mail, telephone, sexe);
		}

		FacadeParent facadeParent = new FacadeParent(p);

		int operation;
		do {
			afficherMenuOperationsParent();
			operation = s.nextInt();
			s.nextLine();

			switch (operation) {

			case 1:
				System.out.println("-> Consulter les informations du parent");
				facadeParent.afficherInfosParent();
				break;

			case 2:
				System.out.println("-> Afficher la liste de mes enfants");
				facadeParent.afficher_enfant();
				break;

			case 3: {
				System.out.println("-> Inscrire un nouvel enfant");
				System.out.print("	-> nom de l'enfant : ");
				String nomE = s.nextLine();
				System.out.print("	-> prenom de l'enfant : ");
				String prenomE = s.nextLine();
				System.out.print("	-> date de naissance (AAAA-MM-JJ) : ");
				LocalDate dn = LocalDate.parse(s.nextLine());
				System.out.print("	-> sexe (M/F) : ");
				char sx = s.nextLine().charAt(0);
				facadeParent.inscrireEnfant(nomE, prenomE, dn, sx);
				break;
			}

			case 4:
				System.out.println("-> Afficher la liste de mes contrats");
				facadeParent.afficher_contrat();
				break;

			case 5: {
				System.out.println("-> Consulter l'état d'un de mes contrats");
				facadeParent.afficher_contrat();
				System.out.print("	-> id du contrat : ");
				int idC = s.nextInt();
				s.nextLine();
				Contrat c = facadeParent.chercherContratParId(idC);
				if (c != null) {
					System.out.println(" Etat du contrat num " + idC + " : " + facadeParent.consulterEtatContrat(c));
				} else {
					System.out.println(" Contrat introuvable. ");
				}
				break;
			}

			case 6: {
				System.out.println("-> Consulter le récapitulatif mensuel");
				System.out.print("	-> mois (1-12) : ");
				int mois = s.nextInt();
				System.out.print("	-> année : ");
				int annee = s.nextInt();
				s.nextLine();
				RecapitulatifMensuel r = facadeParent.obtenirRecapitulatif(mois, annee);
				System.out.println(r);
				break;
			}

			case 7:
				System.out.println("-> Afficher la configuration globale");
				facadeParent.afficherConfiguration();
				break;

			case 8:
				System.out.println("-> Terminer le programme");
				break;

			default:
				System.out.println("-> Opération non prise en compte");
				break;
			}
		} while (operation != 8);

		System.out.println(" Au revoir ! ");
	}

	/* =isertion de quelques données pour le test */

	private static void initialiserDonneesDeTest() throws Exception {

		/* 5 Parents */
		Parent p1 = new Parent("Dupont", "Marie", LocalDate.of(1985, 3, 15), "Médecin", "1 rue de Paris",
				"marie.dupont@mail.com", "0601020304", 'F');
		Parent p2 = new Parent("Martin", "Jean", LocalDate.of(1980, 7, 22), "Ingénieur", "2 rue de Lyon",
				"jean.martin@mail.com", "0605060708", 'M');
		Parent p3 = new Parent("Bernard", "Sophie", LocalDate.of(1988, 11, 5), "Enseignante", "3 rue de Marseille",
				"sophie.bernard@mail.com", "0609101112", 'F');
		Parent p4 = new Parent("Petit", "Luc", LocalDate.of(1982, 6, 30), "Avocat", "4 rue de Toulouse",
				"luc.petit@mail.com", "0613141516", 'M');
		Parent p5 = new Parent("Durand", "Claire", LocalDate.of(1990, 1, 10), "Architecte", "5 rue de Nice",
				"claire.durand@mail.com", "0617181920", 'F');

		/* 5 Enfants */
		Enfant e1 = new Enfant("Dupont", "Lucas", LocalDate.of(2022, 2, 1), 'M');
		Enfant e2 = new Enfant("Martin", "Emma", LocalDate.of(2021, 5, 14), 'F');
		Enfant e3 = new Enfant("Bernard", "Léo", LocalDate.of(2023, 8, 19), 'M');
		Enfant e4 = new Enfant("Petit", "Chloé", LocalDate.of(2022, 11, 3), 'F');
		Enfant e5 = new Enfant("Durand", "Hugo", LocalDate.of(2023, 4, 25), 'M');

		/* 5 Tarifs */
		Tarif t1 = new Tarif(4.05);
		Tarif t2 = new Tarif(4.50);
		Tarif t3 = new Tarif(5.00);
		Tarif t4 = new Tarif(4.80);
		Tarif t5 = new Tarif(5.25);

		/* 5 Services */
		Service s1 = new Service();
		s1.setRepas(true);
		s1.setPrixRepas(3.0);
		s1.setHygiene(true);
		s1.setPrixHygiene(1.5);

		Service s2 = new Service();
		s2.setLecture(true);
		s2.setPrixLecture(2.0);
		s2.setActivitePhysique(true);
		s2.setPrixActivitePhysique(2.5);

		Service s3 = new Service();
		s3.setDouche(true);
		s3.setPrixDouche(2.0);
		s3.setRepas(true);
		s3.setPrixRepas(3.5);

		Service s4 = new Service();
		s4.setHygiene(true);
		s4.setPrixHygiene(1.5);
		s4.setLecture(true);
		s4.setPrixLecture(2.0);
		s4.setRepas(true);
		s4.setPrixRepas(3.0);

		Service s5 = new Service();
		s5.setActivitePhysique(true);
		s5.setPrixActivitePhysique(2.5);
		s5.setDouche(true);
		s5.setPrixDouche(2.0);

		/* 5 AssistantesMaternelles */
		AssistanteMaternelle a1 = new AssistanteMaternelle("Lefèvre", "Anne", "0712345678", "anne.lefevre@mail.com",
				LocalDate.of(1978, 4, 12), 1800.0, "F", "10 rue du Lac");
		new AssistanteMaternelle("Moreau", "Brigitte", "0723456789", "brigitte.moreau@mail.com",
				LocalDate.of(1975, 9, 7), 1850.0, "F", "11 rue du Bois");
		new AssistanteMaternelle("Robert", "Catherine", "0734567890", "catherine.robert@mail.com",
				LocalDate.of(1980, 2, 22), 1750.0, "F", "12 rue des Fleurs");
		new AssistanteMaternelle("Lambert", "Sophie", "0745678901", "sophie.lambert@mail.com",
				LocalDate.of(1985, 6, 18), 1900.0, "F", "13 rue du Pont");
		new AssistanteMaternelle("Bonnet", "Marie", "0756789012", "marie.bonnet@mail.com", LocalDate.of(1982, 11, 30),
				1950.0, "F", "14 rue de l'Église");

		/*
		 * 5 Contrats (tous attribués à l'assistante #1 pour faciliter les tests)
		 * Création via la FacadeAssistante pour que parent.listeContrat et
		 * assistante.contrats soient correctement renseignés.
		 */
		facadeAssistanteTest1 = new FacadeAssistante(a1);

		Contrat c1 = facadeAssistanteTest1.creerContrat(LocalDate.of(2025, 1, 1), LocalDate.of(2026, 1, 1), "CDD", e1,
				p1, t1, s1);
		Contrat c2 = facadeAssistanteTest1.creerContrat(LocalDate.of(2025, 2, 1), LocalDate.of(2026, 2, 1), "CDI", e2,
				p2, t2, s2);
		Contrat c3 = facadeAssistanteTest1.creerContrat(LocalDate.of(2025, 3, 1), LocalDate.of(2026, 3, 1), "CDD", e3,
				p3, t3, s3);
		Contrat c4 = facadeAssistanteTest1.creerContrat(LocalDate.of(2025, 4, 1), LocalDate.of(2026, 4, 1), "CDI", e4,
				p4, t4, s4);
		Contrat c5 = facadeAssistanteTest1.creerContrat(LocalDate.of(2025, 5, 1), LocalDate.of(2026, 5, 1), "CDD", e5,
				p5, t5, s5);

		/* 5 Sessions (une par contrat) — utiles pour tester récap et stats */
		facadeAssistanteTest1.enregistrerSession(LocalDate.of(2025, 1, 15), LocalTime.of(8, 30),
				LocalDate.of(2025, 1, 15), LocalTime.of(17, 30), e1, c1);
		facadeAssistanteTest1.enregistrerSession(LocalDate.of(2025, 2, 10), LocalTime.of(9, 0),
				LocalDate.of(2025, 2, 10), LocalTime.of(18, 0), e2, c2);
		facadeAssistanteTest1.enregistrerSession(LocalDate.of(2025, 3, 12), LocalTime.of(8, 0),
				LocalDate.of(2025, 3, 12), LocalTime.of(16, 0), e3, c3);
		facadeAssistanteTest1.enregistrerSession(LocalDate.of(2025, 4, 8), LocalTime.of(7, 45),
				LocalDate.of(2025, 4, 8), LocalTime.of(17, 45), e4, c4);
		facadeAssistanteTest1.enregistrerSession(LocalDate.of(2025, 5, 20), LocalTime.of(8, 15),
				LocalDate.of(2025, 5, 20), LocalTime.of(18, 15), e5, c5);
	}

	/*
	 * ===================================================================== HELPERS
	 * =====================================================================
	 */

	/**
	 * Cherche un contrat par son id parmi ceux gérés par l'assistante
	 */
	public static Contrat chercherContrat(AssistanteMaternelle a, int id) {
		for (Contrat c : a.getContrats()) {
			if (c.getId() != null && c.getId() == id) {
				return c;
			}
		}
		return null;
	}

	public static void afficherMenuOperationsAssistante() {
		System.out.println("  ");

		System.out.println("=== Liste des opérations disponibles pour l'assistante maternelle ===");

		System.out.println("1) Consulter les informations de l'assistante");
		System.out.println("2) Créer un contrat");
		System.out.println("3) Afficher tous les contrats");
		System.out.println("4) Activer un contrat");
		System.out.println("5) Suspendre un contrat");
		System.out.println("6) Résilier un contrat");
		System.out.println("7) Terminer un contrat");
		System.out.println("8) Consulter l'état d'un contrat");

		System.out.println("9) Enregistrer une session de garde (avec objet Session)");
		System.out.println("10) Enregistrer une session de garde (données directes)");

		System.out.println("11) Clôturer un mois");
		System.out.println("12) Obtenir un récapitulatif mensuel");
		System.out.println("13) Afficher les statistiques");

		System.out.println("14) Afficher la configuration globale");
		System.out.println("15) Modifier le taux horaire par défaut");
		System.out.println("16) Modifier le nombre maximal de repas");
		System.out.println("17) Modifier le nombre maximal d'heures par session");

		System.out.println("18) Terminer le programme");

		System.out.println("------------------------------------------------------------");
		System.out.print("		votre choix : ");
	}

	public static void afficherMenuOperationsParent() {
		System.out.println("  ");

		System.out.println("=== Liste des opérations disponibles pour le parent ===");

		System.out.println("1) Consulter mes informations");
		System.out.println("2) Afficher la liste de mes enfants");
		System.out.println("3) Inscrire un nouvel enfant");
		System.out.println("4) Afficher la liste de mes contrats");
		System.out.println("5) Consulter l'état d'un de mes contrats");
		System.out.println("6) Consulter le récapitulatif mensuel");
		System.out.println("7) Afficher la configuration globale");

		System.out.println("8) Terminer le programme");

		System.out.println("------------------------------------------------------------");
		System.out.print("		votre choix : ");
	}
}
