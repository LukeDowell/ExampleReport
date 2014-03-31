package org.lukedowell.exampleapp.shared.entities;

/**
 * Describes a single entry into our report
 * @author Luke Dowell
 *
 */
public class ReportEntry extends Entity {

	/** The dollar amount for this entry */
	private double dollars;
	
	/** The number of widgets */
	private int widgets;
	
	/** Our product id */
	private int product_id;
	
	public ReportEntry() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Creates a report entry
	 * @param id
	 * 		The id
	 * @param dollars
	 * 		Dollar amount
	 * @param widget
	 * 		Widget amount
	 * @param product_id
	 * 		Product id
	 */
	public ReportEntry(int id, double dollars, int widget, int product_id) {
		super(id);
		this.dollars = dollars;
		this.widgets = widget;
		this.product_id = product_id;
	}
	
	/**
	 * Pulls all of the data in an easy-to-use format for our table model
	 * @return
	 * .
	 * 		An object array containing all of our data
	 */
	public Object[] getData() {
		Object[] data = new Object[]{id, dollars, widgets, product_id};
		return data;
	}
	
}
