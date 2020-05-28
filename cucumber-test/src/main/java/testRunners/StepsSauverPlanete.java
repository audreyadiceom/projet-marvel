package testRunners;
 
import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import marvel.Avenger;
import marvel.SuperMechant;
import sauvetage.Planete;
import sauvetage.SauverParAvenger;
import sauvetage.SauverParGardien;
import sauvetage.SauvetageStrategie;

public class StepsSauverPlanete {

	private Planete planete;
	private SuperMechant superMechant;
	private SauvetageStrategie sauvetage;
	private boolean sauver;

	@Given("{string} est attaqué par SuperMechant {string}")
	public void est_attaqué_par_SuperMechant(String nom_planete, String nom_mechant) {
		// on regarde d'abord si la planete à sauver est la terre ou non
		// pour savoir quel type de sauvetage on va faire
		if (nom_planete.equals("Terre")) {
			this.sauvetage = new SauverParAvenger();
		} else {
			this.sauvetage = new SauverParGardien();
		}
		// on instancie la planete et son mechant en consequence
		this.planete = new Planete(nom_planete, this.sauvetage);
		this.superMechant = new SuperMechant(nom_mechant, 0);
		this.planete.ajouterSuperMechant(superMechant);

	}

	@When("Cette planete appelle au secours")
	public void cette_planete_appelle_au_secours() {
		// elle fait demande de l'aide et on stocke le resultat dans un booléen
		this.sauver = this.planete.sauverMoi();
	}

	@Then("Cette planete est sauvée")
	public void cette_planete_est_sauvée() {
		// on vérifie qu'elle a bien été sauvée
		assertEquals(true, sauver);
	}

}



