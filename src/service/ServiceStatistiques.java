package service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import entities.Session;
import entities.Enfant;

public class ServiceStatistiques {

    private List<Session> sessions;

    public ServiceStatistiques(List<Session> sessions) {
        this.sessions = sessions;
    }

    // Total des heures travaillées sur toutes les sessions
    public double totalHeuresTravaillees() {
        double total = 0;
        for (Session session : sessions) {
            total += session.calculerDuree();
        }
        return total;
    }

    // Nombre total d'enfants accueillis
    public int nombreEnfantsAccueillis() {
        List<Long> ids = new java.util.ArrayList<>();
        for (Session session : sessions) {
            if (session.getEnfant() != null && 
                !ids.contains(session.getEnfant().getId())) {
                ids.add(session.getEnfant().getId());
            }
        }
        return ids.size();
    }

    // Enfant le plus souvent gardé
    public Enfant enfantLePlusGarde() {
        Map<Long, Integer> compteur = new HashMap<>();
        Map<Long, Enfant> enfants = new HashMap<>();

        for (Session session : sessions) {
            if (session.getEnfant() != null) {
                Long id = session.getEnfant().getId();
                enfants.put(id, session.getEnfant());
                compteur.put(id, compteur.getOrDefault(id, 0) + 1);
            }
        }

        Long idMax = null;
        int max = 0;
        for (Map.Entry<Long, Integer> entry : compteur.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                idMax = entry.getKey();
            }
        }

        return idMax != null ? enfants.get(idMax) : null;
    }

    // Rémunération moyenne par mois
    public double remunerationMoyenneParMois(ServiceRecapitulatif serviceRecap, 
                                              int moisDebut, int moisFin, int annee) {
        double total = 0;
        int nombreMois = moisFin - moisDebut + 1;

        for (int mois = moisDebut; mois <= moisFin; mois++) {
            RecapitulatifMensuel recap = serviceRecap.generer(sessions, mois, annee);
            total += recap.getMontantTotal();
        }

        return nombreMois > 0 ? total / nombreMois : 0;
    }

    // Afficher toutes les statistiques
    public void afficherStatistiques(ServiceRecapitulatif serviceRecap,
                                      int moisDebut, int moisFin, int annee) {
        System.out.println("=== STATISTIQUES ===");
        System.out.println("Total heures travaillées : " 
                         + totalHeuresTravaillees() + "h");
        System.out.println("Nombre d'enfants accueillis : " 
                         + nombreEnfantsAccueillis());
        
        Enfant enfant = enfantLePlusGarde();
        if (enfant != null) {
            System.out.println("Enfant le plus gardé : " 
                             + enfant.getNom() + " " + enfant.getPrenom());
        }
        
        System.out.println("Rémunération moyenne par mois : " 
                         + remunerationMoyenneParMois(serviceRecap, moisDebut, moisFin, annee) 
                         + "€");
    }
}