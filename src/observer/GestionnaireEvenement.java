package observer;

public interface GestionnaireEvenement {
	//assistante maternelle voulant être notifier chaque fin du mois
	void abonner(AbonneRecapitulatif aR);
	//assistante maternelle ne voulant pas être notifier chaque fin du mois
    void desabonner(AbonneRecapitulatif aR);
    //permet de prevenir qu'il s'agit de la fin du mois
    void notifierTous(int mois, int annee);
}
