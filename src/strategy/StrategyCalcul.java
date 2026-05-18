package strategy;

import entities.Session;
import entities.Contrat;

public interface StrategyCalcul {

	double calculer(Session session, Contrat contrat);
}
