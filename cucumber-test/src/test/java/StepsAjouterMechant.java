import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import marvel.Avenger;
import marvel.SuperMechant;

public class StepsAjouterMechant {

	private Avenger avenger;
	private SuperMechant superMechant;

	@Given("{string} se rend compte que {string} veut détruire le monde")
	public void se_rend_compte_que_veut_détruire_le_monde(String string, String string2) {
		this.avenger = new Avenger(string);
		this.superMechant = new SuperMechant(string2,0,"");
	}

	@When("Le {int} est inférieur à {int}")
	public void le_est_inférieur_à(Integer int1, Integer int2) {
		this.superMechant.setNbPierresInfini(int1);
		assertEquals(true, (int1 < int2));

	}

	@When("Il veut pouvoir le combattre")
	public void il_veut_pouvoir_le_combattre() {
		this.avenger.ajouterUnSuperMechant(superMechant);
	}

	@Then("Le monde est sauvé")
	public void le_monde_est_sauvé() {
		assertEquals(true, this.avenger.sauverLeMonde());
	}

	@When("Le {int} est égal à {int}")
	public void le_est_égal_à(Integer int1, Integer int2) {
		this.superMechant.setNbPierresInfini(int1);
		assertEquals(true, (int1 == int2));
	}

	@Then("Le monde n'est pas_sauvé")
	public void le_monde_n_est_pas_sauvé() {
		assertEquals(false, this.avenger.sauverLeMonde());
	}

}


