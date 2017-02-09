package model;

import java.util.ArrayList;
import java.util.List;

public class Dice {

	private int _sides;
	private List<Integer> _roll_Results;
	
	public Dice(){
		this.setSides(6);
	}
	
	public Dice(int i){
		if(i > 1){
			this.setSides(i);
			this._roll_Results = new ArrayList<Integer>();
		}
		else{
			throw new RuntimeException("ERROR: Dice must have more than one side!");
		}
	}
	
	public int roll(){
		int result = (int) (this._sides * Math.random())+1;
		
		if(result > this._sides){
			throw new RuntimeException("Dice has greater Result than size!");
		}
		
		this._roll_Results.add(result);
		
		return result;
	}
	
	public String toString(){
		String history="";
		int number = 1;
		for(int roll : _roll_Results){
			history += number+".Roll :\t" + roll+ "\n";
			history += "  Sides :\t" + this._sides + "\n\n";
			number++;
		}
		return history;
	}
	
	public void print(){
		System.out.println(this.toString());
	}
	
	public void setSides(int i){
		this._sides = i;
	}
	
	public int getSides(){
		return this._sides;
	}
	
}
