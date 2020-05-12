package main;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

/**
 * Classe-test AvengersTest.
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
public class AvengersTest {
	private SuperMechant thanos;
	private SuperMechant ebonyMaw;
	private Avenger ironMan;
	private ArrayList<SuperMechant> listMechantsAbattre;

	// Définissez ici les variables d'instance nécessaires à vos engagements;
	// Vous pouvez également les saisir automatiquement du présentoir
	// à l'aide du menu contextuel "Présentoir --> Engagements".
	// Notez cependant que ce dernier ne peut saisir les objets primitifs
	// du présentoir (les objets sans constructeur, comme int, float, etc.).

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
		ebonyMaw = new SuperMechant("ebonyMaw");
		thanos = new SuperMechant("thanos");
		thanos.setNbPierresInfini(4);

		ironMan = new Avenger("ironMan");
		ironMan.setNbPierresInfini(1);
		ironMan.ajouterUnSuperMechant(ebonyMaw);
		ironMan.ajouterUnSuperMechant(thanos);
	}

	/**
	 * Supprime les engagements
	 *
	 * Méthode appelée après chaque appel de méthode de test.
	 */

	@Test
	public void testNbPierresInfini() {
		assertEquals(1, ironMan.getNbPierresInfini());
	}

	@Test
	public void testSauverMonde() {
		assertEquals(true, ironMan.sauverLeMonde());
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
		SuperMechant mechant_battable = new SuperMechant("mechant_battable");
		mechant_battable.setNbPierresInfini(3);
		ironMan.ajouterUnSuperMechant(mechant_battable);
		Assert.assertEquals(true, ironMan.sauverLeMonde());
	}

	@Test
	public void testAjouterMechantAcombattreImpossible() {
		SuperMechant mechant_imbattable = new SuperMechant("mechant_imbattable");
		mechant_imbattable.setNbPierresInfini(6);
		ironMan.ajouterUnSuperMechant(mechant_imbattable);
		Assert.assertEquals(false, ironMan.sauverLeMonde());

	}

	@Test
	public void testAjoutMechantsAcombattre() {
		SuperMechant superMechant = new SuperMechant("superMechant");
		ironMan.ajouterUnSuperMechant(superMechant);
		Assert.assertEquals(true, ironMan.getListMechantsAcombattre().contains(superMechant));
		Assert.assertEquals(ironMan, superMechant.getAvengerAcombattre());

		Avenger blackPanthere = new Avenger();
		superMechant.setAvengerAcombattre(blackPanthere);
		Assert.assertEquals(false, ironMan.getListMechantsAcombattre().contains(superMechant));
		Assert.assertEquals(true, blackPanthere.getListMechantsAcombattre().contains(superMechant));
		Assert.assertEquals(blackPanthere, superMechant.getAvengerAcombattre());
	}

	@After
	public void tearDown() // throws java.lang.Exception
	{
		// Libérez ici les ressources engagées par setUp()
	}
}
