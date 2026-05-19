package facade;

import java.util.List;
import java.util.ArrayList;
import entities.Session;
import entities.Parent;
import entities.Enfant;
import entities.Service;
import service.ServiceRecapitulatif;
import service.RecapitulatifMensuel;

public class ParentFacade {

    private Parent parent;
    private List<Session> sessions;
    private ServiceRecapitulatif serviceRecapitulatif;
    private double montantDejaPaye;

    public ParentFacade(Parent parent, List<Session> sessions) {
        this.parent = parent;
        this.sessions = sessions;
        this.serviceRecapitulatif = new ServiceRecapitulatif();
        this.montantDejaPaye = 0;
    }
    
  //enfant du parent concerné
    private List<Session> sessionsduParent() {
        List<Session> sessionsFiltrees = new ArrayList<>();
        for (Session session : sessions) {
            if (session.getEnfant() != null && 
                parent.getListeEnfants().contains(session.getEnfant())) {
                sessionsFiltrees.add(session);
            }
        }
        return sessionsFiltrees;
    }

    // Nombre d'enfants mis en garde
    public int nombreEnfantsEnGarde() {
    	List<Session> sessionsFiltrees = sessionsduParent();
    	List<Long> ids = new ArrayList<>();
        for (Session session : sessionsFiltrees) {
            if (session.getEnfant() != null &&
                !ids.contains(session.getEnfant().getId())) {
                ids.add(session.getEnfant().getId());
            }
        }
        return ids.size();
    }

    // Total des heures de garde
    public double totalHeuresGarde() {
        double total = 0;
        for (Session session : sessionsduParent()) {
            total += session.calculerDuree();
        }
        return total;
    }

    // Montant total dû pour un mois
    public double montantDu(int mois, int annee) {
        RecapitulatifMensuel recap = serviceRecapitulatif.generer(
            sessionsduParent(), mois, annee);
        return recap.getMontantTotal();
    }

    // Montant restant à payer
    public double montantRestantAPayer(int mois, int annee) {
        return montantDu(mois, annee) - montantDejaPaye;
    }

    // Enregistrer un paiement
    public void enregistrerPaiement(double montant) {
        this.montantDejaPaye += montant;
    }

    // Afficher les services d'une session
    public void afficherServices() {
        System.out.println("=== SERVICES UTILISÉS ===");
        for (Session session : sessionsduParent()) {
            if (session.getContrat() != null &&
                session.getContrat().getService() != null) {
                Service s = session.getContrat().getService();
                System.out.println("Session du " + session.getDateArrive() + " :");
                if (s.isRepas()) System.out.println("  - Repas : " + s.getPrixRepas() + "€");
                if (s.isHygiene()) System.out.println("  - Hygiène : " + s.getPrixHygiene() + "€");
                if (s.isDouche()) System.out.println("  - Douche : " + s.getPrixDouche() + "€");
                if (s.isLecture()) System.out.println("  - Lecture : " + s.getPrixLecture() + "€");
                if (s.isActivitePhysique()) System.out.println("  - Activité : " + s.getPrixActivitePhysique() + "€");
            }
        }
    }

    // Afficher le bilan complet du parent
    public void afficherBilan(int mois, int annee) {
        System.out.println("    BILAN DE " + parent.getNom() + " " + parent.getPrenom() + "    ");
        System.out.println("Nombre d'enfants en garde : " + nombreEnfantsEnGarde());
        System.out.println("Total heures de garde : " + totalHeuresGarde() + "h");
        System.out.println("Montant dû : " + montantDu(mois, annee) + "€");
        System.out.println("Montant restant à payer : " + montantRestantAPayer(mois, annee) + "€");
        afficherServices();
    }

    public Parent getParent() { return parent; }
}