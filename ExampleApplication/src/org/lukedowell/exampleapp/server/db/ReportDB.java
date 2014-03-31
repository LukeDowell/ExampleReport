package org.lukedowell.exampleapp.server.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.lukedowell.exampleapp.shared.entities.Report;
import org.lukedowell.exampleapp.shared.entities.ReportEntry;

/**
 * Our database handler. All db requests will come through here
 * @author Luke Dowell
 *
 */
public class ReportDB {

	/** Our connection to the db */
	private Connection con; //normally would be managed much better but since it's a local sqlite database we don't have to
	
	/**
	 * Constructor
	 */
	public ReportDB() {
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:res\\report.db");
			con.setAutoCommit(false);
			System.out.println("Connected to database!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Simple user validation
	 * @param username
	 * 		The username
	 * @param password
	 * 		The password
	 * @return
	 * 		true if valid, false otherwise
	 */
	public boolean validateUser(String username, String password) {
		try {
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM Users WHERE username = '" + username + "'");
			if(rs.next()) {
				if(password.equals(rs.getString("password"))) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 
	 * @param reportid
	 * @return
	 * @throws SQLException 
	 */
	public Report buildReport(int reportid) {
		try {
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM Reports WHERE ID = '" + reportid +"'");
			Report report = null;
			if(rs.next()) {
				report = new Report(reportid, rs.getString("name"));
			} else {
				return null;
			}
			
			rs = con.createStatement().executeQuery("SELECT * FROM ReportEntries WHERE report_id = " + reportid);
			while(rs.next()) {
				report.getEntries().add(new ReportEntry(rs.getInt("entry_id"), rs.getInt("dollars"), rs.getInt("widgets"), rs.getInt("product_id")));
			}
			return report;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
