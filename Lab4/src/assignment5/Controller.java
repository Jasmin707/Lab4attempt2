package assignment5;

import javafx.geometry.Insets;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Timer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;



public class Controller extends Stage {
	Button step = new Button("Step Once");
	Button quit = new Button("Quit");
	Button display = new Button("Display World");
	Button goStep = new Button("Step");
	Button goMake = new Button("Make Critter(s)");
	Button goStats = new Button("Get");
	Button goSeed = new Button("Set");
	Button runAnime = new Button("Animate");
	Button stopAnime = new Button("Pause");
	boolean executeAnimation = false;
	
	Controller(){
		//making grid
	    GridPane grid = new GridPane();
	    grid.setAlignment(Pos.TOP_LEFT);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
	    
	    //creating the window
	    Scene scene = new Scene(grid, 400, 600);
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
	    grid.add(seedText, 0, 15);
	    Label setText = new Label("Value:");
	    grid.add(setText, 0, 16);
	    TextField seedInput = new TextField();
	    grid.add(seedInput, 1, 16);
	    grid.add(goSeed, 2, 16);
	    
	    //animation label
	    Label animeLabel = new Label("Animation");
	    grid.add(animeLabel, 0, 19);
	    
	    //quit button
	    grid.add(quit, 2, 20);
	    
	    //display button
	    grid.add(display, 0, 17);
	    
	    //step error text
	    final Text stepError = new Text();
	    grid.add(stepError, 1, 3);
	    
	    //make error text
	    final Text makeError = new Text();
	    grid.add(makeError, 1, 9);
	    
	    //stat error text
	    final Text statError = new Text();
	    grid.add(statError, 1, 14);
	    
	    //seed error text
	    final Text seedError = new Text();
	    grid.add(seedError, 1, 17);
	    
	    //animation slider
	    Slider anime = new Slider(1, 10, 1);
	    anime.setShowTickMarks(true);
	    anime.setShowTickLabels(true);
	    anime.setSnapToTicks(true);
	    anime.setMajorTickUnit(1);
	    grid.add(anime, 0, 20);
	    
	    //buttons for animations
	    grid.add(runAnime, 1, 19);
	    grid.add(stopAnime, 1, 20);
	    
	    
	    //button starts actions for anime
	    runAnime.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent t) {
	        	executeAnimation = true;
	        	Timer pace = new Timer();
	        	while(executeAnimation){
	        		try{
	        			pace.wait(1000/(long)anime.getValue());
	        		}catch (Exception e){
	        			
	        		}
	        		Display.paint();
	        	}
	        }
	    });
	    
	    //button that sends action
	    stopAnime.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent t) {
	        	executeAnimation = false;
	        }
	    });
	    
	    //step button
	    step.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent t) {
	        	Critter.worldTimeStep();
	        }
	    });
	    
	    //quit button
	    quit.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent t) {
	        	System.exit(0);
	        }
	    });
	    
	    //display button
	    display.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent t) {
	        	Critter.displayWorld();
	        }
	    });
	    
	    //step multiple times button
	    goStep.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent t) {
	        	Integer numberOfCrit = new Integer(-1);
	        	String fromInput = stepInput.getText();
	        	try {
	        		numberOfCrit = Integer.parseInt(fromInput);
	        	} catch (NumberFormatException e){
	        		stepError.setFill(Color.FIREBRICK);
	        		stepError.setText("Invalid Input");
	        	}
	        	if (numberOfCrit < 1) {
	        		stepError.setFill(Color.FIREBRICK);
	        		stepError.setText("Invalid Input");
	        	} else {
	        		stepError.setText("");
	        		for (Integer i = 0; i < numberOfCrit; i++){
	        			Critter.worldTimeStep();
	        		}
	        	}
	        }
	    });
	    
	    //make Critter
	    goMake.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent t) {
	        	makeError.setText("");
	        	Integer numberOfCrit = new Integer(-1);
	        	String fromInput = amountInput.getText();
	        	String critName = nameInput.getText();
	        	try {
	        		numberOfCrit = Integer.parseInt(fromInput);
	        	} catch (NumberFormatException e){
	        		makeError.setFill(Color.FIREBRICK);
	        		makeError.setText("Invalid Input");
	        	}
	        	if (numberOfCrit < 1) {
	        		makeError.setFill(Color.FIREBRICK);
	        		makeError.setText("Invalid Input");
	        	} else {
					try {
						for (Integer i = 0; i < numberOfCrit; i++) {
							Critter.makeCritter(critName);
						}
					} catch (Exception e) {
						makeError.setFill(Color.FIREBRICK);
		        		makeError.setText("Invalid Input");
					}
	        	}
	        }
	    });
	    
	  //Critter stats
	    goStats.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent t) {
	        	statError.setText("");
	        	String critName = statInput.getText();
	        	List<Critter> crtStats; 
	        	String out = new String();
				Class<?> critClass;
					if(critName.equals("Critter")){
						out = Critter.runStats();
						new StatsWindow(out);
					}else{
						try {
							crtStats = Critter.getInstances(critName);
							critClass = Class.forName("assignment5." + critName);
							Method runStats = critClass.getMethod("runStats", List.class);
		    				out = (String)runStats.invoke(null, crtStats);
							new StatsWindow(out);
						} catch (Exception e) {
							statError.setFill(Color.FIREBRICK);
			        		statError.setText("Invalid Input");
						}
					}
	        	}
	    });
	    
	  //set seed
	    goSeed.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent t) {
	        	Integer numberOfSeed = new Integer(-1);
	        	String fromInput = seedInput.getText();
	        	seedError.setText("");
	        	try {
	        		numberOfSeed = Integer.parseInt(fromInput);
	        	} catch (NumberFormatException e){
	        		seedError.setFill(Color.FIREBRICK);
	        		seedError.setText("Invalid Input");
	        	}
	        	Critter.setSeed((long)numberOfSeed);	
	        }
	    });
	    
	    this.show();
	}
	
}
