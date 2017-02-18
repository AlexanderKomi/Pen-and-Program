package test.inventory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.ressources.items.Weapon;
import model.ressources.items.Wearable;

public class AddEquipmentTest {
	BuildMyTestingArea testingArea;

	@Before
	public void setUp() throws Exception {
		testingArea = new BuildMyTestingArea();
	}

	/**
	 * Testcase to see if an item is correctly equiped that already was in the Inventory.
	 */
	@Test
	public void equipItemOutOfInventoryTest() {
		Wearable testWearable = null;
		Weapon testWeapon = null;

		testingArea.getInventar().equipItem(testingArea.getInventar().getItemByName(null));
		if (testingArea.getInventar().getItemByName(null) instanceof Weapon)
			testWeapon = (Weapon) testingArea.getInventar().getItemByName(null);
		if (testingArea.getInventar().getItemByName(null) instanceof Wearable)
			testWearable = (Wearable) testingArea.getInventar().getItemByName(null);

		assertTrue(testingArea.getInventar().getEquipment().contains(testWeapon));
		assertTrue(testingArea.getInventar().getEquipment().contains(testWearable));
	}

	
	/**
	 * Testcase to see if an item is correctly equiped that has not been in the Inventory.
	 */
	@Test
	public void equipNewItemTest() {
		String weaponName = "Excalibur";
		Weapon testWeapon = new Weapon(weaponName, null, null, null);
		String shieldName = "Bulwark of Azzinoth";
		Wearable testWearable = new Wearable(shieldName, null, null, 0, null);
		testingArea.getInventar().equipItem(testWeapon);
		testingArea.getInventar().equipItem(testWearable);

		assertEquals(testWeapon, testingArea.getInventar().getItemByName(weaponName));
		assertEquals(testWeapon, testingArea.getInventar().getItemByName(shieldName));

		assertTrue(testingArea.getInventar().getEquipment().contains(testWeapon));
		assertTrue(testingArea.getInventar().getEquipment().contains(testWearable));
	}

}
