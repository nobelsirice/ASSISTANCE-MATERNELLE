package entities;

import java.time.LocalDate;
import java.util.HashSet;

public class Enfant {

    // Attributs
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;
    private char sexe;
    private String remarque;

    /* ===== Gestion globale ===== */
    private static Long compteur = 0L;
    public static HashSet<Enfant> listeEnfants = new HashSet<>();


    // Constructeur
    public Enfant(String nom, String prenom, LocalDate dateDeNaissance, char sexe) {
    	compteur++;
    	this.id = compteur;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.sexe = sexe;
        this.remarque = "";

        listeEnfants.add(this);
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


    /* ===== Affichage de la liste globale ===== */

    public static void afficherListeEnfants() {
        System.out.println("=== Liste de tous les enfants ===");

        if (listeEnfants.isEmpty()) {
            System.out.println("Aucun enfant n'est enregistré pour le moment.");
            return;
        }

        for (Enfant e : listeEnfants) {
            System.out.println("ID : " + e.id +
                    " | Nom : " + e.nom + " " + e.prenom +
                    " | Sexe : " + e.sexe +
                    " | Date de naissance : " + e.dateDeNaissance);
        }
    }


    /* ===== Recherche par ID ===== */

    public static Enfant rechercherParId(long id) {

        for (Enfant e : listeEnfants) {
            if (e.id != null && e.id == id) {
                System.out.println("Enfant trouvé : " + e.nom + " " + e.prenom);
                return e;
            }
        }

        System.out.println("L'enfant avec l'ID " + id + " n'existe pas dans la liste.");
        return null;
    }
}
