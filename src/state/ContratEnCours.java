/**
 * 
 */
package state;

public class ContratEnCours implements EtatContrat {

    @Override
    public void activer() {
        System.out.println("Le contrat est déjà en cours.");
    }

    @Override
    public void suspendre() {
        System.out.println("Le contrat est suspendu.");
    }

    @Override
    public void resilier() {
        System.out.println("Le contrat est résilié.");
    }

    @Override
    public void terminer() {
        System.out.println("Le contrat est terminé.");
    }

    @Override
    public String getEtat() {
        return "EN_COURS";
    }
}
