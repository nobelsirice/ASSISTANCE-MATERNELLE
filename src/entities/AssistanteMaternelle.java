package entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class AssistanteMaternelle {

    /* ===== Attributs ===== */
    private int id;
    private String nom;
    private String prenom;
    private String telephone;
    private String mail;
    private LocalDate dateNaiss;
    private double salaire = 0 ;
    private String sexe;
    private String adresse;

    private List<Contrat> contrats;

    /* ===== Gestion globale ===== */
    public static int compteur = 0;
    public static HashSet<AssistanteMaternelle> listeAssistantes = new HashSet<>();


    /* ===== Constructeurs ===== */

    // Constructeur complet
    public AssistanteMaternelle(String nom, String prenom, String telephone, String mail,
                                LocalDate dateNaiss, double salaire, String sexe, String adresse) throws Exception {

        if(salaire < 0) {
        	throw new Exception ("un salaire ne peut etre negatif");
        }
    	
    	compteur++;
        this.id = compteur;

        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.mail = mail;
        this.dateNaiss = dateNaiss;
        this.salaire = salaire;
        this.sexe = sexe;
        this.adresse = adresse;

        this.contrats = new ArrayList<>();

        listeAssistantes.add(this);
    }

    // Constructeur minimal
    public AssistanteMaternelle(String nom, String prenom, String telephone, String mail, String adresse) {

        compteur++;
        this.id = compteur;

        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.mail = mail;
        this.adresse = adresse;

        this.contrats = new ArrayList<>();

        listeAssistantes.add(this);
    }
    
    public AssistanteMaternelle() {
    	 compteur++;
         this.id = compteur;
         listeAssistantes.add(this);
         
    }


    /* ===== Méthodes métier ===== */

    public void ajouterContrat(Contrat contrat) {
        contrats.add(contrat);
    }


    /* ===== Getters / Setters ===== */

    public int getId() { return id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }

    public LocalDate getDateNaiss() { return dateNaiss; }
    public void setDateNaiss(LocalDate dateNaiss) { this.dateNaiss = dateNaiss; }

    public double getSalaire() { return salaire; }
    public void setSalaire(double salaire) { this.salaire = salaire; }

    public String getSexe() { return sexe; }
    public void setSexe(String sexe) { this.sexe = sexe; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public List<Contrat> getContrats() { return contrats; }


    /* ===== Méthodes utilitaires ===== */

    @Override
    public String toString() {
        return "AssistanteMaternelle [id=" + id +
               ", nom=" + nom +
               ", prenom=" + prenom +
               ", telephone=" + telephone +
               ", mail=" + mail +
               ", dateNaiss=" + dateNaiss +
               ", salaire=" + salaire +
               ", sexe=" + sexe +
               ", adresse=" + adresse + "]";
    }


    /* ===== Affichage de la liste ===== */

    public static void afficherListeAssistantes() {
        System.out.println("=== Liste des assistantes maternelles enregistrées ===");

        if (listeAssistantes.isEmpty()) {
            System.out.println("Aucune assistante n'est enregistrée pour le moment.");
            return;
        }

        for (AssistanteMaternelle a : listeAssistantes) {
            System.out.println("ID : " + a.id +
                    " | Nom : " + a.nom + " " + a.prenom +
                    " | Téléphone : " + a.telephone +
                    " | Mail : " + a.mail);
        }
    }


    /* ===== Recherche par ID ===== */

    public static AssistanteMaternelle rechercherParId(int id) {

        for (AssistanteMaternelle a : listeAssistantes) {
            if (a.id == id) {
                System.out.println("Assistante trouvée : " + a.nom + " " + a.prenom);
                return a;
            }
        }

        System.out.println("L'assistante avec l'ID " + id + " n'existe pas dans la liste.");
        return null;
    }
}
