package model.ressources.items;

import model.Money;

/**
 * 
 * 
 * 
 * @author Micha
 */
public class Consumable extends Item {
	private String effect;

	public Consumable(String name, Money value, String description, String effect) {
		this.effect = effect;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

}
