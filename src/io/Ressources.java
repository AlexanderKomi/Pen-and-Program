package io;

import java.util.List;

import io.create_usable_data.Attributes_ToVar;
import io.create_usable_data.Units_ToVar;
import io.create_usable_data.Skills_ToVar;
import model.ressources.player.Attribute;
import model.ressources.player.Skill;
import model.ressources.player.Unit;

/**
 * When data was read or should be wrote; this class contains everything you can
 * use.<br>
 * Data from this class is provided by 'InputFromData.java'.<br>
 * 
 * @author Alexander Komischke
 */
public class Ressources {

	private boolean game_choosen;
	private List < Skill > skills;
	private List < Attribute > attributes;
	private List < Unit > units;
	private String game;

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

		List < String > skills_ad = readData.getSkills_AD();
		List < String > attributes_ad = readData.getAttributes_AD();
		List < List < String > > units_ad = readData.getUnits_AD();

		Attributes_ToVar atv = new Attributes_ToVar( attributes_ad );
		this.attributes = atv.getAttributes();

		Skills_ToVar stv = new Skills_ToVar( skills_ad, this.attributes );
		this.skills = stv.getSkills();

		Units_ToVar dataToVar = new Units_ToVar( units_ad, this.skills, this.attributes );
		this.units = dataToVar.getUnits();
		checkForErrors();
	}

	private void checkForErrors() {
		if ( skills.size() == 0 ) {
			System.out.println( "\n\nERROR : SKILLS IS 0 -> RESSOURCES\n\n" );
		}
		if ( attributes.size() == 0 ) {
			System.out.println( "\n\nERROR : ATTRIBUTES IS 0 -> RESSOURCES\n\n" );
		}
	}

	// Setter and Getter

	public boolean isData_choosen() {
		return game_choosen;
	}

	public List < Skill > getSkills() {
		return this.skills;
	}

	@ SuppressWarnings ( "unused" )
	private void updateAttributes() {
		ReadData readData = new ReadData( game );
		List < String > attributes_ad = readData.getAttributes_AD();
		Attributes_ToVar atv = new Attributes_ToVar( attributes_ad );
		this.attributes = atv.getAttributes();

	}

	@ SuppressWarnings ( "unused" )
	private void updateSkills() {
		ReadData readData = new ReadData( game );

		List < String > skills_ad = readData.getSkills_AD();
		Skills_ToVar stv = new Skills_ToVar( skills_ad, attributes );
		setSkills( stv.getSkills() );
	}

	public void setSkills( List < Skill > skills ) {
		this.skills = skills;
	}

	public List < Attribute > getAttributes() {
		return this.attributes;
	}

	public void setAttributes( List < Attribute > attributes ) {
		this.attributes = attributes;
	}

	public String getGame() {
		return this.game;
	}

	public void setGame( String game ) {
		this.game = game;
	}

	public List < Unit > getUnits() {
		return this.units;
	}

	public void setUnits( List < Unit > units ) {
		this.units = units;
	}

}
