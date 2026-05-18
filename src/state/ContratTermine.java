package state;

public class ContratTermine implements EtatContrat {

    @Override
    public void activer() {
        System.out.println("Impossible, le contrat est terminé.");
    }

    @Override
    public void suspendre() {
        System.out.println("Impossible, le contrat est terminé.");
    }

    @Override
    public void resilier() {
        System.out.println("Impossible, le contrat est terminé.");
    }

    @Override
    public void terminer() {
        System.out.println("Le contrat est déjà terminé.");
    }

    @Override
    public String getEtat() {
        return "TERMINE";
    }
}
