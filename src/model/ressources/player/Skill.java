package model.ressources.player;

import java.util.ArrayList;
import java.util.List;

/**Still WIP.
 * 
 * Skill contains all the skills from the file 'Skills.csv'.
 * This class should be used to save all information needed for a single skill and its attributes.
 * 
 * A skill has a value, a name and a linked list with the attributes.
 * 
 * The variable 'name' represents the name of the skill.
 * The variable 'value' represents the value of the skill.
 * 'atts' is a linked list, which contains multiple attributes, which you can roll on to use the skill.
 * 
 * Example:	
 * name, value, atts
 * Klettern, 10, KK, KK, GK
 * 
 * IMPORTANT : Do not cut the code in this class. Everything is used right now.
 * @author Alexander Komischke
 * */
public class Skill {

	// GLOBAL VARIABLES

	private String				name;
	private List <Attribute>	atts;
	private int					value;

	// CONSTRUCTORS

	public Skill( String name ) {
		this.setName( name );
		this.setAttributes( new ArrayList<Attribute>() );
		this.setValue( 0 );
	}

	public Skill( String name, List <Attribute> atts ) {
		this.setName( name );
		this.setAttributes( atts );
		this.setValue( 0 );
	}

	public Skill( String name, List <Attribute> atts, int value ) {
		this.setName( name );
		this.setAttributes( atts );
		this.setValue( value );
	}

	/**This constructor is only usable, if you use a Skill with 3 Attributes
	 * */
	public Skill( String name, int value, Attribute a, Attribute b, Attribute c ) {
		this.setName( name );
		this.setValue( value );

		this.atts = new ArrayList <>();
		this.atts.add( a );
		this.atts.add( b );
		this.atts.add( c );
	}
	
	public Skill(Skill s){
		this.setName( s.getName() );
		this.setValue( s.value );
		this.setAttributes( s.getAttributes() );
	}
	
	public Skill(Skill s, int value){
		this.setName( s.getName() );
		this.setValue(value );
		this.setAttributes( s.getAttributes() );
	}

	// METHODEN

	public boolean equals( Skill s ) {
		if ( this.name.equals( s.name ) ) {
			if ( this.atts == s.atts ) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		String result = "Skillname : " + this.name + "\n";
		result += "Skillvalue : " + this.value + "\n";

		for (Attribute a : this.atts) {
			result += a.toString() + "\n";
		}

		return result;
	}

	// GETTER AND SETTER

	public List <Attribute> getAttributes() {
		return this.atts;
	}

	public void setAttributes( List <Attribute> atts ) {
		this.atts = atts;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue( int value ) {
		this.value = value;
	}

}
