package assignment7;

import java.io.*;
import java.net.*;

import assignment7.ChatClient.IncomingReader;
import assignment7.ChatClient.SendButtonListener;

import java.awt.*;
import java.awt.event.*;

public class ChatClientfx {
	private BufferedReader reader;
	private PrintWriter writer;
	
	public void run() throws Exception {
		initView();
		setUpNetworking();
	}
	
	private void initView() {
		

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

}
