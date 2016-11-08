/* CRITTERS Display.java
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
 */package assignment5;

import javafx.geometry.Insets;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

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

public class Display extends Stage{
	public static GridPane grid = new GridPane();
	
	Display(){
		//grid.setGridLinesVisible(true);
        grid.setAlignment(Pos.TOP_LEFT);
        Scene scene = new Scene(grid, (Params.world_width * 15), (Params.world_height * 15));
        this.setTitle("World");
        this.setScene(scene);
        
        //set world width
        for(int i = 0; i < Params.world_width; i++){
        	ColumnConstraints column = new ColumnConstraints(15);
        	grid.getColumnConstraints().add(column);
        }
        
        //sets world height
        for(int i = 0; i < Params.world_height; i++){
        	RowConstraints row = new RowConstraints(15);
        	grid.getRowConstraints().add(row);
        }
        this.show();
	}
	
	/**
	 * This function paints all the critters to the world.
	 */
	public static void paint(){
		Critter.displayWorld();
	}
}
