package org.lukedowell.exampleapp.shared.net.message;

/**
 * A report request
 * @author Luke Dowell
 *
 */
public class ReportRequest {

	/** The report that we are asking for */
	private int reportid;
	
	public ReportRequest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the reportid
	 */
	public int getReportid() {
		return reportid;
	}

	/**
	 * @param reportid the reportid to set
	 */
	public void setReportid(int reportid) {
		this.reportid = reportid;
	}
	
	
}
