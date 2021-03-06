package marvelTests;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import marvel.Avenger;
import marvel.SuperMechant;
import sauvetage.Planete;

public class AvengersTest {
	private SuperMechant thanos;
	private SuperMechant ebonyMaw;
	private Avenger ironMan;
	private Planete terre;

	/**
	 * Constructeur de la classe-test AvengersTest
	 */
	public AvengersTest() {
	}

	/**
	 * Met en place les engagements.
	 *
	 * Méthode appelée avant chaque appel de méthode de test.
	 */
	@Before
	public void setUp() // throws java.lang.Exception
	{
		// listMechantsAbattre = new ArrayList<SuperMechant>();
		ebonyMaw = new SuperMechant("ebonyMaw", 0);
		thanos = new SuperMechant("thanos", 4);
		ironMan = new Avenger("ironMan");
		ironMan.setNbPierresInfini(1);
		ironMan.ajouterUnSuperMechant(ebonyMaw);
		ironMan.ajouterUnSuperMechant(thanos);
		terre = new Planete("Terre");
	}

	@Test
	public void testNbPierresInfini() {
		assertEquals(1, ironMan.getNbPierresInfini());
	}

	@Test
	public void testSauverMonde() {
		Planete p = new Planete("Terre");
		p.ajouterSuperMechant(thanos);
		assertEquals(true, ironMan.sauverLeMonde(p));
	}

	@Test
	public void testNomAvenger() {
		ironMan.setNomAvenger("Pierre");
		assertEquals("Pierre", ironMan.getNomAvenger());
		ironMan.setNomAvenger("ironMan");
		assertEquals("ironMan", ironMan.getNomAvenger());
	}

	@Test
	public void testListMechantsAcombattre() {
		// ArrayList<SuperMechant> listeTest = new
		// ArrayList<SuperMechant>(Arrays.asList(ebonyMaw,thanos));
		ArrayList<SuperMechant> listeTest = new ArrayList<SuperMechant>();
		listeTest.add(ebonyMaw);
		listeTest.add(thanos);

		assertEquals(listeTest, ironMan.getListMechantsAcombattre());
		listeTest.remove(ebonyMaw);
		ironMan.supprimerUnSuperMechant(ebonyMaw);
		assertEquals(listeTest, ironMan.getListMechantsAcombattre());
	}

	@Test
	public void testEquals() {
		Avenger thor = new Avenger();
		thor.setNbPierresInfini(1);
		Assert.assertNotNull(ironMan);
		Assert.assertNotNull(thanos);
		Assert.assertEquals(ironMan, ironMan);
	}

	@Test
	public void testMechantsAcombattre() {
		Assert.assertEquals(ironMan, ebonyMaw.getAvengerAcombattre());
		Assert.assertEquals(ironMan, thanos.getAvengerAcombattre());
		Assert.assertEquals(true, ironMan.getListMechantsAcombattre().contains(ebonyMaw));
		Assert.assertEquals(true, ironMan.getListMechantsAcombattre().contains(thanos));

	}

	@Test
	public void testAjouterMechantAcombattre() {
		SuperMechant mechant_battable = new SuperMechant("mechant_battable", 3);
		mechant_battable.ajouterPlaneteAcombattre(terre);
		ironMan.ajouterUnSuperMechant(mechant_battable);
		Assert.assertEquals(true, ironMan.sauverLeMonde(mechant_battable.getPlaneteAcombattre()));
	}

	@Test
	public void testAjouterMechantAcombattreImpossible() {

		SuperMechant mechant_imbattable = new SuperMechant("mechant_imbattable", 6);
		mechant_imbattable.ajouterPlaneteAcombattre(terre);
		ironMan.ajouterUnSuperMechant(mechant_imbattable);
		Assert.assertEquals(false, ironMan.sauverLeMonde(mechant_imbattable.getPlaneteAcombattre()));
		SuperMechant mechante_non_terre = new SuperMechant("mechant_imbattable", 0);
		mechante_non_terre.ajouterPlaneteAcombattre(new Planete("Xandar"));
		ironMan.ajouterUnSuperMechant(mechante_non_terre);
		Assert.assertEquals(false, ironMan.sauverLeMonde(mechante_non_terre.getPlaneteAcombattre()));
	}

	@Test
	public void testRemplacerMechantsAcombattre() {
		SuperMechant superMechant = new SuperMechant("superMechant", 0);
		ironMan.ajouterUnSuperMechant(superMechant);
		Assert.assertEquals(true, ironMan.getListMechantsAcombattre().contains(superMechant));
		Assert.assertEquals(ironMan, superMechant.getAvengerAcombattre());

		Avenger blackPanthere = new Avenger();
		superMechant.setAvengerAcombattre(blackPanthere);
		Assert.assertEquals(false, ironMan.getListMechantsAcombattre().contains(superMechant));
		Assert.assertEquals(true, blackPanthere.getListMechantsAcombattre().contains(superMechant));
		Assert.assertEquals(blackPanthere, superMechant.getAvengerAcombattre());

	}

	@Test
	public void testAjoutPierre() {
		int n = ironMan.getNbPierresInfini();
		ironMan.ajouterPierreInfini("Âme");
		assertTrue(n + 1 == ironMan.getNbPierresInfini());
		ironMan.setNbPierresInfini(5);
		boolean ajout = ironMan.ajouterPierreInfini("Espace");
		assertEquals(true, ajout);
		Avenger a = null;
		assertEquals(false, ironMan.equals(a));

	}

	/**
	 * Supprime les engagements
	 *
	 * Méthode appelée après chaque appel de méthode de test.
	 */
	@After
	public void tearDown() {

	}
}
