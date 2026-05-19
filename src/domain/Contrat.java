package domain;

import java.util.Date;

public class Contrat {
 public int id_contrat;
 public Date date_debut;
 public Date date_fin;
 public String type_contrat;
 
 public static int compteur = 0 ;
 
 public Contrat(Date date_debut, Date date_fin, String type_contrat, int compteur) {
	
	compteur++;
	this.id_contrat = compteur;
	this.date_debut = date_debut;
	this.date_fin = date_fin;
	this.type_contrat = type_contrat;
	compteur = compteur;
}

 public int getId_contrat() {
	return id_contrat;
 }



 public Date getDate_debut() {
	return date_debut;
 }

 public void setDate_debut(Date date_debut) {
	this.date_debut = date_debut;
 }

 public Date getDate_fin() {
	return date_fin;
 }

 public void setDate_fin(Date date_fin) {
	this.date_fin = date_fin;
 }

 public String getType_contrat() {
	return type_contrat;
 }

 public void setType_contrat(String type_contrat) {
	this.type_contrat = type_contrat;
 }

 @Override
 public String toString() {
	return "Contrat [id_contrat=" + id_contrat + ", date_debut=" + date_debut + ", date_fin=" + date_fin
			+ ", type_contrat=" + type_contrat + "]";
 }

 
}
