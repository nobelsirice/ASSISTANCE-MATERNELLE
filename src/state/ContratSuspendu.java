package state;

public class ContratSuspendu implements EtatContrat {

    @Override
    public void activer() {
        System.out.println("Le contrat est réactivé.");
    }

    @Override
    public void suspendre() {
        System.out.println("Le contrat est déjà suspendu.");
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
        return "SUSPENDU";
    }
}