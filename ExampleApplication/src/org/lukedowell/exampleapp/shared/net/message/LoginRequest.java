package org.lukedowell.exampleapp.shared.net.message;

/**
 * A login request message from the client
 * @author UNUMSANCTUM
 *
 */
public class LoginRequest {
	
	/** This requests' username */
	private String username;
	
	/** This requests' password */
	private String password;
	
	public LoginRequest() {} //empty constructor for kryo
	
	/**
	 * Creates a login request
	 * @param username
	 * 		The username
	 * @param password
	 * 		The password
	 */
	public LoginRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	
}
