package model.ressources.player;

import java.util.List;

/**
 * A Unit contains the skills and his attributes and a boolean if he is a player
 * or an NPC.
 * 
 */
public class Unit {

	// GLOBAL VARIABLES

	private boolean player_status;
	private String race;
	private String name;
	private List<Skill> skills;
	private List<Attribute> atts;

	// CONSTRUCTORS

	public Unit(String name, List<Skill> skills, List<Attribute> atts, boolean player) {
		this.setName(name);
		this.setSkills(skills);
		this.setAttributes(atts);
		this.setPlayer(player);
	}

	// METHODES

	public String toString() {
		String result = "\nUnit : \n";

		result += "Unitname : " + this.name + "\n";
		result += "Playerstatus : " + this.player_status + "\n";
		result += "Unit : " + this.name + ", Attributes : \n";

		for (Attribute at : this.atts) {
			if (at.getValue() != 0)
				result += "\t" + at.toString() + "\n";
		}

		result += "Unit : " + this.name + ", Skills : \n";

		for (Skill sk : this.skills) {
			if (sk.getValue() != 0)
				result += sk.toString() + "\n";
		}

		return result;
	}

	// GETTER AND SETTER

	public boolean isPlayer() {
		return player_status;
	}

	public void setPlayer(boolean player) {
		this.player_status = player;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public List<Attribute> getAttributes() {
		return atts;
	}

	public void setAttributes(List<Attribute> atts) {
		this.atts = atts;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

}
