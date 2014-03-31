package org.lukedowell.exampleapp.shared.net.message;

/**
 * A response to the client from the server regarding the 
 * status of the login request
 * @author Luke Dowell
 *
 */
public class LoginResponse {

	/** Whether or not the response was accepted */
	private boolean accepted = false;
	
	public LoginResponse() {
	}
	
	/**
	 * Login response
	 * @param a
	 * 		Whether or not the provided credentials are accepted
	 */
	public LoginResponse(boolean a) {
		this.accepted = a;
	}

	/**
	 * @return the accepted
	 */
	public boolean isAccepted() {
		return accepted;
	}

	/**
	 * @param accepted the accepted to set
	 */
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
}
