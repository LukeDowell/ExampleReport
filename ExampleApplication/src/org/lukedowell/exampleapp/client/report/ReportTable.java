package org.lukedowell.exampleapp.client.report;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.lukedowell.exampleapp.shared.entities.ReportEntry;

/**
 * Our report table 
 * @author Luke Dowell
 *
 */
public class ReportTable extends JPanel {
	
	/** Our table model */
	private DefaultTableModel tableModel;
	
	private JTable table;
	
	private JScrollPane scrollPane;
	/** 
	 * Constructor
	 */
	public ReportTable() {
		table = new JTable();
		tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Dollars");
		tableModel.addColumn("Widgets");
		tableModel.addColumn("Product ID");
		table.setModel(tableModel);
		scrollPane = new JScrollPane(table);
		add(scrollPane);
	}
	
	public void clear() {
		tableModel.setRowCount(0);
	}
	/**
	 * Adds a single entry to our table
	 * @param entry
	 * 		The entry we are adding to our table
	 */
	public void addEntry(ReportEntry entry) {
		tableModel.addRow(entry.getData());
	}
}
