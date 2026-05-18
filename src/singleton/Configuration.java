/**
 * 
 */
package singleton;

/**
 * 
 */
public class Configuration {
	
	// Attributs
    private double tauxHoraireDefaut;
    private int nbRepasMax;
    private double nbHeuresMax;

    // Instance unique
    private static Configuration instance;

    // Constructeur privé
    private Configuration() {
        this.tauxHoraireDefaut = 4.05;
        this.nbRepasMax = 3;
        this.nbHeuresMax = 10.0;
    }

    // Méthode d'accès unique
    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    // Getters
    public double getTauxHoraireDefaut() { return tauxHoraireDefaut; }
    public int getNbRepasMax() { return nbRepasMax; }
    public double getNbHeuresMax() { return nbHeuresMax; }

    // Setters
    public void setTauxHoraireDefaut(double tauxHoraireDefaut) { this.tauxHoraireDefaut = tauxHoraireDefaut; }
    public void setNbRepasMax(int nbRepasMax) { this.nbRepasMax = nbRepasMax; }
    public void setNbHeuresMax(double nbHeuresMax) { this.nbHeuresMax = nbHeuresMax; }

    // toString
    @Override
    public String toString() {
        return "Configuration{tauxHoraireDefaut=" + tauxHoraireDefaut +
               ", nbRepasMax=" + nbRepasMax +
               ", nbHeuresMax=" + nbHeuresMax + "}";
    }

}
