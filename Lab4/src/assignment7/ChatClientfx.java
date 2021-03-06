package assignment7;

import java.io.*;
import java.net.*;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ChatClientfx extends Stage{
	private BufferedReader reader;
	private PrintWriter writer;
	private TextField outgoing = new TextField();
	private TextArea incoming = new TextArea();
	private Button send = new Button("Send");
	private String id;
	
	public void run() throws Exception {
		initView();
		getId();
		setUpNetworking();
	}
	
	
	
	class UsernamePrompt extends Stage{
		UsernamePrompt(){
		GridPane idWindow = new GridPane();
		idWindow.setAlignment(Pos.TOP_LEFT);
		idWindow.setHgap(10);
		idWindow.setVgap(10);
		idWindow.setPadding(new Insets(25, 25, 25, 25));
		
		//making scene
		Scene scene = new Scene(idWindow, 300, 100);
	    this.setScene(scene);
	    this.setTitle("Enter an ID");
	    
	    Label username = new Label("Username:");
	    idWindow.add(username, 0, 0);
	    TextField usernameInput = new TextField();
	    idWindow.add(usernameInput, 1, 0);
	    
	    //making button
		Button enter = new Button("Enter");
		idWindow.add(enter, 0, 1);
		
		enter.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent t) {
	        	id = usernameInput.getText();
	        	writer.println(id);
				writer.flush();
	        	close();
	        }
	    });
		
		this.show();
		}
		
	}
	
	private void getId() {
		new UsernamePrompt();
	}

	private void initView(){
		//making grid
	    GridPane grid = new GridPane();
	    grid.setAlignment(Pos.TOP_LEFT);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
	    
	    //creating the window
	    Scene scene = new Scene(grid, 400, 325);
	    this.setScene(scene);
	    this.setTitle("E&J Instant Messager");
	    
	    //creating text area
	    grid.add(incoming, 0, 0);
	    incoming.setEditable(false);
	    
	    //creating text field
	    grid.add(outgoing, 0, 2);
	    
	    //send button
	    grid.add(send, 0, 3);
	    
	    send.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent t) {
	        	writer.println(outgoing.getText());
				writer.flush();
				outgoing.setText("");
				outgoing.requestFocus();
	        }
	    });
	    
	    this.show();
	}
	
	
	
	private void setUpNetworking() throws Exception {
		@SuppressWarnings("resource")
		Socket sock = new Socket("127.0.0.1", 4242);
		InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
		reader = new BufferedReader(streamReader);
		writer = new PrintWriter(sock.getOutputStream());
		System.out.println("networking established");
		Thread readerThread = new Thread(new IncomingReader());
		readerThread.start();
	}
	
	

	class IncomingReader implements Runnable {
		public void run() {
			String message;
			try {
				while ((message = reader.readLine()) != null) {
						incoming.appendText(message + "\n");
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
