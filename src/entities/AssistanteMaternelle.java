package entities;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class AssistanteMaternelle {
    
    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
    private String mail;
    private LocalDate dateNaiss;
    private double salaire;
    private String sexe;
    private String adresse;
    private List<Contrat> contrats;

    public AssistanteMaternelle(String nom, String prenom, String telephone, 
                                 String mail, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.mail = mail;
        this.adresse = adresse;
        this.contrats = new ArrayList<>();
    }

    public void ajouterContrat(Contrat contrat) {
        contrats.add(contrat);
    }

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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

    @Override
    public String toString() {
        return "AssistanteMaternelle{nom=" + nom + " " + prenom + 
               ", tel=" + telephone + ", mail=" + mail + "}";
    }
}