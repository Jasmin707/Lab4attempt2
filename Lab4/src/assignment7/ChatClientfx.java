package assignment7;

import java.io.*;
import java.net.*;

import assignment7.ChatClientfx.IncomingReader;
//import assignment7.ChatClientfx.SendButtonListener;
import javafx.geometry.Insets;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Timer;

import assignment5.Critter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.awt.*;
import java.awt.event.*;

public class ChatClientfx extends Stage{
	private BufferedReader reader;
	private PrintWriter writer;
	private TextField outgoing = new TextField();
	private TextArea incoming = new TextArea();
	private Button send = new Button("Send");
	
	public void run() throws Exception {
		initView();
		setUpNetworking();
	}
	
	private void initView(){
		//making grid
	    GridPane grid = new GridPane();
	    grid.setAlignment(Pos.TOP_LEFT);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
	    
	    //creating the window
	    Scene scene = new Scene(grid, 400, 300);
	    this.setScene(scene);
	    this.setTitle("E&J Instant Messager");
	    
	    //creating text area
	    grid.add(incoming, 0, 0);
	    incoming.setEditable(false);
	    
	    //creating text field
	    grid.add(outgoing, 0, 2);
	    
	    //send button
	    grid.add(send, 1, 2);
	    
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
