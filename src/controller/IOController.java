package controller;

import io.Ressources;

/**
 * The IOController manages if data should be read or wrote.
 * 
 * Read:
 * 
 * Creates an instance of "Ressources" and sets the default game.
 * 
 * Write:
 * 
 * Not implemented right now.
 * 
 * @author Alexander Komischke
 */
public class IOController {

	String game;
	private Ressources res;

	public IOController() {
		this.game = "";
		System.out.println("WARNING : Please set a game after creating this. Otherwise game could not be loaded!");
	}

	public IOController(String game) {

		this.game = game;

		if (this.game.equals("Apocalypse")) {
			this. res = new Ressources("Apocalypse");
		} else {
			// TODO: Implement better solution.
			throw new RuntimeException("ONLY APOCALYPSE IMPLEMENTET YET! Pls only select this.");
		}
	}

	public Ressources getRes() {
		return this.res;
	}

	public void setRes(Ressources res) {
		this.res = res;
	}

	public void setGame(String s) {
		System.out.println("Game set to '" + s + "'");
		this.game = s;
	}

}
