/**
 *
 */
package entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Session {

	// Attributs
	private Long id;
	private LocalDate dateArrive;
	private LocalTime heureArrive;
	private LocalDate dateDepart;
	private LocalTime heureDepart;

	private Enfant enfant;
	private Contrat contrat;

	/* ===== Gestion globale ===== */
	private static Long compteur = 0L;
	public static List<Session> listeSessions = new ArrayList<>();

	// Constructeur
	public Session(LocalDate dateArrive, LocalTime heureArrive, LocalDate dateDepart, LocalTime heureDepart) {
		compteur++;
		this.id = compteur;
		this.dateArrive = dateArrive;
		this.heureArrive = heureArrive;
		this.dateDepart = dateDepart;
		this.heureDepart = heureDepart;

		listeSessions.add(this);
	}

	// Calcul de la durée en heures
	public double calculerDuree() {
		Duration duree = Duration.between(heureArrive, heureDepart);
		return duree.toMinutes() / 60.0;
	}

	// Getters
	public Long getId() {
		return id;
	}

	public LocalDate getDateArrive() {
		return dateArrive;
	}

	public LocalTime getHeureArrive() {
		return heureArrive;
	}

	public LocalDate getDateDepart() {
		return dateDepart;
	}

	public LocalTime getHeureDepart() {
		return heureDepart;
	}

	public Enfant getEnfant() {
		return enfant;
	}

	public Contrat getContrat() {
		return contrat;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setDateArrive(LocalDate dateArrive) {
		this.dateArrive = dateArrive;
	}

	public void setHeureArrive(LocalTime heureArrive) {
		this.heureArrive = heureArrive;
	}

	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}

	public void setHeureDepart(LocalTime heureDepart) {
		this.heureDepart = heureDepart;
	}

	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	// toString
	@Override
	public String toString() {
		return "Session{id=" + id + ", arrivee=" + dateArrive + " " + heureArrive + ", depart=" + dateDepart + " "
				+ heureDepart + ", duree=" + calculerDuree() + "h" + ", enfant="
				+ (enfant != null ? enfant.getNom() : "non défini") + "}";
	}


	/* ===== Affichage de la liste globale ===== */

	public static void afficherListeSessions() {
		System.out.println("=== Liste de toutes les sessions ===");

		if (listeSessions.isEmpty()) {
			System.out.println("Aucune session n'est enregistrée pour le moment.");
			return;
		}

		for (Session s : listeSessions) {
			System.out.println("ID : " + s.id + " | " + s.toString());
		}
	}


	/* ===== Recherche par ID ===== */

	public static Session rechercherParId(long id) {

		for (Session s : listeSessions) {
			if (s.id != null && s.id == id) {
				System.out.println("Session trouvée : id=" + s.id);
				return s;
			}
		}

		System.out.println("La session avec l'ID " + id + " n'existe pas dans la liste.");
		return null;
	}
}
