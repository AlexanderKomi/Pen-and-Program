package model.ressources.items;

/**
 * 
 * 
 * 
 * @author Micha
 */
public class Wearable extends Item {
	private int defensValue;
	private String effect;

	public Wearable() {

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
