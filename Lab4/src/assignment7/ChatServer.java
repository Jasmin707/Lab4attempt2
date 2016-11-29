package assignment7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class ChatServer extends Observable {
	public static void main(String[] args) {
		try {
			new ChatServer().setUpNetworking();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private void setUpNetworking() throws Exception {
		@SuppressWarnings("resource")
		ServerSocket serverSock = new ServerSocket(4242);
		while (true) {
			Socket clientSocket = serverSock.accept();
			ClientObserver writer = new ClientObserver(clientSocket.getOutputStream());
			Thread t = new Thread(new ClientHandler(clientSocket, writer));
			t.start();
			this.addObserver(writer);
			System.out.println("got a connection");
		}
	}
	

	HashMap<BufferedReader, UserData> users = new HashMap<BufferedReader, UserData>();
	
	class ClientHandler implements Runnable {
		private BufferedReader reader;
		private ClientObserver writer;
		public ClientHandler(Socket clientSocket, ClientObserver writer) {
			Socket sock = clientSocket;
			this.writer = writer;
			try {
				reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				users.put(reader, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void run() {
			String message;
			try {
				while ((message = reader.readLine()) != null) {
					System.out.println("server read "+message);
					setChanged();
					if(users.get(reader) == null){
						users.replace(reader, new UserData(writer, message));
					}else{
						String[] temp = message.split(":");
						boolean isPM = false;
						//checking if the thing was a pm
						for(BufferedReader cur : users.keySet()){
							if(users.get(cur).getUsername().equals(temp[0])){
								isPM = true;
								break;
							}
						}
						String fromUser = users.get(reader).getUsername();
						if(isPM){
							ArrayList<ClientObserver> notCorrectUserList = new ArrayList<ClientObserver>();
							ArrayList<ClientObserver> isCorrectUserList = new ArrayList<ClientObserver>();
							//adds sender to userlist
							isCorrectUserList.add(users.get(reader).getObserver());
							for(BufferedReader cur : users.keySet()){
								if(users.get(cur).getUsername().equals(temp[0])){
									//adds the receiver to userlist
									isCorrectUserList.add(users.get(cur).getObserver());
								}else{
									notCorrectUserList.add(users.get(cur).getObserver());
								}
							}
							String newMessage = "";
							for (int i = 1; i < temp.length; i ++){
								newMessage += temp[i];
							}
							deleteObservers();
							for(ClientObserver cur : isCorrectUserList){
								addObserver(cur);
							}
							notifyObservers("(DM) " + fromUser + ": " + newMessage);
							for(ClientObserver cur : notCorrectUserList){
								addObserver(cur);
							}
						}
						else{
							notifyObservers(fromUser + ": " + message);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
