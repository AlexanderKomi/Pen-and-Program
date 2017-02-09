package controller;

import model.Dice;

/**"Tester" should only be used for testing purposes.
 * 
 * */
public class Tester {

	public Tester(){
		System.out.println("\n IMPORTANT: Tester : FOR USE IN GAME, PLS GET RID OF THIS CLASS");
		System.out.println("Test for git.");
		
		//TEST METHODEN
		//testDiceRoll();
	}
	
	public void testAll(){
		testDiceRoll();
		
	}
	
	public void testDiceRoll(){
		Dice d = new Dice(12);
		int tries = 1000;
		
		
		
		for(int i = 0 ; i < tries ; i++){
			d.roll();
		}
		d.print();
	}
	
	public String setGame(){
		return "Apocalypse";
	}
	
}
