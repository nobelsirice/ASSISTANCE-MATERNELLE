/**
 * 
 */
package entities;

import java.time.LocalDate;
import java.util.HashSet;

/**
 * 
 */
public class Parent {
	
	
	// Attributs 
		private Long id;
		private char sexe;
		private String nom;
		private String prenom;
		private LocalDate dateDeNaissance;
		private String tel;
		private String mail;
		private String adresse;
		
		private HashSet<Enfant> listeEnfants;
		
		
		// Un constructeur
		public Parent (char sexe, String nom, String prenom, LocalDate date, String tel, String mail, String adresse) {
			this.sexe = sexe;
			this.nom = nom;
			this.prenom = prenom;
			this.dateDeNaissance = date;
			this.tel = tel;
			this.mail = mail;
			this.adresse = adresse;
			
			this.listeEnfants = new HashSet<>();
			
		}


		/**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}


		/**
		 * @return the sexe
		 */
		public char getSexe() {
			return sexe;
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
		 * @return the dateDeNaissance
		 */
		public LocalDate getDateDeNaissance() {
			return dateDeNaissance;
		}


		/**
		 * @return the tel
		 */
		public String getTel() {
			return tel;
		}


		/**
		 * @return the mail
		 */
		public String getMail() {
			return mail;
		}


		/**
		 * @return the adresse
		 */
		public String getAdresse() {
			return adresse;
		}

		/**
		 * @return the listeEnfants
		 */
		public HashSet<Enfant> getListeEnfants() {
			return listeEnfants;
		}


		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			this.id = id;
		}


		/**
		 * @param sexe the sexe to set
		 */
		public void setSexe(char sexe) {
			this.sexe = sexe;
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
		 * @param dateDeNaissance the dateDeNaissance to set
		 */
		public void setDateDeNaissance(LocalDate dateDeNaissance) {
			this.dateDeNaissance = dateDeNaissance;
		}


		/**
		 * @param tel the tel to set
		 */
		public void setTel(String tel) {
			this.tel = tel;
		}


		/**
		 * @param mail the mail to set
		 */
		public void setMail(String mail) {
			this.mail = mail;
		}


		/**
		 * @param adresse the adresse to set
		 */
		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

		// Fonctions
		public void ajouterEnfant(Enfant enfant) {
		    this.listeEnfants.add(enfant);
		}
		
		public String toString() {
			return sexe + " : " + nom + " " + prenom + " a " +  getNbreEnf();	
		}


		/**
		 * @return the nbreEnf
		 */
		public int getNbreEnf() {
			return listeEnfants.size();
		}


}
