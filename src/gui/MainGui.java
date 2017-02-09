package gui;

import java.util.Arrays;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**This class contains all the sub-windows and is for the management of the application.
 * */
public class MainGui implements MainInterface{

	String game = "Apocalypse";
	
	double windowWidth;
	double windowHeight;
	
	VBox combinedElements;
	Menu menu;
	
	
	Scene dice;
	Scene mainScene;
	Stage stage;
	
	public MainGui(Stage stage) throws Exception{
		this.stage = stage;
		this.combinedElements = new VBox();
		
		try{
			createMenuBar();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try{
			createScene();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try{
			createStage();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		this.stage.show();
	}
	
	
	@Override
	public void createStage() {
		this.stage.setTitle("Pen and Paper");
		this.stage.setScene(mainScene);
		this.stage.centerOnScreen();
	}

	
	@Override
	public void createScene() {
		BorderPane bp = new BorderPane();
		bp.getChildren().add(combinedElements);
	}
	
	public void createMenuBar() {
		List<String> itemNames = Arrays.asList(
				"Roll a dice"
		);
		Menu changeModeMenu = createMenu("Change Mode", itemNames);
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll( changeModeMenu );
		this.mainScene = new Scene(combinedElements, windowWidth, windowHeight);
	}
	
	private Menu createMenu(String menuName, List<String> itemnames){
		Menu menu = new Menu(menuName);
		for(String a : itemnames){
			menu.getItems().addAll(
					new MenuItem(a)
			);
		}
		
		menu.getItems().get(0).setOnAction( e ->{
			System.out.println("Changed Scene to dice roll");
			stage.setScene(dice);
			stage.setTitle("Pen and Paper");
		});
		
		return this.menu =  menu;
	}


	@Override
	public void addElements() {
		Button roll_a_dice = new Button();
		
		roll_a_dice.setOnAction(e -> {
			System.out.println("Button can be clicked ! :)");
		});
		
		combinedElements.getChildren().addAll(roll_a_dice);
	}


	@Override
	public void setGame(String game) {
		this.game = game;
	}


	@Override
	public String getGame() {
		return this.game;
	}


	
}
