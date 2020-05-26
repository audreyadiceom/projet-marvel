package marvel;

import java.util.ArrayList;

public class GardienGalaxie extends SuperHero {
	private String nomGardien = "";
	private int nbPierresInfini = 0;
	private ArrayList<SuperMechant> listMechantsAcombattre;

	/**
	 * Constructeur d'objets de classe Avengers
	 */
	public GardienGalaxie() {
		// initialisation des variables d'instance
		this.listMechantsAcombattre = new ArrayList<SuperMechant>();
	}

	public GardienGalaxie(String nomGardien) {
		// initialisation des variables d'instance
		this.listMechantsAcombattre = new ArrayList<SuperMechant>();
		this.nomGardien = nomGardien;
	}

	/**
	 * Getters et setters
	 */
	public int getNbPierresInfini() {
		return this.nbPierresInfini;
	}

	public void setNbPierresInfini(int nbPierresInfini) {
		this.nbPierresInfini = nbPierresInfini;
	}

	public String getNomGardien() {
		return nomGardien;
	}

	public void setNomGardien(String nomGardien) {
		this.nomGardien = nomGardien;
	}

	public ArrayList<SuperMechant> getListMechantsAcombattre() {
		ArrayList<SuperMechant> listeRetour = new ArrayList<SuperMechant>();
		listeRetour.addAll(this.listMechantsAcombattre);
		return listeRetour;
		// return (ArrayList<SuperMechant>)
		// Collections.unmodifiableList(this.listMechantsAcombattre);
		// le test testRemplacerMechantsAcombattre() ne fonctionne pas avec
		// cette liste
	}

	public void ajouterUnSuperMechant(SuperMechant superMechant) {

		if (!this.listMechantsAcombattre.contains(superMechant)) {
			this.listMechantsAcombattre.add(superMechant);

			if ((superMechant.getSuperHeroAcombattre() == null)
					|| !superMechant.getSuperHeroAcombattre().equals(this)) {
				superMechant.setAvengerAcombattre(this);
			}

		}
	}

	public void supprimerUnSuperMechant(SuperMechant superMechant) {
		if (this.listMechantsAcombattre.remove(superMechant)) {
			superMechant.supprimerUnSuperAvenger();
		}
	}

	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		return (this.nomGardien == ((GardienGalaxie) o).getNomGardien());
	}

	@Override
	boolean sauverLeMonde() {
		for (SuperMechant mechant : this.listMechantsAcombattre) {
			if (mechant.situationFinDuMonde()) {// si au moins 1 mechant a
												// toutes les pierres
				return false;// on ne peut plus sauver le monde
			}
			if (mechant.getPlaneteAdecimer().equals("Terre")) {
				return false;
			}
		}
		return true;
	}

	@Override
	boolean ajouterPierreInfini(String pierre) {

		if (this.nbPierresInfini < 6) {// si le mechant n'a pas deja toutes les
			// pierres
			if (pierre.equals("Espace") || pierre.equals("Réalité") || pierre.equals("Pouvoir")
					|| pierre.equals("Esprit") || pierre.equals("Temps") || pierre.equals("Âme")) {
				this.nbPierresInfini++;
			}
		}
		if (this.nbPierresInfini == 6) {
			return true;
		}
		return false;

	}

}
