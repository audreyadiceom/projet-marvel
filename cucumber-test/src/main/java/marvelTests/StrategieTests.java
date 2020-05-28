package marvelTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import marvel.Avenger;
import marvel.SuperMechant;
import sauvetage.Planete;
import sauvetage.SauverParAvenger;
import sauvetage.SauverParGardien;

public class StrategieTests {

	// variables utilisées dans les tests
	private SuperMechant thanos;
	private Planete terre;
	private Planete xandare;

	// Constructeur
	public StrategieTests() {
	}

	/**
	 * Met en place les engagements.
	 *
	 * Méthode appelée avant chaque appel de méthode de test.
	 */
	@Before
	public void setUp() {
		this.thanos = new SuperMechant("Thanos", 0);
	}

	@Test
	public void testPlaneteBonneStrategie() {
		this.terre = new Planete("Terre", new SauverParAvenger());
		this.terre.ajouterSuperMechant(this.thanos);
		assertEquals(true, terre.sauverMoi());
		this.xandare = new Planete("Xandar", new SauverParGardien());
		this.xandare.ajouterSuperMechant(this.thanos);
		assertEquals(true, this.xandare.sauverMoi());
	}

	@Test
	public void testPlaneteMauvaiseStrategie() {
		this.terre = new Planete("Terre", new SauverParGardien());
		this.terre.ajouterSuperMechant(this.thanos);
		assertEquals(true, terre.sauverMoi());
		this.xandare = new Planete("Xandar", new SauverParAvenger());
		this.xandare.ajouterSuperMechant(this.thanos);
		assertEquals(false, xandare.sauverMoi());
	}

	@Test
	public void testMechantPossede6Pierres() {
		this.terre = new Planete("Terre", new SauverParGardien());
		this.thanos.setNbPierresInfini(6);
		this.terre.ajouterSuperMechant(this.thanos);
		assertEquals(false, this.terre.sauverMoi());
		this.xandare = new Planete("Xandar", new SauverParAvenger());
		this.xandare.ajouterSuperMechant(this.thanos);
		assertEquals(false, this.xandare.sauverMoi());
	}

	@Test
	public void testGettterSetter() {
		SauverParAvenger sauvetageAvenger = new SauverParAvenger();
		this.terre = new Planete("Terre", sauvetageAvenger);
		this.terre.ajouterSuperMechant(this.thanos);
		assertEquals(true, this.terre.sauverMoi());
		assertEquals(this.thanos, this.terre.getMechant());
		assertEquals(this.thanos.getPlaneteAcombattre(), this.terre);
		assertTrue(sauvetageAvenger.getAvenger().getListMechantsAcombattre().contains(this.thanos) == true);
		assertEquals(this.thanos.getAvengerAcombattre(), sauvetageAvenger.getAvenger());

	}

	@Test
	public void testPlanete() {
		terre = new Planete("Terre");
		assertEquals("Terre", this.terre.getNomPlanete());
		terre.ajouterSuperMechant(thanos);
		SuperMechant gargamel = new SuperMechant("Gargamel", 0);
		terre.ajouterSuperMechant(gargamel);
		assertEquals(gargamel, this.terre.getMechant());
		Planete p = null;
		assertEquals(false, terre.equals(p));
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
