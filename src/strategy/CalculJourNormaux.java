package strategy;

import entities.Contrat;
import entities.Session;

public class CalculJourNormaux implements StrategyCalcul {

	@Override
	public double calculer(Session session, Contrat contrat) {
		// TODO Auto-generated method stub
		double heure = session.calculerDuree();
		
		double montantHeure = heure * contrat.getTarif().getValeur();
		
		double montantService = contrat.getService().CalculPrixTotal();
		
		return montantHeure + montantService;
	}
}
