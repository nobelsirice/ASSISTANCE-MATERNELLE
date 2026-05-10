/**
 * 
 */
package entities;

import java.time.LocalDate;

/**
 * 
 */
public class Enfant {
	
	// Attributs 
	private Long id;
	private String nom;
	private String prenom;
	private LocalDate dateDeNaissance;
	
	// Un constructeur
	public Enfant(String nom, String prenom, LocalDate date) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = date;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @param date the date to set
	 */
	public void setDateDeNaissance(LocalDate date) {
		this.dateDeNaissance = date;
	}
	
	// Un toString
	public String toString() {
		return id + " : " + nom + " " + prenom + " , née le : " + dateDeNaissance;
				
	}
}
