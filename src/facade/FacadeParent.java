package facade;

import entities.Parent;

public class FacadeParent {
	private entities.Parent parent;

	public FacadeParent(Parent parent) {
		this.parent = parent;
	}

	/* afficher la liste de ses enfant inscrits */
	public void afficher_enfant() {
		parent.afficherEnfant();
	}
	
	/* afficher la liste des contrats  */
	public void afficher_contrat() {
		parent.afficherContrat();
	}

}
