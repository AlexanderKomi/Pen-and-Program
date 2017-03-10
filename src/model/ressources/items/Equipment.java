/**
 * 
 */
package model.ressources.items;

import java.util.ArrayList;

/**
 * @author Micha
 *
 */
public class Equipment {
	ArrayList<Item> equipment = new ArrayList<>();

	public void equip(Item item) {
		equipment.add(item);
	}

	public void unEquip(Item item) {
		if (this.contains(item)) {

		} else {

		}
	}

	public boolean contains(Item item) {

		return false;
	}
}
