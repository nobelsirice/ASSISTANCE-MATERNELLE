package entities;

<<<<<<< HEAD
public class Service {
	private Long idService;
	private boolean hygiene;
	private boolean activitePhysique;
	private boolean douche;
	private boolean lecture;
	private boolean repas;
    private double prixHygiene;
    private double prixActivitePhysique;
    private double prixDouche;
    private double prixLecture;
    private double prixRepas;
	
	public Service() {}
	
	public double CalculPrixTotal() {
		double total = 0;
		
		if(hygiene)
			total += prixHygiene;
		if(activitePhysique)
			total += prixActivitePhysique;
		if(douche)
			total += prixDouche;
		if(lecture)
			total += prixLecture;
		if(repas)
			total += prixRepas;
		
		return total;
	}

	public Long getIdService() {
		return idService;
	}

	public void setIdService(Long idService) {
		this.idService = idService;
	}

	public boolean isHygiene() {
		return hygiene;
	}

	public void setHygiene(boolean hygiene) {
		this.hygiene = hygiene;
	}

	public boolean isActivitePhysique() {
		return activitePhysique;
	}

	public void setActivitePhysique(boolean activitePhysique) {
		this.activitePhysique = activitePhysique;
=======
import java.math.BigDecimal;

public class Service {

	public int id_service;
	public String Libelle;
	public boolean hygienne;
	public boolean activite_physique;
	public boolean douche;
	public boolean lecture;
	public boolean repas;
	public BigDecimal prix;

	public static int compteur = 0;

	public Service(String libelle, boolean hygienne, boolean activite_physique, boolean douche, boolean lecture,
			boolean repas, BigDecimal prix) {

		compteur++;
		this.id_service = compteur;
		Libelle = libelle;
		this.hygienne = hygienne;
		this.activite_physique = activite_physique;
		this.douche = douche;
		this.lecture = lecture;
		this.repas = repas;
		this.prix = prix;
	}

	public int getId_service() {
		return id_service;
	}


	public String getLibelle() {
		return Libelle;
	}

	public void setLibelle(String libelle) {
		Libelle = libelle;
	}

	public boolean isHygienne() {
		return hygienne;
	}

	public void setHygienne(boolean hygienne) {
		this.hygienne = hygienne;
	}

	public boolean isActivite_physique() {
		return activite_physique;
	}

	public void setActivite_physique(boolean activite_physique) {
		this.activite_physique = activite_physique;
>>>>>>> dev
	}

	public boolean isDouche() {
		return douche;
	}

	public void setDouche(boolean douche) {
		this.douche = douche;
	}

	public boolean isLecture() {
		return lecture;
	}

	public void setLecture(boolean lecture) {
		this.lecture = lecture;
	}

	public boolean isRepas() {
		return repas;
	}

	public void setRepas(boolean repas) {
		this.repas = repas;
	}

<<<<<<< HEAD
	public double getPrixHygiene() {
		return prixHygiene;
	}

	public void setPrixHygiene(double prixHygiene) {
		this.prixHygiene = prixHygiene;
	}

	public double getPrixActivitePhysique() {
		return prixActivitePhysique;
	}

	public void setPrixActivitePhysique(double prixActivitePhysique) {
		this.prixActivitePhysique = prixActivitePhysique;
	}

	public double getPrixDouche() {
		return prixDouche;
	}

	public void setPrixDouche(double prixDouche) {
		this.prixDouche = prixDouche;
	}

	public double getPrixLecture() {
		return prixLecture;
	}

	public void setPrixLecture(double prixLecture) {
		this.prixLecture = prixLecture;
	}

	public double getPrixRepas() {
		return prixRepas;
	}

	public void setPrixRepas(double prixRepas) {
		this.prixRepas = prixRepas;
	}
=======
	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Service [id_service=" + id_service + ", Libelle=" + Libelle + ", hygienne=" + hygienne
				+ ", activite_physique=" + activite_physique + ", douche=" + douche + ", lecture=" + lecture
				+ ", repas=" + repas + ", prix=" + prix + "]";
	}

	
>>>>>>> dev
}
