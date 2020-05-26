package marvel;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * Décrivez votre classe Avengers ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Avenger extends SuperHero{
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

		if (!this.listMechantsAcombattre.contains(superMechant)) {
			this.listMechantsAcombattre.add(superMechant);

			if ((superMechant.getSuperHeroAcombattre() == null) || !superMechant.getSuperHeroAcombattre().equals(this)) {
				superMechant.setAvengerAcombattre(this);
			}

		}
	}

	public void supprimerUnSuperMechant(SuperMechant superMechant) {
		if (this.listMechantsAcombattre.remove(superMechant)) {
			superMechant.supprimerUnSuperAvenger();
		}
	}

	public boolean sauverLeMonde() {
		for (SuperMechant mechant : this.listMechantsAcombattre) {
			if (mechant.situationFinDuMonde()) {// si au moins 1 mechant a
												// toutes les pierres
				return false;// on ne peut plus sauver le monde
			}
		}
		return true;
	}

	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		return (this.nomAvenger == ((Avenger) o).getNomAvenger());
	}

}
