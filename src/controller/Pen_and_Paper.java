package controller;

import javafx.application.Application;
import javafx.stage.Stage;

/**Start of the Program. <br>
 * Uses JavaFX for Gui.
 * */
public class Pen_and_Paper extends Application{

	private IOController io;
	private Tester test;
	
	public static void main(String args[]){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		//GameLogicController glc = new GameLogicController();
		
		io = new IOController();
		test = new Tester();
		
		io.setGame("Apocalypse");
		io.load(io.game);
		
		test.setGame();
		
		
		//MainGui mi = new MainGui(primaryStage);
		return;
	}
	
	public IOController getIOController(){
		return this.io;
	}
	
	public Tester getTester(){
		return this.test;
	}
	
}
