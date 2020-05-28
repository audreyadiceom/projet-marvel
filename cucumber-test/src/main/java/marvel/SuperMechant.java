package marvel;

import sauvetage.Planete;

/**
 * Décrivez votre classe SuperMechant ici.
 *
 * @author audrey_adiceom
 * @version 08/05/2020
 */
public class SuperMechant extends Personnage {
	// attributs du super méchant
	private String nomMechant = "";
	private int nbPierresInfini = 0;// les pierres de l'infini sont cachées dans la galaxie. Elles ont chacune
									// un pouvoir et il y en a 6 differentes
	private boolean isFinDuMonde = false;// attributs permettant de savoir si c'est la fin du monde
	private Avenger avengerAcombattre = null;
	private Planete planeteAcombattre = null;

	// Constructeur
	public SuperMechant(String nomMechant, int nbPierresInfini) {
		this.nbPierresInfini = nbPierresInfini;
		this.nomMechant = nomMechant;
	}

	// getters et setters

	public String getNomMechant() {
		return nomMechant;
	}

	public int getNbPierresInfini() {
		return this.nbPierresInfini;
	}

	public void setNbPierresInfini(int nbPierresInfini) {
		this.nbPierresInfini = nbPierresInfini;
		if (this.nbPierresInfini == 6) {
			this.isFinDuMonde = true;
		}
	}

	public boolean getIsFinDuMonde() {
		return this.isFinDuMonde;
	}

	public Planete getPlaneteAcombattre() {
		return planeteAcombattre;
	}

	public void ajouterPlaneteAcombattre(Planete planeteAcombattre) {
		// on ajoute pour la premiere fois
		if (this.planeteAcombattre == (null)) {
			this.planeteAcombattre = planeteAcombattre;
			this.planeteAcombattre.ajouterSuperMechant(this);
		}
		// on a besoin de MAJ la situtation de la planete en cours avant de la changer
		if (!(this.planeteAcombattre.equals(planeteAcombattre))) {
			this.planeteAcombattre.supprimerSuperMechant();
			this.planeteAcombattre = planeteAcombattre;
			this.planeteAcombattre.ajouterSuperMechant(this);
		}

	}

	public void supprimerPlaneteAcombattre() {
		this.planeteAcombattre = null;
	}

	public Avenger getAvengerAcombattre() {
		return this.avengerAcombattre;
	}

	public void setAvengerAcombattre(Avenger avengerAcombattre) {

		if (this.avengerAcombattre == (null)) {// cas 0 : si il n'a pas déjà de avenger à combattre
			this.avengerAcombattre = avengerAcombattre; // ajout de l'avenger
			avengerAcombattre.ajouterUnSuperMechant(this); // MAJ de la liste de l'avenger en question
		}
		if (!(this.avengerAcombattre.equals(avengerAcombattre))) {// cas 1 : si il existait déjà un avenger a
																	// combattre et on vérifie qu'on ne l'a pas deja
																	// ajouté
			this.avengerAcombattre.supprimerUnSuperMechant(this);// on enleve a la liste de méchants de l'avenger le
																	// superMechant this
			this.avengerAcombattre = avengerAcombattre; // ajout de l'avenger
			avengerAcombattre.ajouterUnSuperMechant(this); // MAJ de la liste de l'avenger en question
		}
	}

	public void supprimerUnSuperAvenger() {
		this.avengerAcombattre = null;
	}

	// Methodes qui manipulent les attributs
	public boolean ajouterPierreInfini(String pierre) {
		if (this.nbPierresInfini < 6) {// si le mechant n'a pas deja toutes les pierres
			if (pierre.equals("Espace") || pierre.equals("Réalité") || pierre.equals("Pouvoir")
					|| pierre.equals("Esprit") || pierre.equals("Temps") || pierre.equals("Âme")) {
				this.nbPierresInfini++;
			}
		} // fin du monde si il a toute les pierres (true) false sinon
		return decimerLeMonde();
	}

	public boolean decimerLeMonde() {
		if (this.nbPierresInfini == 6) {
			this.isFinDuMonde = true;
		} else {
			this.isFinDuMonde = false;
		}
		return isFinDuMonde;
	}

	public boolean equals(Object o) {
		// deux mechants sont egaux si meme nom et meme bn de pierres.
		if (o == null) {
			return false;
		}
		return (this.nomMechant == ((SuperMechant) o).getNomMechant()
				&& (this.nbPierresInfini == ((SuperMechant) o).getNbPierresInfini()));
	}
}
