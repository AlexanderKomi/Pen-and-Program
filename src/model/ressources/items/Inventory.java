/**
 * 
 */
package model.ressources.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Micha
 *
 */
public class Inventory {
	private Map<Integer, Item> itemList = new HashMap<Integer, Item>();
	private ArrayList<Equipment> equipment = new ArrayList<>();

	public Inventory() {

	}

	public Map<Integer, Item> addItem(Item item) {
		return itemList;
	}

	public Map<Integer, Item> removeItem() {
		return itemList;
	}

	public boolean contains(Item item) {
		return false;
	}

	public void equipItem(Item item) {

	}

	public void unequipItem() {

	}

	public Item getItemByName(String name) {

		return null;
	}

	public ArrayList<Equipment> getEquipment() {
		return equipment;
	}

}
