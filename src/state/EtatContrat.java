package state;

public interface EtatContrat {
    void activer();
    void suspendre();
    void resilier();
    void terminer();
    String getEtat();
}
