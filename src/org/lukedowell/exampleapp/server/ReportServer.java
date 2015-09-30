package org.lukedowell.exampleapp.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import org.lukedowell.exampleapp.server.db.ReportDB;
import org.lukedowell.exampleapp.shared.entities.Report;
import org.lukedowell.exampleapp.shared.net.Network;
import org.lukedowell.exampleapp.shared.net.message.LoginRequest;
import org.lukedowell.exampleapp.shared.net.message.LoginResponse;
import org.lukedowell.exampleapp.shared.net.message.ReportRequest;
import org.lukedowell.exampleapp.shared.net.message.ReportResponse;

import javax.swing.*;
import java.io.IOException;

/**
 * Our server, and main controller for this side of the application
 * @author Luke Dowell
 *
 */
public class ReportServer {

	/** Our kryo server */
	private Server server;
	
	/** Our database object */
	private ReportDB database;
	
	/**
	 * Constructor
	 */
	public ReportServer() {
		try {
			server = new Server();
			Network.register(server.getKryo());
			server.start();
			server.bind(Network.PORT, Network.PORT);
			database = new ReportDB();
			
			server.addListener(new Listener() { 
				@Override
				public void received(Connection con, Object o) {
					if(o instanceof LoginRequest) {
						LoginRequest req = (LoginRequest) o;
						LoginResponse res = new LoginResponse();
						if(database.validateUser(req.getUsername(), req.getPassword())) {
							res.setAccepted(true);
						} 
						con.sendTCP(res);
					} else if (o instanceof ReportRequest) {
						ReportRequest req = (ReportRequest) o;
						Report r = database.buildReport(req.getReportid());
						ReportResponse res = new ReportResponse();
						res.setReport(r);
						con.sendTCP(res);
					}
				}
			
			});
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Network error, try restarting the application.");
			e.printStackTrace();
		}
	}
	
}
