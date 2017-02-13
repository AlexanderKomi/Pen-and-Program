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
			newRes();
		} else {
			// TODO: Implement better solution.
			throw new RuntimeException("ONLY APOCALYPSE IMPLEMENTET YET! Pls only select this.");
		}
	}

	/**
	 * Creates new Ressources and tries to load the game from data.<br>
	 * 
	 * @return Ressources The new set ressources are returned.
	 */
	public Ressources newRes() {
		return this.res = new Ressources(this.game);
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
