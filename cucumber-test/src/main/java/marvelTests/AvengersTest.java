package marvelTests;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import marvel.Avenger;
import marvel.SuperMechant;

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
		ebonyMaw = new SuperMechant("ebonyMaw",0,"Terre");
		thanos = new SuperMechant("thanos",4,"Terre");

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
		Assert.assertEquals(ironMan, ebonyMaw.getSuperHeroAcombattre());
		Assert.assertEquals(ironMan, thanos.getSuperHeroAcombattre());
		Assert.assertEquals(true, ironMan.getListMechantsAcombattre().contains(ebonyMaw));
		Assert.assertEquals(true, ironMan.getListMechantsAcombattre().contains(thanos));

	}

	@Test
	public void testAjouterMechantAcombattre() {
		SuperMechant mechant_battable = new SuperMechant("mechant_battable",3,"Terre");
		ironMan.ajouterUnSuperMechant(mechant_battable);
		Assert.assertEquals(true, ironMan.sauverLeMonde());
	}

	@Test
	public void testAjouterMechantAcombattreImpossible() {
		SuperMechant mechant_imbattable = new SuperMechant("mechant_imbattable",6,"Terre");
		ironMan.ajouterUnSuperMechant(mechant_imbattable);
		Assert.assertEquals(false, ironMan.sauverLeMonde());
		SuperMechant mechante_non_terre=new SuperMechant("mechant_imbattable",0,"Ego");
		ironMan.ajouterUnSuperMechant(mechante_non_terre);
		Assert.assertEquals(false, ironMan.sauverLeMonde());
	}

	@Test
	public void testRemplacerMechantsAcombattre() {
		SuperMechant superMechant = new SuperMechant("superMechant",0,"Terre");
		ironMan.ajouterUnSuperMechant(superMechant);
		Assert.assertEquals(true, ironMan.getListMechantsAcombattre().contains(superMechant));
		Assert.assertEquals(ironMan, superMechant.getSuperHeroAcombattre());

		Avenger blackPanthere = new Avenger();
		superMechant.setAvengerAcombattre(blackPanthere);
		Assert.assertEquals(false, ironMan.getListMechantsAcombattre().contains(superMechant));
		Assert.assertEquals(true, blackPanthere.getListMechantsAcombattre().contains(superMechant));
		Assert.assertEquals(blackPanthere, superMechant.getSuperHeroAcombattre());

	}

	@After
	public void tearDown() // throws java.lang.Exception
	{
		// Libérez ici les ressources engagées par setUp()
	}
}
