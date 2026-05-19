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

    // Constructeur
    public Parent(String nom, String prenom, LocalDate dateNaiss, String metier,
                  String adresse, String mail, String telephone, char sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
        this.metier = metier;
        this.adresse = adresse;
        this.mail = mail;
        this.telephone = telephone;
        this.sexe = sexe;
        this.listeEnfants = new HashSet<>();
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
    
    

    // toString
    @Override
    public String toString() {
        return "Parent{id=" + id + ", nom='" + nom + "', prenom='" + prenom +
               "', telephone='" + telephone + "', nbEnfants=" + getNbEnfants() + "}";
    }
}