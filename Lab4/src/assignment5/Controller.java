package assignment5;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;



public class Controller extends Stage {
	Button openOther = new Button("Hello World");
	HBox x = new HBox();
	
	Controller(){
	    x.getChildren().add(openOther);
	    this.setScene(new Scene(x, 300, 300));
	    this.show();

	    openOther.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent t) {
	            System.out.println("Hello World");;
	        }
	    });
	}
	
}
