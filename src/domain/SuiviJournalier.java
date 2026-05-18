package domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class SuiviJournalier {
	public static int compteur = 0;
	public int idSuiviJournalier;
	public LocalDate dateArrive;
	public LocalTime heureArrive;
	public LocalDate dateDepart;
	public LocalTime heureDepart;
	
	
	public SuiviJournalier(LocalDate dateArrive, LocalTime heureArrive, LocalDate dateDepart,
			LocalTime heureDepart) {
		super();
		compteur++;
		idSuiviJournalier = compteur;
		this.dateArrive = dateArrive;
		this.heureArrive = heureArrive;
		this.dateDepart = dateDepart;
		this.heureDepart = heureDepart;
	}


	public int getIdSuiviJournalier() {
		return idSuiviJournalier;
	}


	public void setIdSuiviJournalier(int idSuiviJournalier) {
		this.idSuiviJournalier = idSuiviJournalier;
	}


	public LocalDate getDateArrive() {
		return dateArrive;
	}


	public void setDateArrive(LocalDate dateArrive) {
		this.dateArrive = dateArrive;
	}


	public LocalTime getHeureArrive() {
		return heureArrive;
	}


	public void setHeureArrive(LocalTime heureArrive) {
		this.heureArrive = heureArrive;
	}


	public LocalDate getDateDepart() {
		return dateDepart;
	}


	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}


	public LocalTime getHeureDepart() {
		return heureDepart;
	}


	public void setHeureDepart(LocalTime heureDepart) {
		this.heureDepart = heureDepart;
	}
	
	
	
}
