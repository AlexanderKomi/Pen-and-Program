package model.ressources;

import model.Money;

/**
 * Stil WIP<br>
 * <br>
 * Items is the model for all the items ingame.
 */
public abstract class Item {

	private String name;
	private Money value;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Money getValue() {
		return value;
	}

	public void setValue(Money value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
