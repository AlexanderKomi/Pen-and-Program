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
	 * This is the default Constructor. For further use, implement more
	 * parameters. Only a setter is not enough.
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

		for (Skill s : skills) {
			if (s.getName().equals(toSearch)) {
				return new Skill(s, searchForValue(s.getName(), playerName));
			}
		}

		return new Skill(toSearch);
	}

	private Attribute searchForAttribute(String toSearch, String playerName) {
		for (Attribute a : attributes) {
			if (a.getName().equals(toSearch)) {
				return new Attribute(a, searchForValue(a.getName(), playerName));
			}
		}
		return new Attribute(toSearch);
	}

	/**
	 * Searches in raw data from units for the value of a Skill or Attribute.
	 * 
	 * @param Name
	 *            of the Skill or attribute in the table
	 */
	private int searchForValue(String name, String playerName) {

		boolean playerNameFound = false;
		int value = 0;

		for (List<String> ls : units_as_data) {
			for (String s : ls) {
				if (s.equals(playerName)) {
					playerNameFound = true;
				}
				if (s.equals(name) && playerNameFound) {

					// TODO : Implement for Attributes and check in Console
					// Output if Values match!
					try {
						value = Integer.parseInt(ls.get(ls.indexOf(s) + 1)); //TODO : Better solution for less magical numbers.
					} catch (NumberFormatException e) {
						e.printStackTrace();

					}
					return value;
				}
			}
		}
		return value;
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
								System.out.println("PlayerStatus registered : " + s);
								playerStatus = Boolean.getBoolean(s);
							} catch (Exception e) {
								e.printStackTrace();
								System.out.println("ERROR: Can not create status of player from data.");
							}
						} else if (prevElement.equals("Name") || prevElement.equals("name")) {
							try {
								System.out.println("Playname found : " + s);
								playerName = s;
							} catch (Exception e) {
								e.printStackTrace();
								System.out.println("ERROR : Can not get the Playername");
							}
						} else if (prevElement.equals("Skill") || prevElement.equals("skill")) {
							System.out.println("Skill found : " + s);
							playerSkills.add(searchForSkill(s, playerName));
						} else if (prevElement.equals("Attribute") || prevElement.equals("attribute")) {
							System.out.println("attribute found : " + s);
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
