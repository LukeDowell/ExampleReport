package org.lukedowell.exampleapp.shared.entities;

import java.util.LinkedList;

/**
 * A report entity
 * @author Luke Dowell
 *
 */
public class Report extends Entity {

	/** This report's name */
	private String mName;
	
	/** The entries this report is comprised of */
	private LinkedList<ReportEntry> entries;
	
	public Report() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Creates a new report
	 * @param id
	 * 		The report's ID
	 * @param name
	 * 		The report's name
	 */
	public Report(int id, String name) {
		super(id);
		this.mName = name;
		
		entries = new LinkedList<ReportEntry>();
	}

	/**
	 * @return the mName
	 */
	public String getName() {
		return mName;
	}

	/**
	 * @param mName the mName to set
	 */
	public void setName(String mName) {
		this.mName = mName;
	}

	/**
	 * @param entries the entries to set
	 */
	public void setEntries(LinkedList<ReportEntry> entries) {
		this.entries = entries;
	}

	/**
	 * @return the entries
	 */
	public LinkedList<ReportEntry> getEntries() {
		return entries;
	}

}
