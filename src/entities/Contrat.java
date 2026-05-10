/**
 * 
 */
package entities;

import java.time.LocalDate;

/**
 * 
 */
public class Contrat {
	
	// Attributs 
			private Long id;
			private LocalDate dateDebut;
			private LocalDate dateFin;
			private double tauxHoraire;
			private double duree;
			private int repas;
			
			private Parent parent;
			private Enfant enfant;
			
			// Un constructeur
			public Contrat (LocalDate dateDebut, LocalDate dateFin, double tauxHoraire, double duree, int repas) {
				this.dateDebut = dateDebut;
				this.dateFin = dateFin;
				this.tauxHoraire = tauxHoraire;
				this.duree = duree;
				this.repas = repas;
			
			}

			/**
			 * @return the id
			 */
			public Long getId() {
				return id;
			}

			/**
			 * @return the dateDebut
			 */
			public LocalDate getDateDebut() {
				return dateDebut;
			}

			/**
			 * @return the dateFin
			 */
			public LocalDate getDateFin() {
				return dateFin;
			}

			/**
			 * @return the tauxHoraire
			 */
			public double getTauxHoraire() {
				return tauxHoraire;
			}

			/**
			 * @return the duree
			 */
			public double getDuree() {
				return duree;
			}

			/**
			 * @return the repas
			 */
			public int getRepas() {
				return repas;
			}

			/**
			 * @param id the id to set
			 */
			public void setId(Long id) {
				this.id = id;
			}

			/**
			 * @param dateDebut the dateDebut to set
			 */
			public void setDateDebut(LocalDate dateDebut) {
				this.dateDebut = dateDebut;
			}

			/**
			 * @param dateFin the dateFin to set
			 */
			public void setDateFin(LocalDate dateFin) {
				this.dateFin = dateFin;
			}

			/**
			 * @param tauxHoraire the tauxHoraire to set
			 */
			public void setTauxHoraire(double tauxHoraire) {
				this.tauxHoraire = tauxHoraire;
			}

			/**
			 * @param duree the duree to set
			 */
			public void setDuree(double duree) {
				this.duree = duree;
			}

			/**
			 * @return the parent
			 */
			public Parent getParent() {
				return parent;
			}

			/**
			 * @return the enfant
			 */
			public Enfant getEnfant() {
				return enfant;
			}

			/**
			 * @param parent the parent to set
			 */
			public void setParent(Parent parent) {
				this.parent = parent;
			}

			/**
			 * @param enfant the enfant to set
			 */
			public void setEnfant(Enfant enfant) {
				this.enfant = enfant;
			}

			/**
			 * @param repas the repas to set
			 */
			public void setRepas(int repas) {
				this.repas = repas;
			}
}
