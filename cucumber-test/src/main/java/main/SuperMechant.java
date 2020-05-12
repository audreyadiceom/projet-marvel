package main;

import java.util.ArrayList;

/**
 * Décrivez votre classe SuperMechant ici.
 *
 * @author audrey_adiceom
 * @version 08/05/2020
 */
public class SuperMechant {
	// Création des attributs du super méchant
	private String nomMechant;
	private int nbPierresInfini;// les pierres de l'infini sont cachées dans la
								// galaxie. Elles ont chacune un pouvoir et il y
								// en a 6 differentes
	private boolean isFinDuMonde;// attributs permettant de savoir si c'est la
									// fin du monde
	private Avenger avengerAcombattre;

	// Constructeur
	public SuperMechant() {
		this.nbPierresInfini = 0;
		this.isFinDuMonde = false;
		this.avengerAcombattre = null;
		this.nomMechant = "";
	}

	public SuperMechant(int nbPierresInfini) {
		this.nbPierresInfini = nbPierresInfini;
		this.isFinDuMonde = false;
		this.avengerAcombattre = null;
		this.nomMechant = "";
	}

	public SuperMechant(String nomMechant) {
		this.nbPierresInfini = 0;
		this.isFinDuMonde = false;
		this.avengerAcombattre = null;
		this.nomMechant = nomMechant;
	}

	// getters et setters

	public String getNomMechant() {
		return nomMechant;
	}

	public void setNomMechant(String nomMechant) {
		this.nomMechant = nomMechant;
	}

	public int getNbPierresInfini() {
		return this.nbPierresInfini;
	}

	public void setNbPierresInfini(int nbPierresInfini) {
		this.nbPierresInfini = nbPierresInfini;
	}

	public boolean getIsFinDuMonde() {
		return this.isFinDuMonde;
	}

	/*
	 * public void setIsFinDuMonde(boolean isFinDuMonde){ this.isFinDuMonde =
	 * isFinDuMonde; }
	 */

	public Avenger getAvengerAcombattre() {
		return this.avengerAcombattre;
	}

	public void setAvengerAcombattre(Avenger avengerAcombattre) {
		/*
		 * System.out.println(avengerAcombattre.getNomAvenger());
		 * System.out.println(this.nomMechant);
		 * System.out.println(this.avengerAcombattre);
		 */
		if (this.avengerAcombattre == (null)) {// cas 0 : si il n'a pas déjà de
												// avenger à combattre
			// System.out.println("ok");
			this.avengerAcombattre = avengerAcombattre; // ajout de l'avenger
			avengerAcombattre.ajouterUnSuperMechant(this); // MAJ de la liste de
															// l'avenger en
															// question
		}
		if (!(this.avengerAcombattre.equals(avengerAcombattre))) {// cas 1 : si
																	// il
																	// existait
																	// déjà un
																	// avenger a
																	// combattre
																	// et on
																	// vérifie
																	// qu'on ne
																	// l'a pas
																	// deja
																	// ajouté
			// System.out.println("ok2");
			this.avengerAcombattre.supprimerUnSuperMechant(this);// on enleve a
																	// la liste
																	// de
																	// méchants
																	// de
																	// l'avenger
																	// le
																	// superMechant
																	// this
			this.avengerAcombattre = avengerAcombattre; // ajout de l'avenger
			avengerAcombattre.ajouterUnSuperMechant(this); // MAJ de la liste de
															// l'avenger en
															// question
		}
	}

	public void supprimerUnSuperAvenger() {
		this.avengerAcombattre = null;
	}

	// Methodes qui manipulent les attributs
	public void ajouterPierreInfini(String pierre) {
		if (this.nbPierresInfini < 6) {// si le mechant n'a pas deja toutes les
										// pierres
			if (pierre.equals("Espace") || pierre.equals("Réalité") || pierre.equals("Pouvoir")
					|| pierre.equals("Esprit") || pierre.equals("Temps") || pierre.equals("Âme")) {
				this.nbPierresInfini++;
			}
		}
	}

	public boolean situationFinDuMonde() {
		if (this.nbPierresInfini == 6) {
			this.isFinDuMonde = true;
		} else {
			this.isFinDuMonde = false;
		}
		return isFinDuMonde;
	}

	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		return (this.nomMechant == ((SuperMechant) o).getNomMechant());
	}
}
