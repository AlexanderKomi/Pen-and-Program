package io.create_usable_data;

import java.util.ArrayList;
import java.util.List;

import model.ressources.player.Attribute;
import model.ressources.player.Skill;

public class Skills_To_Variables {

	private List<String> skills_as_data;
	private List<Skill> skills;

	//
	// CONSTRUCTORS
	//

	public Skills_To_Variables(List<String> ls, List<Attribute> attributes) {
		this.setSkills_as_data(ls);
		setSkills(new ArrayList<Skill>());
	}

	//
	// METHODS
	//

	public List<Skill> getSkills(List<Attribute> attributes) {
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
					req_for_skill = searchForAlias(req_for_skill, attributes);
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

	//
	// GETTER AND SETTER
	//

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public List<String> getSkills_as_data() {
		return skills_as_data;
	}

	public void setSkills_as_data(List<String> skills_as_data) {
		this.skills_as_data = skills_as_data;
	}

}
