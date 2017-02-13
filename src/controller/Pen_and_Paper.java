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
		test = new Tester();
		
		io = new IOController("Apocalypse");
		io.newRes();
		
		test.setGame();
		
		
		//MainGui mi = new MainGui(primaryStage);
		System.exit(0);
	}
	
	public IOController getIOController(){
		return this.io;
	}
	
	public Tester getTester(){
		return this.test;
	}
	
}
