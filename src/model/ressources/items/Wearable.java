package model.ressources.items;

import model.Money;

/**
 * 
 * 
 * 
 * @author Micha
 */
public class Wearable extends Item implements Equipment {
	private int defensValue;
	private String effect;

	public Wearable(String name, Money value, String description, int defensvalue, String effect) {

	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public int getDefensValue() {
		return defensValue;
	}

	public void setDefensValue(int defensValue) {
		this.defensValue = defensValue;
	}

}
