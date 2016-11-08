package assignment5;

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

public class StatsWindow extends Stage{
	public GridPane grid = new GridPane();
	
	StatsWindow(String out){
		//grid.setGridLinesVisible(true);
        grid.setAlignment(Pos.TOP_LEFT);
        Scene scene = new Scene(grid, 400, 200);
        this.setTitle("Stats");
        this.setScene(scene);
        
        this.grid.getChildren().clear();
        
        Label stats = new Label(out);
	    grid.add(stats, 0, 0);
        
        this.show();
	}
	
	/**
	 * This function paints all the critters to the world.
	 */
	public static void paint(){
		Critter.displayWorld();
	}
}
