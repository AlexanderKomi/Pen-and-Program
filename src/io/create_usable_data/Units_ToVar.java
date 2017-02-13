package io.create_usable_data;

import java.util.ArrayList;
import java.util.List;

import model.ressources.player.Attribute;
import model.ressources.player.Skill;
import model.ressources.player.Unit;

/**
 * Still WIP.<br>
 * <br>
 * This class gets the raw data and magicly transforms it into variables.
 */
public class Units_ToVar {

	// GLOBAL VARIABLES

	private List<List<String>> units_as_data;
	private List<Unit> units;
	private List<Skill> skills;
	private List<Attribute> attributes;
	
	//
	// CONSTRUCTORS
	//
	
	
	/**
	 * This is the default Constructor.<br>
	 * Search Attributes before searching skills.
	 */
	public Units_ToVar(List<List<String>> units_as_data, List<Skill> skills, List<Attribute>attributes) {
		
		units = new ArrayList<Unit>();
		this.units_as_data = units_as_data;
		
		setAttributes(attributes);
		setSkills(skills);
		
		
		this.units = units_FD_to_variables();
	}

	//
	// METHODS
	//


	/**
	 * Use this with a String to find a Skill with the same name.
	 */
	private Skill searchForSkill(String toSearch, String playerName) {

		System.out.println("Searching Skill : " + toSearch +" in Player " + playerName);
		for (Skill s : skills) {
			if (s.getName().equals(toSearch)) {
				System.out.println("Skill found in Player : " + s.getName() + " , " + ""+ s.getValue());
				return new Skill(s);
			}
		}

		return new Skill(toSearch);
	}

	private Attribute searchForAttribute(String toSearch, String playerName) {
		for (Attribute a : attributes) {
			if (a.getName().equals(toSearch)) {
				System.out.println("Attribute found : " + a.getName() + " , " + a.getValue());
				return new Attribute(a);
			}
		}
		return new Attribute(toSearch);
	}


	/**
	 * Puts all the data,which are Strings, from units_as_data and creates new
	 * Objects from these Strings and puts them in a new and usable Linked
	 * List.<br>
	 * FD stays for FROM DATA.
	 * 
	 * @return
	 */
	private List<Unit> units_FD_to_variables() {

		// These Variables contain the data for a unit
		List<Skill> playerSkills = new ArrayList<>();
		List<Attribute> playerAtts = new ArrayList<>();
		String playerName = "";
		boolean playerStatus = false;

		// Logic
		String prevElement = "";

		for (List<String> ls : units_as_data) {
			if (!ls.isEmpty()) {

				for (String s : ls) {

					if (!s.equals("$")) {

						if (prevElement.equals("Player") || prevElement.equals("player")) {
							try {
								playerStatus = Boolean.getBoolean(s);
							} catch (Exception e) {
								e.printStackTrace();
								System.out.println("ERROR: Can not create status of player from data.");
							}
						} else if (prevElement.equals("Name") || prevElement.equals("name")) {
							try {
								playerName = s;
							} catch (Exception e) {
								e.printStackTrace();
								System.out.println("ERROR : Can not get the Playername");
							}
						} else if (prevElement.equals("Skill")) {
							playerSkills.add(searchForSkill(s, playerName));
						} else if (prevElement.equals("Attribute")) {
							playerAtts.add(searchForAttribute(s, playerName));
						}
					}

					prevElement = s;
				}
				units.add(new Unit(playerName, playerSkills, playerAtts, playerStatus));
			}

		}

		return this.units;

	}

	//
	// PRINT STUFF
	//

	public void printUnitsFromData() {

		if (units_as_data == null) {
			System.out.println("units from data: No data found.");
			return;
		}

		System.out.println("\nUnits from data: ");

		for (List<String> s : units_as_data) {
			System.out.println(s);
		}
	}


	/**
	 * Prints all Units, usable for the game.
	 */
	public void printUnits() {
		System.out.println("Units : \n");
		;
		for (Unit u : units) {
			System.out.println(u.toString());
		}
		System.out.println("No more Units");
	}

	/**
	 * Prints everything that can be used.
	 */
	public void printAll() {
		printUnitsFromData();
		printUnits();
	}

	//
	// GETTER AND SETTER
	//

	public List<Unit> getUnits() {
		return this.units;
	}


	public List<List<String>> get_units_as_data() {
		return this.units_as_data;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

}
