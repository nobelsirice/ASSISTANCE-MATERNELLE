package observer;

public class GenerateurRecapitulatif implements AbonneRecapitulatif {

	@Override
	public void notifier(int mois, int annee) {
		// TODO Auto-generated method stub
		System.out.println("Votre récapitulatif du mois de : " + mois + "/" + annee);
	}

}
