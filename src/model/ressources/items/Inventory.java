/**
 * 
 */
package model.ressources.items;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Micha
 *
 */
public class Inventory {
	private Map<Integer, Item> itemList = new HashMap<Integer, Item>();
	private Equipment equipment = new Equipment();

	public Inventory() {

	}

	public Map<Integer, Item> addItem(Item item) {
		return itemList;
	}

	public Map<Integer, Item> addItem(int quantity, Item item) {
		return itemList;
	}

	public Map<Integer, Item> removeItem(Item item) {
		return itemList;
	}

	public Map<Integer, Item> removeItem(int quantity, Item item) {
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

	public boolean isEquipped(String name) {
		return false;
	}

	public boolean isEquipped(Item item) {
		return false;
	}

	public Equipment getEquipment() {
		return equipment;
	}

}
