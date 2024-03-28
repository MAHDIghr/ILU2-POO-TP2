package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	Village village;
	Chef chef;
	@BeforeEach
	private void initialiserSitualion() {
		System.out.println("Initialisation..");
		village = new Village("village des gaulois", 10, 5);
		chef = new Chef("chef", 20, village);
		village.setChef(chef);
	}

	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage,"le constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(chef.getNom(), controlAfficherVillage.donnerNomsVillageois()[0]);
		Druide druide = new Druide("druide", 10, 5, 15);
		village.ajouterHabitant(druide);
		assertEquals("le druide "+ druide.getNom(), controlAfficherVillage.donnerNomsVillageois()[1]);
		Gaulois gaulois = new Gaulois("gaulois", 10);
		village.ajouterHabitant(gaulois);
		assertEquals(gaulois.getNom(), controlAfficherVillage.donnerNomsVillageois()[2]);
	}

	@Test
	void testDonnerNomVillage() {
		fail("Not yet implemented");
	}

	@Test
	void testDonnerNbEtals() {
		fail("Not yet implemented");
	}

}
