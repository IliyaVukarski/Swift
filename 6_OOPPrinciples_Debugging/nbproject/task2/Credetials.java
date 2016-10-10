package task2;

public class Credetials {
	private String username;
	private String password;
	
	public Credetials() {
		
	}
	
	public Credetials(String username, String password) {
		this.setUserName(username);
		this.setPassword(password);
	}
	
	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
