package entities;

import java.time.LocalDate;

public class Contrat {

    // Attributs
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String typeContrat;

    private Parent parent;
    private Enfant enfant;

    // Constructeur
    public Contrat(LocalDate dateDebut, LocalDate dateFin, String typeContrat) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.typeContrat = typeContrat;
    }

    // Getters
    public Long getId() { return id; }
    public LocalDate getDateDebut() { return dateDebut; }
    public LocalDate getDateFin() { return dateFin; }
    public String getTypeContrat() { return typeContrat; }
    public Parent getParent() { return parent; }
    public Enfant getEnfant() { return enfant; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }
    public void setTypeContrat(String typeContrat) { this.typeContrat = typeContrat; }
    public void setParent(Parent parent) { this.parent = parent; }
    public void setEnfant(Enfant enfant) { this.enfant = enfant; }

    // toString
    @Override
    public String toString() {
        return "Contrat{id=" + id + ", type='" + typeContrat + "', du " + dateDebut +
               " au " + dateFin + ", enfant=" + (enfant != null ? enfant.getNom() : "non défini") +
               ", parent=" + (parent != null ? parent.getNom() : "non défini") + "}";
    }
}