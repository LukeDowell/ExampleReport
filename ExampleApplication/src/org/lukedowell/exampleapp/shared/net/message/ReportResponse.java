package org.lukedowell.exampleapp.shared.net.message;

import org.lukedowell.exampleapp.shared.entities.Report;

/**
 * A server's response to the report request
 * @author Luke Dowell
 *
 */
public class ReportResponse {
	
	/** The report. Null if it wasn't found */
	private Report report = null;
	
	public ReportResponse() {
	}

	/**
	 * @return the report
	 */
	public Report getReport() {
		return report;
	}

	/**
	 * @param report the report to set
	 */
	public void setReport(Report report) {
		this.report = report;
	}
}
