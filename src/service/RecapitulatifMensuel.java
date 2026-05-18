package service;

public class RecapitulatifMensuel {
    
    private int mois;
    private int annee;
    private double totalHeures;
    private double montantTotal;
    private int nombreEnfants;
    private int nombreJoursGarde;

    public RecapitulatifMensuel(int mois, int annee) {
        this.mois = mois;
        this.annee = annee;
    }

    public int getMois() { 
    	return mois; 
    }
    
    public int getAnnee() { 
    	return annee; 	
    }
    
    public double getTotalHeures() { 
    	return totalHeures; 
    }
    
    public void setTotalHeures(double totalHeures) { 
    	this.totalHeures = totalHeures; 
    }
    
    public double getMontantTotal() { 
    	return montantTotal; 
    }
    
    public void setMontantTotal(double montantTotal) { 
    	this.montantTotal = montantTotal; 
    }
    
    public int getNombreEnfants() { 
    	return nombreEnfants; 
    }
    
    public void setNombreEnfants(int nombreEnfants) { 
    	this.nombreEnfants = nombreEnfants; 
    }
    
    public int getNombreJoursGarde() { 
    	return nombreJoursGarde; 
    }
    
    public void setNombreJoursGarde(int nombreJoursGarde) { 
    	this.nombreJoursGarde = nombreJoursGarde; 
    }

    @Override
    public String toString() {
        return "    RÉCAPITULATIF " + mois + "/" + annee + "    \n" +
               "Nombre d'enfants gardés : " + nombreEnfants + "\n" +
               "Nombre de jours de garde : " + nombreJoursGarde + "\n" +
               "Total heures travaillées : " + totalHeures + "h\n" +
               "Montant total dû : " + montantTotal + "€";
    }
}