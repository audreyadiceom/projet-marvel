
import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import marvel.SuperMechant;

public class StepsTest {
	private SuperMechant thanos;
	private String nom_pierre;
	private int nbPierre;

	@Given("Thanos s approche d une pierre d infini nommée {string}")
	public void thanos_s_approche_d_une_pierre_d_infini_nommée(String string) {
		this.thanos = new SuperMechant("Thanos",0);
		this.nbPierre = thanos.getNbPierresInfini();
		this.nom_pierre = string;
	}

	@When("Thanos tente de la comptabiliser")
	public void thanos_tente_de_la_comptabiliser() {
		this.thanos.ajouterPierreInfini(nom_pierre);
	}

	@Then("le compteur de pierres de l'infini de Thanos doit être incrémenté.")
	public void le_compteur_de_pierres_de_l_infini_de_Thanos_doit_être_incrémenté() {
		assertEquals(this.nbPierre + 1, this.thanos.getNbPierresInfini());
	}

	@Given("Thanos s approche d une pierre non d infini nommée {string}")
	public void thanos_s_approche_d_une_pierre_non_d_infini_nommée(String string) {
		this.thanos = new SuperMechant("Thanos",0);
		this.nbPierre = this.thanos.getNbPierresInfini();
		this.nom_pierre = string;
	}

	@Then("le compteur de pierre de l infini de Thanosn est pas incrémenté.")
	public void le_compteur_de_pierre_de_l_infini_de_Thanosn_est_pas_incrémenté() {
		assertEquals(this.nbPierre, this.thanos.getNbPierresInfini());
	}
	
	

}
