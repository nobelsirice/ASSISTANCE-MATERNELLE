package entities;

import java.time.LocalDate;

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

    // Constructeur
    public Contrat(LocalDate dateDebut, LocalDate dateFin, String typeContrat) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.typeContrat = typeContrat;
        this.etat = new ContratEnCours();
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
    
 // Ajoute ces méthodes
    public String getEtat() { return etat.getEtat(); }
    public void activer() { etat.activer(); etat = new ContratEnCours(); }
    public void suspendre() { etat.suspendre(); etat = new ContratSuspendu(); }
    public void resilier() { etat.resilier(); etat = new ContratResilie(); }
    public void terminer() { etat.terminer(); etat = new ContratTermine(); }
}