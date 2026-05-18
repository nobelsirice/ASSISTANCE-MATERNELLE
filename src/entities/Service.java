package entities;

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
}
