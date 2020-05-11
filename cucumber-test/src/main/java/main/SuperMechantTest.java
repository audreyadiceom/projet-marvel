package main;

import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test SuperMechantTest.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 *
 *          Les classes-test sont documentées ici :
 *          http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 *          et sont basées sur le document Š 2002 Robert A. Ballance intitulé
 *          "JUnit: Unit Testing Framework".
 *
 *          Les objets Test (et TestSuite) sont associés aux classes à tester
 *          par la simple relation yyyTest (e.g. qu'un Test de la classe
 *          Name.java se nommera NameTest.java); les deux se retrouvent dans le
 *          męme paquetage. Les "engagements" (anglais : "fixture") forment un
 *          ensemble de conditions qui sont vraies pour chaque méthode Test à
 *          exécuter. Il peut y avoir plus d'une méthode Test dans une classe
 *          Test; leur ensemble forme un objet TestSuite. BlueJ découvrira
 *          automatiquement (par introspection) les méthodes Test de votre
 *          classe Test et générera la TestSuite conséquente. Chaque appel d'une
 *          méthode Test sera précédé d'un appel de setUp(), qui réalise les
 *          engagements, et suivi d'un appel à tearDown(), qui les détruit.
 */
public class SuperMechantTest {

	private SuperMechant thanos;
	private SuperMechant loki;
	private SuperMechant joker;
	private Avenger ironMan;
	private Avenger thor;
	private ArrayList<Avenger> listAvengersAcombattre;

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

		thanos = new SuperMechant("thanos");
		thanos.setNbPierresInfini(3);
		ironMan = new Avenger("ironMan");
		thanos.setAvengerAcombattre(ironMan);
		loki = new SuperMechant("loki");
		joker = new SuperMechant(1);

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
		assertEquals(false, superMec1.situationFinDuMonde());
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
		SuperMechant thanos2 = new SuperMechant();
		thanos2.setNbPierresInfini(3);
		Assert.assertEquals(thanos, thanos2);
		Assert.assertNotNull(thanos);
		Assert.assertNotNull(ironMan);
		Assert.assertEquals(thanos, thanos);
		Assert.assertEquals(thanos.getNbPierresInfini(), 3);
		thanos2.setNbPierresInfini(6);
		Assert.assertEquals(6, thanos2.getNbPierresInfini());
		Assert.assertEquals(true, thanos2.situationFinDuMonde());

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
}
