package org.lukedowell.exampleapp.client.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.lukedowell.exampleapp.client.ReportClient;
import org.lukedowell.exampleapp.shared.net.message.LoginRequest;

/**
 * Our login frame
 * @author Luke Dowell
 *
 */
public class LoginFrame extends JFrame {

	
	///////////////////
	////COMPONENTS/////
	///////////////////
		
	private JButton loginButton;
	
	private JTextField usernameField;
	private JTextField passwordField;
	
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	

	private JPanel buttonPanel;
	private JPanel usernamePanel;
	private JPanel passwordPanel;
 
	/**
	 * Constructor, we also build our frame here.
	 * The over use of struts here is bad, I will learn to do this with margins and borders next time.
	 */
	public LoginFrame() {
		int strutSize = 10;  //The dimensions of our struts, both vertical and horizontal
		
		//build our username panel
		usernamePanel = new JPanel();
		usernamePanel.setLayout(new BoxLayout(usernamePanel, BoxLayout.X_AXIS));
		usernameLabel = new JLabel("Username:");
		usernameField = new JTextField("luke");
		
		usernamePanel.add(Box.createHorizontalStrut(strutSize));
		usernamePanel.add(usernameLabel);
		usernamePanel.add(Box.createHorizontalStrut(strutSize)); //create empty space 10 pixels wide
		usernamePanel.add(usernameField);
		usernamePanel.add(Box.createHorizontalStrut(strutSize));
		
		//build the password panel
		passwordPanel = new JPanel();
		passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
		passwordLabel = new JLabel("Password:");
		passwordField = new JTextField("password"); //could be a password field, but then the text is in char[] form which is just a hassle for this
		
		passwordPanel.add(Box.createHorizontalStrut(strutSize));
		passwordPanel.add(passwordLabel);
		passwordPanel.add(Box.createHorizontalStrut(strutSize));
		passwordPanel.add(passwordField);
		passwordPanel.add(Box.createHorizontalStrut(strutSize));
		
		//build our button panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doLogin();
			}
		});
		buttonPanel.add(loginButton);
		
		//build our frame
		setTitle("Login");
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		add(Box.createVerticalStrut(strutSize)); 
		add(usernamePanel);
		add(Box.createVerticalStrut(strutSize));
		add(passwordPanel);
		add(Box.createVerticalStrut(strutSize));
		add(buttonPanel);
		add(Box.createVerticalStrut(strutSize));
		
		pack();
		setSize(300, 135);
		setResizable(false);
//		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * Attempts a login action
	 */
	private void doLogin() {
		ReportClient.sendMessage(new LoginRequest(usernameField.getText(), passwordField.getText()));
		loginButton.setEnabled(false); 
	}
	
	public void reset() {
		loginButton.setEnabled(true);
	}
}
