package observer;

import java.util.List;
import entities.Session;
import entities.AssistanteMaternelle;
import service.ServiceRecapitulatif;
import service.RecapitulatifMensuel;

public class GenerateurRecapitulatif implements AbonneRecapitulatif {

	private List<Session> sessions;
    private ServiceRecapitulatif serviceRecapitulatif;
    private AssistanteMaternelle assistante;

    public GenerateurRecapitulatif(List<Session> sessions, AssistanteMaternelle assistante) {
        this.sessions = sessions;
        this.assistante = assistante;
        this.serviceRecapitulatif = new ServiceRecapitulatif();
    }

    @Override
    public void notifier(int mois, int annee) {
        RecapitulatifMensuel recap = serviceRecapitulatif.generer(sessions, mois, annee);
        System.out.println("    RÉCAPITULATIF DE " + assistante.getNom() 
        + " " + assistante.getPrenom() + "    ");
        System.out.println(recap.toString());
    }

}
