package entities;

import java.util.HashSet;

public class Tarif {
	private Long idTarif;
	private double valeur;

	/* ===== Gestion globale ===== */
	private static Long compteur = 0L;
	public static HashSet<Tarif> listeTarifs = new HashSet<>();


	public Tarif(double valeur) {
		super();
		compteur++;
		this.idTarif = compteur;
		this.valeur = valeur;

		listeTarifs.add(this);
	}


	public Long getidTarif() {
		return idTarif;
	}


	public void setidTarif(Long idTarif) {
		this.idTarif = idTarif;
	}


	public double getValeur() {
		return valeur;
	}


	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

	@Override
    public String toString() {
        return "Tarif{id=" + idTarif + ", valeur=" + valeur + "€/h}";
    }


	/* ===== Affichage de la liste globale ===== */

	public static void afficherListeTarifs() {
		System.out.println("=== Liste de tous les tarifs ===");

		if (listeTarifs.isEmpty()) {
			System.out.println("Aucun tarif n'est enregistré pour le moment.");
			return;
		}

		for (Tarif t : listeTarifs) {
			System.out.println("ID : " + t.idTarif + " | Valeur : " + t.valeur + " €/h");
		}
	}


	/* ===== Recherche par ID ===== */

	public static Tarif rechercherParId(long id) {

		for (Tarif t : listeTarifs) {
			if (t.idTarif != null && t.idTarif == id) {
				System.out.println("Tarif trouvé : " + t.valeur + " €/h");
				return t;
			}
		}

		System.out.println("Le tarif avec l'ID " + id + " n'existe pas dans la liste.");
		return null;
	}
}
