package model.ressources;

import java.util.ArrayList;
import java.util.List;

/**Still WIP.
 * 
 * Every instance of Attribute contains an attribute from the file 'Attribute.csv'.
 * This class should be used to save all information needed for a single attribute.
 * IMPORTANT : Do not cut the code in this class. Everything is used right now.
 * 
 * An Attribute has a value, a name and a linked list with the aliases.
 * 
 * The variable 'name' represents the name of the attribute.
 * The variable 'value' represents the value of the attribute.
 * 'alias' is a linked list, which contains multiple Strings. An alias should be searched to check if an Attribute in a "CSV"-File is not correctly spelled.
 * 
 * Example:	
 * name, value, alias
 * 
 * 
 * 
 * @author Alexander Komischke
 * */
public class Attribute {

	//GLOBAL VARIABLES
	
	/**This value stores all the names, that equal to, or should represent, the name of the Attribute
	 * */
	private List<String> alias;
	private int value;
	private String name;
	
	
	
	//CONSTRUCTORS
	
	/**This Constructor should not be used for gameplay, because no values are set.
	 * */
	public Attribute(String name){
		this.setName(name);
		this.setValue(0);
		this.alias = new ArrayList<>();
	}
	
	/**This Constructor should not be used for gameplay.
	 * */
	public Attribute(String name, List<String> alias){
		this.setName(name);
		this.setValue(value);
		this.alias = alias;
	}
	
	public Attribute(String name, int value){
		this.setName(name);
		this.setValue(value);
		this.alias = new ArrayList<>();
	}
	
	public Attribute(String name, int value, List<String> alias){
		this.setName(name);
		this.setValue(value);
		this.setAlias(alias);
	}
	
	/**Use this constructor to create a copy of an existing attribute.
	 * */
	public Attribute( Attribute a ) {
		this.setName( a.getName() );
		this.setValue( a.getValue() );
		this.setAlias( a.getAlias() );
	}
	
	/**Use this constructor to create a copy of an existing attribute and change its value.
	 * */
	public Attribute( Attribute a , int value) {
		this.setName( a.getName() );
		this.setValue( value );
		this.setAlias( a.getAlias() );
	}
	
	//Methodes
	
	

	public boolean equals(Attribute a){
		
		if(this.name.equals(a.name)){
			return true;
		}
		for(String s1 : this.alias){
			for(String s2 : a.alias){
				if(s1.equals(s2)){
					return true;
				}
			}
		}
		
		return false;
	}
	
	public String toString(){
		
		String result= "\nName : "+this.name + "\nAliase: ";
		
		for(String s : this.alias){
			result +=  s +", " ;
		}
		result += "\nvalue : "+this.value+ "\n";
		
		return result;
	}
	
	public boolean contains(Object o){
		
		if(o instanceof String){
			if(this.name.equals(o)){
				return true;
			}
		
			for(String s : this.alias){
				if(s.equals(o)){
					return true;
				}
			}
		}
		else if(o instanceof Attribute){
			throw new RuntimeException("An Attribute can not contain another Attribute!");
		}
		
		
		return false;
	}
	
	
	//GETTER AND SETTER
	
	public int getValue(){
		return this.value;
	}
	
	public void setValue(int newValue){
		this.value = newValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAlias() {
		return alias;
	}

	public void setAlias(List<String> alias) {
		this.alias = alias;
	}
}
