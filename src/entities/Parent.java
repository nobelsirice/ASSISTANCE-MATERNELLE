package entities;

import java.time.LocalDate;
import java.util.HashSet;

public class Parent {

    // Attributs
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate dateNaiss;
    private String metier;
    private String adresse;
    private String mail;
    private String telephone;
    private char sexe;

    private HashSet<Enfant> listeEnfants;
    private HashSet<Contrat> listeContrat;

    /* ===== Gestion globale ===== */
    private static Long compteur = 0L;
    public static HashSet<Parent> listeParents = new HashSet<>();

    // Constructeur
    public Parent(String nom, String prenom, LocalDate dateNaiss, String metier,
                  String adresse, String mail, String telephone, char sexe) {
        compteur++;
    	this.id =  compteur;
    	this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
        this.metier = metier;
        this.adresse = adresse;
        this.mail = mail;
        this.telephone = telephone;
        this.sexe = sexe;
        this.listeEnfants = new HashSet<>();
        this.listeContrat = new HashSet<>();

        listeParents.add(this);
    }

    // Getters
    public Long getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public LocalDate getDateNaiss() { return dateNaiss; }
    public String getMetier() { return metier; }
    public String getAdresse() { return adresse; }
    public String getMail() { return mail; }
    public String getTelephone() { return telephone; }
    public char getSexe() { return sexe; }
    public HashSet<Enfant> getListeEnfants() { return listeEnfants; }
    public int getNbEnfants() { return listeEnfants.size(); }
    public HashSet<Contrat> getListeContrat() { return listeContrat; }
    public int getNbContrats() { return listeContrat.size(); }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setDateNaiss(LocalDate dateNaiss) { this.dateNaiss = dateNaiss; }
    public void setMetier(String metier) { this.metier = metier; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public void setMail(String mail) { this.mail = mail; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public void setSexe(char sexe) { this.sexe = sexe; }

    // Méthode ajouterEnfant
    public void ajouterEnfant(Enfant enfant) {
        this.listeEnfants.add(enfant);
    }
    
    

    // Méthode ajouterContrat
    public void ajouterContrat(Contrat contrat) {
        this.listeContrat.add(contrat);
    }

    // afficher la liste des enfants

    public void afficherEnfant() {
    	for (Enfant e : this.listeEnfants) {

    		System.out.println(e.getNom() +" " +e.getPrenom() +" sexe : "+e.getSexe()+" née le : "+e.getDateDeNaissance());
    	}
    }

// afficher la liste des contrats

    public void afficherContrat() {
    	int i = 1;
    	for (Contrat c : this.listeContrat) {
    		System.out.println(" contrat " + i + " : " + c.toString() + " [état=" + c.getEtat() + "]");
    		i++;
    	}
    }

    // toString
    @Override
    public String toString() {
        return "Parent{id=" + id + ", nom='" + nom + "', prenom='" + prenom +
               "', telephone='" + telephone + "', nbEnfants=" + getNbEnfants() + "}";
    }


    /* ===== Affichage de la liste globale ===== */

    public static void afficherListeParents() {
        System.out.println("=== Liste de tous les parents ===");

        if (listeParents.isEmpty()) {
            System.out.println("Aucun parent n'est enregistré pour le moment.");
            return;
        }

        for (Parent p : listeParents) {
            System.out.println("ID : " + p.id +
                    " | Nom : " + p.nom + " " + p.prenom +
                    " | Téléphone : " + p.telephone +
                    " | Mail : " + p.mail);
        }
    }


    /* ===== Recherche par ID ===== */

    public static Parent rechercherParId(long id) {

        for (Parent p : listeParents) {
            if (p.id != null && p.id == id) {
                System.out.println("Parent trouvé : " + p.nom + " " + p.prenom);
                return p;
            }
        }

        System.out.println("Le parent avec l'ID " + id + " n'existe pas dans la liste.");
        return null;
    }
    
    public static Parent rechercherParId(int id) {

        for (Parent p : listeParents) {
            if (p.id == id) {
                System.out.println("Parent trouvé : " + p.nom + " " + p.prenom);
                return p;
            }
        }

        System.out.println("le parent avec l'ID " + id + " n'existe pas dans la liste.");
        return null;
    }
    
    
    /*	 Rechercher les contrats par id */
    //public void chercherContratParId()
}
