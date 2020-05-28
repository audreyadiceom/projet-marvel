package marvelTests;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import marvel.Avenger;
import marvel.SuperMechant;
import sauvetage.Planete;


public class SuperMechantTest {

	private SuperMechant thanos;
	private SuperMechant loki;
	private SuperMechant joker;
	private Avenger ironMan;

	/**
	 * Constructeur de la classe-test SuperMechantTest
	 */
	public SuperMechantTest() {
	}

	/**
	 * Met en place les engagements.
	 *
	 * Méthode appelée avant chaque appel de méthode de test.
	 */
	@Before
	public void setUp() // throws java.lang.Exception
	{

		thanos = new SuperMechant("thanos",3);
		ironMan = new Avenger("ironMan");
		thanos.setAvengerAcombattre(ironMan);
		loki = new SuperMechant("loki",0);
		joker = new SuperMechant("joker",1);

	}

	
	@Test
	public void testNbPierresInfini() {
		assertEquals(3, thanos.getNbPierresInfini());
	}

	@Test
	public void testConstructeurs() {
		assertEquals(1, joker.getNbPierresInfini());
		assertEquals("loki", loki.getNomMechant());
	}

	@Test
	public void testNomMechant() {
		SuperMechant mechant = new SuperMechant();
		mechant.setNomMechant("Jean");
		assertEquals("Jean", mechant.getNomMechant());
	}

	@Test
	public void testIsFinDuMonde() {
		assertEquals(false, thanos.getIsFinDuMonde());
	}

	@Test
	public void testSituationMonde() {
		SuperMechant superMec1 = new SuperMechant();
		assertEquals(false, superMec1.decimerLeMonde());
	}

	@Test
	public void testAvengersAcombattre() {
		assertEquals(ironMan, thanos.getAvengerAcombattre());
		Assert.assertEquals(true, ironMan.getListMechantsAcombattre().contains(thanos));
		Avenger odin = new Avenger("odin");
		thanos.setAvengerAcombattre(odin);
		assertEquals(odin, thanos.getAvengerAcombattre());
		Assert.assertEquals(true, odin.getListMechantsAcombattre().contains(thanos));
		Assert.assertEquals(false, ironMan.getListMechantsAcombattre().contains(thanos));

	}

	@Test
	public void testEquals() {
		SuperMechant thanos2 = new SuperMechant("thanos",0);
		thanos2.setNbPierresInfini(3);
		Assert.assertEquals(thanos, thanos2);
		Assert.assertNotNull(thanos);
		Assert.assertNotNull(ironMan);
		Assert.assertEquals(thanos, thanos);
		Assert.assertEquals(thanos.getNbPierresInfini(), 3);
		thanos2.setNbPierresInfini(6);
		Assert.assertEquals(6, thanos2.getNbPierresInfini());
		Assert.assertEquals(true, thanos2.decimerLeMonde());

	}

	@Test
	public void testAjoutPierreInfini() {
		int nbPierre = thanos.getNbPierresInfini();
		thanos.ajouterPierreInfini("Âme");
		assertEquals(nbPierre + 1, thanos.getNbPierresInfini());
	}

	@Test
	public void testAjoutPierreNonInfini() {
		int nbPierre = thanos.getNbPierresInfini();
		thanos.ajouterPierreInfini("Pizza");
		assertEquals(nbPierre, thanos.getNbPierresInfini());
	}
	
	@Test
	public void testPlanete() {
		Planete p = new Planete("toto");
		thanos.ajouterPlaneteAcombattre(p);
		assertEquals(p, thanos.getPlaneteAcombattre());
		Planete p2 = new Planete("titi");
		thanos.ajouterPlaneteAcombattre(p2);
		assertEquals(p2, thanos.getPlaneteAcombattre());
		thanos.supprimerPlaneteAcombattre();
		assertEquals(null, thanos.getPlaneteAcombattre());
		
	}
	@Test
	public void testEqual() {
		SuperMechant m = null;
		assertEquals(false, thanos.equals(m));
		SuperMechant twin = new SuperMechant(thanos.getNomMechant(),thanos.getNbPierresInfini());
		assertEquals(true, thanos.equals(twin));
		SuperMechant notwin = new SuperMechant(thanos.getNomMechant(),thanos.getNbPierresInfini()+1);
		assertEquals(false, thanos.equals(notwin));
	}
	
	/**
	 * Supprime les engagements
	 *
	 * Méthode appelée après chaque appel de méthode de test.
	 */
	@After
	public void tearDown() // throws java.lang.Exception
	{
		// Libérez ici les ressources engagées par setUp()
	}

}
