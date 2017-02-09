package io.create_usable_data;

import java.util.ArrayList;
import java.util.List;

import model.ressources.Attribute;
import model.ressources.Skill;
import model.ressources.Unit;

/**
 * Still WIP.<br>
 * <br>
 * This class gets the raw data and magicly transforms it into variables.
 */
public class Data_To_Variables {

	// GLOBAL VARIABLES

	private List<String> attributes_as_data;
	private List<String> skills_as_data;
	private List<List<String>> units_as_data;

	private List<Attribute> attributes;
	private List<Skill> skills;
	private List<Unit> units;

	//
	// CONSTRUCTORS
	//

	/**
	 * This is the default Constructor. For further use, implement more
	 * parameters. Only a setter is not enough.
	 */
	public Data_To_Variables(List<String> attributes_as_data, List<String> skills_as_data,
			List<List<String>> units_as_data) {
		attributes = new ArrayList<Attribute>();
		skills = new ArrayList<Skill>();
		units = new ArrayList<Unit>();

		this.attributes_as_data = attributes_as_data;
		this.skills_as_data = skills_as_data;
		this.units_as_data = units_as_data;
		data_to_variables();
	}

	//
	// METHODS
	//

	/**
	 * Takes all the data provided and puts it into the right variables.
	 */
	private void data_to_variables() {
		this.attributes = attributes_FD_to_variables();
		this.skills = skills_FD_to_variables();
		this.units = units_FD_to_variables();
	}

	/**
	 * Puts all the data,which are Strings, from attributes_as_data and creates
	 * new Objects from these Strings and puts them in a new and usable Linked
	 * List. <br>
	 * FD stays for FROM DATA.
	 * 
	 * @return
	 */
	private List<Attribute> attributes_FD_to_variables() {
		List<String> alias = new ArrayList<>();

		for (String s : attributes_as_data) {
			if (s != null) {

				if (s.equals("$")) {
					this.attributes.add(new Attribute(alias.get(0), alias));
					alias = new ArrayList<String>();
				} else if (!s.equals("$") && !s.equals("")) {
					alias.add(s);
				}
			}
		}

		return this.attributes;
	}

	/**
	 * Puts all the data,which are Strings, from skills_as_data and creates new
	 * Objects from these Strings and puts them in a new and usable Linked
	 * List.<br>
	 * FD stays for FROM DATA.
	 */
	private List<Skill> skills_FD_to_variables() {
		// Skills

		List<Attribute> req_for_skill = new ArrayList<>();
		String skill = "";
		String prevSkill = "";
		for (String s : skills_as_data) {

			if (s != null) {

				if (prevSkill.equals("") || prevSkill.equals("$")) {
					skill = s;
				}

				if (s.equals("$")) {
					req_for_skill = searchForAlias(req_for_skill, this.attributes);
					this.skills.add(new Skill(skill, req_for_skill));
					req_for_skill = new ArrayList<Attribute>();
					prevSkill = s;
				} else if (!s.equals("$") && s != null) {

					if (!skill.equals(s)) {
						req_for_skill.add(new Attribute(s));
					}

					prevSkill = s;
				}
			}
		}

		return this.skills;
	}

	/**
	 * Searches all skills in a and if there are any alias in b, these alias
	 * will be set in a.
	 * 
	 * @param List<Attribute>
	 *            req_for_skill all Attributes in a
	 * @param List<Attribute>
	 *            attributes all Attributes in b
	 * @return List<Attribute> returns a
	 */
	private List<Attribute> searchForAlias(List<Attribute> req_for_skill, List<Attribute> attributes) {

		for (Attribute a : req_for_skill) {
			for (Attribute b : attributes) {
				if (a.getName().equals(b.getName())) {
					a.setAlias(b.getAlias());
				} else {
					for (String s : b.getAlias()) {
						if (a.getName().equals(s)) {
							a.setAlias(b.getAlias());
						}
					}
				}
			}
		}

		return req_for_skill;
	}

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
						value = Integer.parseInt(ls.get(ls.indexOf(s) + 1));
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
	 * Prints all Attributes found in Files
	 */
	public void printAttsFromData() {

		if (attributes_as_data == null) {
			System.out.println("atts from data: No data found.");
			return;
		}

		System.out.println("\nAttribute from data: ");

		for (String s : attributes_as_data) {
			System.out.println(s);
		}
	}

	public void printAtts() {

		if (attributes == null) {
			System.out.println("atts : No data found.");
			return;
		}

		System.out.println("\nAttribute : ");

		for (Attribute s : attributes) {
			System.out.println(s.toString());
		}
	}

	/**
	 * Prints all Skills found in Files
	 */
	public void printSkillsFromData() {

		if (skills_as_data == null) {
			System.out.println("skills from data : No data found.");
			return;
		}

		System.out.println("\nSkills from data: ");

		for (String s : skills_as_data) {
			System.out.println(s);
		}
	}

	/**
	 * Prints all Skills, usable for the game.
	 */
	public void printSkills() {

		if (skills == null) {
			System.out.println("skills : No data found.");
			return;
		}

		System.out.println("\nSkills : ");

		for (Skill s : skills) {
			System.out.println(s.toString());
		}

		System.out.println("No more Skills");
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

		printAttsFromData();
		printSkillsFromData();
		printUnitsFromData();

		printAtts();
		printSkills();
		printUnits();
	}

	//
	// GETTER AND SETTER
	//

	public List<Skill> getSkills() {
		return this.skills;
	}

	public List<Attribute> getAttributes() {
		return this.attributes;
	}

	public List<Unit> getUnits() {
		return this.units;
	}

	public List<String> get_attributes_as_data() {
		return this.attributes_as_data;
	}

	public List<String> get_skills_as_data() {
		return this.skills_as_data;
	}

	public List<List<String>> get_units_as_data() {
		return this.units_as_data;
	}

}
