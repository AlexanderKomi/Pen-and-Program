package io.create_usable_data;

import java.util.ArrayList;
import java.util.List;


import model.ressources.player.Attribute;

public class Attributes_ToVar {


	private List<String> attributes_as_data;
	private List<Attribute> attributes;
	
	
	public Attributes_ToVar(){
		this.attributes = new ArrayList<Attribute>();
		this.attributes_as_data = new ArrayList<String>();
		attributes_FD_to_variables();
	}
	
	public Attributes_ToVar(List<String> attributes_as_data){
		this.attributes = new ArrayList<Attribute>();
		this.attributes_as_data =attributes_as_data;
		attributes_FD_to_variables();
	}
	
	//
	//METHODS
	//
	
	/**
	 * Puts all the data,which are Strings, from attributes_as_data and creates
	 * new Objects from these Strings and puts them in a new and usable Linked
	 * List. <br>
	 * FD stays for FROM DATA.
	 * 
	 * @return
	 */
	public List<Attribute> attributes_FD_to_variables() {
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

		if(this.attributes.isEmpty()){
			throw new RuntimeException("\n\nERROR: ATTRIBUTES IS EMTPY, after reading data.\n\n");
		}
		
		return this.attributes;
	}
	
	
	/**
	 * Prints all Attributes found in Files
	 */
	public void printAttsFromData() {

		if (this.attributes_as_data == null) {
			System.out.println("atts from data: No data found.");
			return;
		}

		System.out.println("\nAttribute from data: ");

		for (String s : this.attributes_as_data) {
			System.out.println(s);
		}
	}
	
	public void printAtts() {

		if (this.attributes == null) {
			System.out.println("atts : No data found.");
			return;
		}

		System.out.println("\nAttribute : ");

		for (Attribute s : this.attributes) {
			System.out.println(s.toString());
		}
	}
	
	
	public List<Attribute> getAttributes() {
		return this.attributes;
	}
	
	public List<String> get_attributes_as_data() {
		return this.attributes_as_data;
	}
	
	
}
