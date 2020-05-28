package marvel;

import java.util.ArrayList;
import java.util.Collections;

import sauvetage.Planete;

/**
 * Décrivez votre classe Avengers ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Avenger {
	// variables d'instance
	private String nomAvenger = "";
	private int nbPierresInfini = 0;
	private ArrayList<SuperMechant> listMechantsAcombattre;

	/**
	 * Constructeur d'objets de classe Avengers
	 */
	public Avenger() {
		// initialisation des variables d'instance
		this.listMechantsAcombattre = new ArrayList<SuperMechant>();
	}

	public Avenger(String nomAvenger) {
		// initialisation des variables d'instance
		this.listMechantsAcombattre = new ArrayList<SuperMechant>();
		this.nomAvenger = nomAvenger;
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

	public String getNomAvenger() {
		return nomAvenger;
	}

	public void setNomAvenger(String nomAvenger) {
		this.nomAvenger = nomAvenger;
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
		// si superMechant ne fait pas déjà parti de la liste, on l'ajoute
		if (!this.listMechantsAcombattre.contains(superMechant)) {
			this.listMechantsAcombattre.add(superMechant);
			// MAJ de l'avenger a combattre du supermechant
			if ((superMechant.getAvengerAcombattre() == null) || !superMechant.getAvengerAcombattre().equals(this)) {
				superMechant.setAvengerAcombattre(this);
			}

		}
	}

	public void supprimerUnSuperMechant(SuperMechant superMechant) {
		// si je peux enlever ce super mechant de ma liste
		if (this.listMechantsAcombattre.remove(superMechant)) {
			// je MAJ l'avenger a combattre du super mechant
			superMechant.supprimerUnSuperAvenger();
		}
	}

	public boolean sauverLeMonde(Planete planeteAsauver) {
		// un avenger ne peut sauver que la Terre
		if (!planeteAsauver.getNomPlanete().equals("Terre")) {
			return false;
		}
		if (this.nbPierresInfini == 6) { // si il a toutes les pierres, il peut sauver le monde
			return true;
		}
		ajouterUnSuperMechant(planeteAsauver.getMechant());
		for (SuperMechant mechant : this.listMechantsAcombattre) {
			if (mechant.decimerLeMonde()) {// si au moins 1 mechant a toutes les pierres
				return false;// on ne peut plus sauver le monde
			}
		}
		return true;
	}

	public boolean equals(Object o) {
		// deux avengers sont égaux si ils ont le meme nom
		if (o == null) {
			return false;
		}
		return (this.nomAvenger == ((Avenger) o).getNomAvenger());
	}

	public boolean ajouterPierreInfini(String pierre) {
		if (this.nbPierresInfini < 6) {// si le super hero n'a pas deja toutes les pierres
			if (pierre.equals("Espace") || pierre.equals("Réalité") || pierre.equals("Pouvoir")
					|| pierre.equals("Esprit") || pierre.equals("Temps") || pierre.equals("Âme")) {
				this.nbPierresInfini++;
			}
		}
		// si il a (maintenant) toutes les pierres, il peut sauver le monde
		if (this.nbPierresInfini == 6) {
			return true;
		}
		return false;
	}

}
