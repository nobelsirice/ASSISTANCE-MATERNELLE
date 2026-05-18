package observer;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireGarde implements GestionnaireEvenement {

	private List<AbonneRecapitulatif> abonnes = new ArrayList<AbonneRecapitulatif>();
	
	@Override
	public void abonner(AbonneRecapitulatif aR) {
		// TODO Auto-generated method stub
		abonnes.add(aR);
	}

	@Override
	public void desabonner(AbonneRecapitulatif aR) {
		// TODO Auto-generated method stub
		abonnes.remove(aR);
	}

	@Override
	public void notifierTous(int mois, int annee) {
		// TODO Auto-generated method stub
		for(AbonneRecapitulatif aR : abonnes)
		{
			aR.notifier(mois, annee);
		}
	}
	
	public void moisTermine(int mois, int annee) {
		notifierTous(mois, annee);
	}

}
