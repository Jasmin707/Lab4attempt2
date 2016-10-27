package assignment5;

import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Controller extends Stage {
	Button step = new Button("Step Once");
	Button quit = new Button("Quit");
	Button goStep = new Button("Step");
	Button goMake = new Button("Make Critter(s)");
	Button goStats = new Button("Get");
	Button goSeed = new Button("Set");
	
	Controller(){
		//making grid
	    GridPane grid = new GridPane();
	    grid.setAlignment(Pos.TOP_LEFT);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
	    
	    //creating the window
	    Scene scene = new Scene(grid, 400, 550);
	    this.setScene(scene);
	    this.setTitle("Controller");
	    
	    //make title
	    Text scenetitle = new Text("Critters!");
	    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	    grid.add(scenetitle, 0, 0);
	    
	    
	    //multi step fields
	    Label stepText = new Label("Step");
	    grid.add(stepText, 0, 1);
	    Label stepAmount = new Label("Amount:");
	    grid.add(stepAmount, 0, 2);
	    TextField stepInput = new TextField();
	    grid.add(stepInput, 1, 2);
	    grid.add(goStep, 2, 2);
	    //one step button
	    grid.add(step, 0, 3);
	    
	  //make fields
	    Label makeText = new Label("Make Critter");
	    grid.add(makeText, 0, 6);
	    Label nameText = new Label("Name:");
	    grid.add(nameText, 0, 7);
	    TextField nameInput = new TextField();
	    grid.add(nameInput, 1, 7);
	    Label amountText = new Label("Amount:");
	    grid.add(amountText, 0, 8);
	    TextField amountInput = new TextField();
	    grid.add(amountInput, 1, 8);
	    grid.add(goMake, 0, 9);
	    
	    //stats
	    Label statText = new Label("Stats");
	    grid.add(statText, 0, 12);
	    Label critText = new Label("Critter:");
	    grid.add(critText, 0, 13);
	    TextField statInput = new TextField();
	    grid.add(statInput, 1, 13);
	    grid.add(goStats, 2, 13);
	    
	    //seed
	    Label seedText = new Label("Seed");
	    grid.add(seedText, 0, 16);
	    Label setText = new Label("Value:");
	    grid.add(setText, 0, 17);
	    TextField seedInput = new TextField();
	    grid.add(seedInput, 1, 17);
	    grid.add(goSeed, 2, 17);
	    
	    //quit button
	    grid.add(quit, 0, 20);
	    
	    //step button
	    step.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent t) {
	        	Critter.worldTimeStep();
	        }
	    });
	    
	    //step multiple times button
	    // DOES NOT WORK***********************************
	    goStep.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent t) {
	        	System.out.println(stepInput);
	        }
	    });
	    
	    this.show();
	}
	
}
