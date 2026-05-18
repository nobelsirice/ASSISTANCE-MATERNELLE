package entities;

public class Tarif {
	private Long idTarif;
	private double valeur;
	
	
	public Tarif(double valeur) {
		super();
		this.valeur = valeur;
	}


	public Long getidTarif() {
		return idTarif;
	}


	public void setidTarif(Long idTarif) {
		this.idTarif = idTarif;
	}


	public double getValeur() {
		return valeur;
	}


	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	
	@Override
    public String toString() {
        return "Tarif{id=" + idTarif + ", valeur=" + valeur + "€/h}";
    }
	
}
