package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import model.ressources.player.Attribute;
import model.ressources.player.Skill;
import model.ressources.player.Unit;

/**
 * Still WIP. <br>
 * <br>
 * This class reads all the data provided for this program. <br>
 * The read data will be put in variables, which can be used for further
 * use.<br>
 * When the data is purified and ready for use, mostly it can be accessed as
 * Linked Lists.
 * 
 * @author Alexander Komischke
 */
public class ReadData {

	private String game;
	private String _csv_split_by = ",";
	private BufferedReader br;

	List<String> locations;
	List<String> attributes_as_data;
	List<String> skills_as_data;
	List<List<String>> units_as_data;

	List<Attribute> attributes;
	List<Skill> skills;
	List<Unit> units;

	/**
	 * Still WIP. <br>
	 * <br>
	 * Reads the Data from the Files<br>
	 * 
	 * @param String
	 *            Gets as parameter the game used. The Game must be verified.
	 */
	public ReadData(String game) {

		this.setGame(game);

		locations = new ArrayList<String>();

		attributes_as_data = new ArrayList<>();
		skills_as_data = new ArrayList<>();
		units_as_data = new ArrayList<>();

		attributes = new ArrayList<Attribute>();
		skills = new ArrayList<Skill>();
		units = new ArrayList<Unit>();

		locations = getFileLocations(new java.io.File("data/" + getGame() + "/").getAbsolutePath());
		readData(locations);

	}

	/**
	 * Puts all the filtered data in variables. <br>
	 * The variables can be used for further use.
	 */

	/**
	 * Reads the Data from the paths in locations and writes the result in the
	 * correct Lists.
	 * 
	 * @param List<String>
	 *            contains the full path to the file.
	 */
	public void readData(List<String> locations) {

		String line = "";
		if (locations == null) {
			return;
		}

		for (String s : locations) {
			List<String> content = new ArrayList<String>();
			try {
				br = new BufferedReader(new FileReader(s));

				while ((line = br.readLine()) != null) {
					String[] inputFromFile = line.split(_csv_split_by);
					for (String inFile : inputFromFile) {

						// TO DO DATA FROM FILES IN VARIABLES -> INSERT CODE
						// HERE

						if (s.endsWith("Skills.csv")) {
							// works
							skills_as_data.add(inFile.trim());
						} else if (s.endsWith("Attribute.csv")) {
							// works
							attributes_as_data.add(inFile.trim());
						} else if (s.contains("Pen and Paper\\data\\" + this.game + "\\player\\")) {
							// TODO: in Progress
							content.add(inFile.trim());

						}

					}
					if (!content.isEmpty()) {
						if (!units_as_data.contains(content)) {
							units_as_data.add(content);
						}
					}
				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Searches for available Files in the data folder in the correct game
	 * 
	 * @return Returns a List<String> with the paths to the files, that are
	 *         available.
	 */
	public List<String> getFileLocations(String path) {

		File directory = new File(path);
		File[] list = directory.listFiles();

		if (list == null) {
			return null;
		}

		for (File f : list) {
			if (f.isDirectory()) {
				path = f.getAbsolutePath();
				getFileLocations(path);
			} else {
				locations.add(f.getAbsolutePath());
			}
		}

		return locations;
	}

	/**
	 * Prints all Locations found in Files
	 */
	public void printLocationsFromFiles() {

		if (locations == null) {
			System.out.println("Locations : No data found.");
			return;
		}

		System.out.println("\nLocations : ");

		for (String s : locations) {
			System.out.println(s);
		}
	}

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

	public void printUnits() {
		System.out.println("Units : \n");
		;
		for (Unit u : units) {
			System.out.println(u.toString());
		}
		System.out.println("No more Units");
	}

	/**
	 * Prints everything that is used from Files.
	 */
	public void printAll() {
		printLocationsFromFiles();

		printAttsFromData();
		printSkillsFromData();
		printUnitsFromData();

		printAtts();
		printSkills();
		printUnits();
	}

	// GETTER AND SETTER

	public String get_csv_split_by() {
		return _csv_split_by;
	}

	public void set_csv_split_by(String _csv_split_by) {
		this._csv_split_by = _csv_split_by;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

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
