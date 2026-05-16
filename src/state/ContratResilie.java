package state;

public class ContratResilie implements EtatContrat {

    @Override
    public void activer() {
        System.out.println("Impossible, le contrat est résilié.");
    }

    @Override
    public void suspendre() {
        System.out.println("Impossible, le contrat est résilié.");
    }

    @Override
    public void resilier() {
        System.out.println("Le contrat est déjà résilié.");
    }

    @Override
    public void terminer() {
        System.out.println("Impossible, le contrat est résilié.");
    }

    @Override
    public String getEtat() {
        return "RESILIE";
    }
}
