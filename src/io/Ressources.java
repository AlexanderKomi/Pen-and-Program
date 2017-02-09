package io;

import java.util.List;

import io.create_usable_data.Data_To_Variables;
import model.ressources.Attribute;
import model.ressources.Skill;
import model.ressources.Unit;

/**
 * When data was read or should be wrote; this class contains everything you can
 * use.<br>
 * Data from this class is provided by 'InputFromData.java'.<br>
 * 
 * @author Alexander Komischke
 */
public class Ressources {

	private boolean				game_choosen;
	private List <Skill>		skills;
	private List <Attribute>	attributes;
	private List <Unit>			units;
	private String				game;

	// Constructors
	/**
	 * This Constructor should be used for
	 * 
	 * @param String
	 *            The parameter is the name of the game. <br>
	 *            Must have exactly the same name as the folder.
	 */
	public Ressources( String game ) {
		this.game_choosen = false;
		if ( !game_choosen ) {
			updateData( game );
			this.game_choosen = true;
		}
		else {
			throw new RuntimeException( "io.Ressources:\nRuntimeError: Game already choosen!" );
		}
	}

	private void updateData( String game ) {

		this.setGame( game );

		ReadData readData = new ReadData( game );
		
		List <String> skills_ad = readData.get_skills_as_data();
		List <String> attributes_ad = readData.get_attributes_as_data();
		List <List <String>> units_ad = readData.get_units_as_data();

		Data_To_Variables dataToVar = new Data_To_Variables( attributes_ad, skills_ad, units_ad );
		
		this.skills = dataToVar.getSkills();
		this.attributes = dataToVar.getAttributes();
		this.units = dataToVar.getUnits();
		
		dataToVar.printUnits();

	}

	// Setter and Getter

	public boolean isData_choosen() {
		return game_choosen;
	}

	public List <Skill> getSkills() {
		return this.skills;
	}

	public void setSkills( List <Skill> skills ) {
		this.skills = skills;
	}

	public List <Attribute> getAttributes() {
		return this.attributes;
	}

	public void setAttributes( List <Attribute> attributes ) {
		this.attributes = attributes;
	}

	public String getGame() {
		return this.game;
	}

	public void setGame( String game ) {
		this.game = game;
	}

	public List <Unit> getUnits() {
		return this.units;
	}

	public void setUnits( List <Unit> units ) {
		this.units = units;
	}

}
