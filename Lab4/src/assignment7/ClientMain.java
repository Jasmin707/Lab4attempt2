package assignment7;

import javafx.application.Application;
import javafx.stage.Stage;

public class ClientMain extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			new ChatClientfx().run();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
