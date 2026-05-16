package factory;

import entities.Contrat;
import entities.Enfant;
import entities.Parent;
import java.time.LocalDate;

public class ContratFactory {

    // Compteur pour les ids
    private static Long compteur = 1L;

    // Méthode de création d'un contrat
    public static Contrat creerContrat(LocalDate dateDebut, LocalDate dateFin,
                                       String typeContrat, Enfant enfant, Parent parent) {

        // Création du contrat
        Contrat contrat = new Contrat(dateDebut, dateFin, typeContrat);

        // Attribution de l'id
        contrat.setId(compteur++);

        // Liaison enfant et parent
        contrat.setEnfant(enfant);
        contrat.setParent(parent);

        // Liaison du contrat au parent
        parent.ajouterEnfant(enfant);

        return contrat;
    }
}
