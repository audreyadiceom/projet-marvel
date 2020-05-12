package main;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * Décrivez votre classe Avengers ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Avenger {
	// variables d'instance
	private String nomAvenger;
	private int nbPierresInfini;
	private ArrayList<SuperMechant> listMechantsAcombattre;

	/**
	 * Constructeur d'objets de classe Avengers
	 */
	public Avenger() {
		// initialisation des variables d'instance
		this.nbPierresInfini = 0;
		this.listMechantsAcombattre = new ArrayList<SuperMechant>();
		this.nomAvenger = "";
	}

	public Avenger(String nomAvenger) {
		// initialisation des variables d'instance
		this.nbPierresInfini = 0;
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
	}

	public void ajouterUnSuperMechant(SuperMechant superMechant) {
		/*
		 * System.out.println(superMechant.getNomMechant());
		 * System.out.println(this.getNomAvenger()); for(SuperMechant m :
		 * this.listMechantsAcombattre){ System.out.println(m.getNomMechant()+
		 * " m"); }
		 */
		System.out.println(superMechant.getAvengerAcombattre());
		System.out.println(superMechant.getNomMechant());
		if (!this.listMechantsAcombattre.contains(superMechant)) {
			this.listMechantsAcombattre.add(superMechant);

			if ((superMechant.getAvengerAcombattre() == null) || !superMechant.getAvengerAcombattre().equals(this)) {
				System.out.println("test");
				
				System.out.println(this.getNomAvenger());
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
