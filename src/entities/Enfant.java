package entities;

import java.time.LocalDate;

public class Enfant {

    // Attributs
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;
    private char sexe;
    private String remarque;
    private static Long compteur = 0L;


    // Constructeur
    public Enfant(String nom, String prenom, LocalDate dateDeNaissance, char sexe) {
    	compteur++;
    	this.id = compteur;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.sexe = sexe;
        this.remarque = "";
    }

    // Getters
    public Long getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public LocalDate getDateDeNaissance() { return dateDeNaissance; }
    public char getSexe() { return sexe; }
    public String getRemarque() { return remarque; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setDateDeNaissance(LocalDate dateDeNaissance) { this.dateDeNaissance = dateDeNaissance; }
    public void setSexe(char sexe) { this.sexe = sexe; }
    public void setRemarque(String remarque) { this.remarque = remarque; }

    // toString
    @Override
    public String toString() {
        return "Enfant{id=" + id + ", nom='" + nom + "', prenom='" + prenom +
               "', dateDeNaissance=" + dateDeNaissance + ", sexe=" + sexe + "}";
    }
}