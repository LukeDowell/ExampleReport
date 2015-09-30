package org.lukedowell.exampleapp.client;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import org.lukedowell.exampleapp.client.login.LoginFrame;
import org.lukedowell.exampleapp.client.report.ReportFrame;
import org.lukedowell.exampleapp.shared.entities.Report;
import org.lukedowell.exampleapp.shared.net.Network;
import org.lukedowell.exampleapp.shared.net.message.LoginResponse;
import org.lukedowell.exampleapp.shared.net.message.ReportResponse;

import javax.swing.*;
import java.io.IOException;

/**
 * Our client, and main controller for this side of the application
 * @author Luke Dowell
 *
 */
public class ReportClient {

	/** Our kryo client */
	private static Client client;
	
	/** Our login frame */
	private LoginFrame loginFrame;
	
	/** Our report frame */
	private ReportFrame reportFrame;
	
	/** How long until we timeout in millis */
	public static final int CONNECTION_TIMEOUT = 5000;
	
	/**
	 * Contructor
	 */
	public ReportClient() {
		try {
			loginFrame = new LoginFrame();
			loginFrame.setVisible(true);
			client = new Client();
			Network.register(client.getKryo());
			client.start();
			client.connect(ReportClient.CONNECTION_TIMEOUT, "localhost", Network.PORT, Network.PORT);
			client.addListener(new Listener() { 
				@Override
				public void received(Connection con, Object o) {
					if(o instanceof ReportResponse) {
						ReportResponse res = (ReportResponse) o;
						Report r = res.getReport();
						if(r != null) {
							reportFrame.displayReport(res.getReport());
						}
					} else if (o instanceof LoginResponse) {
						loginFrame.reset();
						LoginResponse res = (LoginResponse) o;
						if(res.isAccepted()) {
							loginFrame.setVisible(false);
							reportFrame = new ReportFrame();
							reportFrame.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(loginFrame, "Invalid username/password");
						}
					}
				}
			});
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Network error. Have you started the server?");
			e.printStackTrace();
		}
	}
	
	/**
	 * Static way of letting our forms access some client functionality
	 * @param o
	 * 		The object we are sending
	 */
	public static void sendMessage(Object o) {
		client.sendTCP(o);
	}
}
