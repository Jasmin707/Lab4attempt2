/* CRITTERS Main.java
 * EE422C Project 5 submission by
 * Jasmin Rajan
 * jor427
 * 16470
 * Ethan Cranmer
 * elc2255
 * 16475
 * Slip days used: <0>
 * Git URL: https://github.com/Jasmin707/Lab4attempt2
 * Fall 2016
 */
package assignment5;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		new Controller();
	}

}
