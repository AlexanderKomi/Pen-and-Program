package test.inventory;

import model.ressources.items.Consumable;
import model.ressources.items.Inventory;
import model.ressources.items.Weapon;
import model.ressources.items.Wearable;

public class BuildMyTestingArea {
	private Inventory inventar = new Inventory();

	public BuildMyTestingArea() {
		addWeapons();
		addWearables();
		addConsumables();
	}

	public void addWeapons() {
		Weapon weapon1 = new Weapon("Excalibur", null, null, null);
		Weapon weapon2 = new Weapon("Flammenspeer", null, null, null);
		Weapon weapon3 = new Weapon("Tyrfing", null, null, null);
		Weapon weapon4 = new Weapon("Steinbeiﬂer", null, null, null);
		Weapon weapon5 = new Weapon("Beonsschneide", null, null, null);

		inventar.addItem(weapon1);
		inventar.addItem(weapon2);
		inventar.addItem(weapon3);
		inventar.addItem(weapon4);
		inventar.addItem(weapon5);
	}

	public void addWearables() {
		Wearable wearable1 = new Wearable(null, null, null, 0, null);
		Wearable wearable2 = new Wearable(null, null, null, 0, null);
		Wearable wearable3 = new Wearable(null, null, null, 0, null);
		Wearable wearable4 = new Wearable(null, null, null, 0, null);
		Wearable wearable5 = new Wearable(null, null, null, 0, null);

		inventar.addItem(wearable1);
		inventar.addItem(wearable2);
		inventar.addItem(wearable3);
		inventar.addItem(wearable4);
		inventar.addItem(wearable5);
	}

	public void addConsumables() {
		Consumable consumable1 = new Consumable(null, null, null, null);
		Consumable consumable2 = new Consumable(null, null, null, null);
		Consumable consumable3 = new Consumable(null, null, null, null);
		Consumable consumable4 = new Consumable(null, null, null, null);
		Consumable consumable5 = new Consumable(null, null, null, null);

		inventar.addItem(consumable1);
		inventar.addItem(consumable2);
		inventar.addItem(consumable3);
		inventar.addItem(consumable4);
		inventar.addItem(consumable5);
	}

	public Inventory getInventar() {
		return inventar;
	}

}
