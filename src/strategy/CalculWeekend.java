package strategy;

import entities.Contrat;
import entities.Session;

public class CalculWeekend implements StrategyCalcul {

	private static final double majoration = 1.25;
	
	@Override
	public double calculer(Session session, Contrat contrat) {
		// TODO Auto-generated method stub
		double heure = session.calculerDuree();
		
		double montantHeure = heure * contrat.getTarif().getValeur() * majoration;
		
		double montantService = contrat.getService().CalculPrixTotal();
		
		return montantHeure + montantService;
	}

}
