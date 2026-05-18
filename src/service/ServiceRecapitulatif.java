package service;

import java.util.List;
import entities.Session;
import entities.Contrat;
import strategy.StrategyCalcul;
import strategy.CalculJourNormaux;
import strategy.CalculWeekend;
import strategy.CalculJourFerie;

public class ServiceRecapitulatif {

    public RecapitulatifMensuel generer(List<Session> sessions, int mois, int annee) {
        
        RecapitulatifMensuel recap = new RecapitulatifMensuel(mois, annee);
        
        double totalHeures = 0;
        double montantTotal = 0;
        int nombreJours = 0;
        
        for (Session session : sessions) {
            if (session.getDateArrive().getMonthValue() == mois &&
                session.getDateArrive().getYear() == annee) {
                
                StrategyCalcul strategie = choisirStrategie(session);
                
                double montantSession = strategie.calculer(session, session.getContrat());
                
                totalHeures += session.calculerDuree();
                montantTotal += montantSession;
                nombreJours++;
            }
        }
        
        recap.setTotalHeures(totalHeures);
        recap.setMontantTotal(montantTotal);
        recap.setNombreJoursGarde(nombreJours);
        
        return recap;
    }

    private StrategyCalcul choisirStrategie(Session session) {
        switch (session.getDateArrive().getDayOfWeek()) {
            case SATURDAY:
            case SUNDAY:
                return new CalculWeekend();
            default:
                return new CalculJourNormaux();
        }
    }
}