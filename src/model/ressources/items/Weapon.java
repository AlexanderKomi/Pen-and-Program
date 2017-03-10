package model.ressources.items;

import model.Damage;
import model.Money;

/**
 * 
 * 
 * 
 * @author Micha
 */
public class Weapon extends Item{
	private Damage damage;

	public Weapon(String name, Money value, String description, Damage damage) {
		// TODO Auto-generated constructor stub
	}

	public Damage getDamage() {
		return damage;
	}

	public void setDamage(Damage damage) {
		this.damage = damage;
	}
}
