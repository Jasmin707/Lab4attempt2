package assignment7;

public class UserData {
	private ClientObserver observer;
	private String username;
	
	public UserData(ClientObserver observer, String username) {
		this.setObserver(observer);
		this.setUsername(username);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ClientObserver getObserver() {
		return observer;
	}

	public void setObserver(ClientObserver observer) {
		this.observer = observer;
	}
}
