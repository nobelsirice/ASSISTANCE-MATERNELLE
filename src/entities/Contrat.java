package entities;

import java.time.LocalDate;
import java.util.HashSet;

import state.EtatContrat;
import state.ContratEnCours;
import state.ContratResilie;
import state.ContratSuspendu;
import state.ContratTermine;

public class Contrat {

    // Attributs
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String typeContrat;
    private Tarif tarif;
    private Service service;

    private EtatContrat etat;

    private Parent parent;
    private Enfant enfant;

    /* ===== Gestion globale ===== */
    private static Long compteur = 0L;
    public static HashSet<Contrat> listeContrat = new HashSet<>();

    // Constructeur
    public Contrat(LocalDate dateDebut, LocalDate dateFin, String typeContrat) {
    	compteur++;
    	this.id = compteur;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.typeContrat = typeContrat;
        this.etat = new ContratEnCours();
        listeContrat.add(this);
    }

    // Getters
    public Long getId() { return id; }
    public LocalDate getDateDebut() { return dateDebut; }
    public LocalDate getDateFin() { return dateFin; }
    public String getTypeContrat() { return typeContrat; }
    public Parent getParent() { return parent; }
    public Enfant getEnfant() { return enfant; }
    public Tarif getTarif() { return tarif; }
    public Service getService() { return service; }

	// Setters
    public void setId(Long id) { this.id = id; }
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }
    public void setTypeContrat(String typeContrat) { this.typeContrat = typeContrat; }
    public void setParent(Parent parent) { this.parent = parent; }
    public void setEnfant(Enfant enfant) { this.enfant = enfant; }
    public void setTarif(Tarif tarif) { this.tarif = tarif; }
	public void setService(Service service) { this.service = service; }

    // toString
    @Override
    public String toString() {
        return "Contrat{id=" + id + ", type='" + typeContrat + "', du " + dateDebut +
               " au " + dateFin + ", enfant=" + (enfant != null ? enfant.getNom() : "non défini") +
               ", parent=" + (parent != null ? parent.getNom() : "non défini") + "}";
    }

    /* ===== Méthodes liées au patron State ===== */
    public String getEtat() { return etat.getEtat(); }
    public void activer() { etat.activer(); etat = new ContratEnCours(); }
    public void suspendre() { etat.suspendre(); etat = new ContratSuspendu(); }
    public void resilier() { etat.resilier(); etat = new ContratResilie(); }
    public void terminer() { etat.terminer(); etat = new ContratTermine(); }


    /* ===== Affichage de la liste globale ===== */

    public static void afficherListeContrats() {
        System.out.println("=== Liste de tous les contrats ===");

        if (listeContrat.isEmpty()) {
            System.out.println("Aucun contrat n'est enregistré pour le moment.");
            return;
        }

        for (Contrat c : listeContrat) {
            System.out.println("ID : " + c.id + " | " + c.toString() + " [état=" + c.getEtat() + "]");
        }
    }


    /* ===== Recherche par ID ===== */

    public static Contrat rechercherParId(long id) {

        for (Contrat c : listeContrat) {
            if (c.id != null && c.id == id) {
                System.out.println("Contrat trouvé : id=" + c.id);
                return c;
            }
        }

        System.out.println("Le contrat avec l'ID " + id + " n'existe pas dans la liste.");
        return null;
    }
}
