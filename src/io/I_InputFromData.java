package io;

import java.util.List;

import model.ressources.Attribute;
import model.ressources.Skill;

public interface I_InputFromData {

	
	public List<String> getFileLocations(String path);
	
	public void setData(List<Attribute> atts, List<Skill> skills);
	
	public List<Skill> getSkills();
	
	public List<Attribute> getAttributes();

	void readData(List<String> locations);
}
