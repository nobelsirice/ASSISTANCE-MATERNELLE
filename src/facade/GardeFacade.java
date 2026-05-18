package facade;

import java.util.List;
import java.util.ArrayList;
import entities.Session;
import entities.AssistanteMaternelle;
import observer.GestionnaireGarde;
import observer.GenerateurRecapitulatif;
import service.ServiceRecapitulatif;
import service.ServiceStatistiques;
import service.RecapitulatifMensuel;

public class GardeFacade {

    private List<Session> sessions;
    private AssistanteMaternelle assistante;
    private GestionnaireGarde gestionnaireGarde;
    private ServiceRecapitulatif serviceRecapitulatif;
    private ServiceStatistiques serviceStatistiques;

    public GardeFacade(AssistanteMaternelle assistante) {
        this.assistante = assistante;
        this.sessions = new ArrayList<>();
        this.gestionnaireGarde = new GestionnaireGarde();
        this.serviceRecapitulatif = new ServiceRecapitulatif();
        this.serviceStatistiques = new ServiceStatistiques(sessions);

        // Abonner le générateur de récapitulatif
        GenerateurRecapitulatif generateur = new GenerateurRecapitulatif(sessions, assistante);
        gestionnaireGarde.abonner(generateur);
    }

    // Ajouter une session de garde
    public void ajouterSession(Session session) {
        sessions.add(session);
    }

    // Terminer le mois et générer le récapitulatif automatiquement
    public void terminerMois(int mois, int annee) {
        gestionnaireGarde.moisTermine(mois, annee);
    }

    // Obtenir le récapitulatif d'un mois
    public RecapitulatifMensuel obtenirRecapitulatif(int mois, int annee) {
        return serviceRecapitulatif.generer(sessions, mois, annee);
    }

    // Afficher les statistiques
    public void afficherStatistiques(int moisDebut, int moisFin, int annee) {
        serviceStatistiques.afficherStatistiques(serviceRecapitulatif, 
                                                  moisDebut, moisFin, annee);
    }

    // Getter pour les sessions
    public List<Session> getSessions() {
        return sessions;
    }

    // Getter pour l'assistante
    public AssistanteMaternelle getAssistante() {
        return assistante;
    }
}