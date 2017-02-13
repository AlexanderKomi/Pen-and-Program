package model.ressources;

import model.Damage;

/**
 * 
 * 
 * 
 * @author Micha
 */
public class Weapon extends Item {
	private Damage damage;

	public Damage getDamage() {
		return damage;
	}

	public void setDamage(Damage damage) {
		this.damage = damage;
	}

}
