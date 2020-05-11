

import static org.junit.Assert.assertEquals;

import cucumber.api.PendingException;  
import cucumber.api.java.en.Given;  
import cucumber.api.java.en.Then;  
import cucumber.api.java.en.When;
import main.SuperMechant;  

public class StepsTest {
	private SuperMechant thanos;
	private String nom_pierre;
	private int nbPierre;
	
	
	@Given("Thanos s approche d une pierre d infini nommée {string}")
	public void thanos_s_approche_d_une_pierre_d_infini_nommée(String string) {
		this.thanos = new SuperMechant("Thanos");
	    this.nbPierre=thanos.getNbPierresInfini();
	    this.nom_pierre=string;
	}

	@When("Thanos veut la comptabiliser")
	public void thanos_veut_la_comptabiliser() {
		this.thanos.ajouterPierreInfini(nom_pierre);
	}

	@Then("le compteur de pierres de l'infini de Thanos doit être incrémenté.")
	public void le_compteur_de_pierres_de_l_infini_de_Thanos_doit_être_incrémenté() {
		assertEquals(this.nbPierre+1, this.thanos.getNbPierresInfini());
	}

	@Given("Thanos s approche d une pierre non d infini nommée {string}")
	public void thanos_s_approche_d_une_pierre_non_d_infini_nommée(String string) {
		thanos = new SuperMechant();
	    nbPierre=thanos.getNbPierresInfini();
	    nom_pierre=string;
	}

	@Then("le +{int} de pierre de l infini de Thanosn est pas incrémenté.")
	public void le_de_pierre_de_l_infini_de_Thanosn_est_pas_incrémenté(Integer int1) {
		assertEquals(nbPierre, thanos.getNbPierresInfini());
	}

}
