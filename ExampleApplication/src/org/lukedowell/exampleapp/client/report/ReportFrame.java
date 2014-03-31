package org.lukedowell.exampleapp.client.report;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.lukedowell.exampleapp.client.ReportClient;
import org.lukedowell.exampleapp.shared.entities.Report;
import org.lukedowell.exampleapp.shared.entities.ReportEntry;
import org.lukedowell.exampleapp.shared.net.message.ReportRequest;

/**
 * Our report frame 
 * @author Luke Dowell
 *
 */
public class ReportFrame extends JFrame {

	///////////////////
	////COMPONENTS/////
	///////////////////
	
	private JLabel reportLabel;
	
	private ReportTable reportTable;
	
	private JPanel bottomPanel; //will hold our button and field
	
	private JButton loadButton;
	
	private JTextField numberField;
	
	/**
	 * Build our frame
	 */
	public ReportFrame() {
		int strutSize = 10;
		
		reportLabel = new JLabel("Report Name Here");
		reportTable = new ReportTable();
		bottomPanel = new JPanel();
		loadButton = new JButton("Load");
		loadButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = 1;
				try {
					id = Integer.parseInt(numberField.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please only use numbers!");
				}
				ReportRequest req = new ReportRequest();
				req.setReportid(id);
				ReportClient.sendMessage(req);
			}
		});
		numberField = new JTextField("3");
		
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
		bottomPanel.add(Box.createHorizontalStrut(strutSize));
		bottomPanel.add(loadButton);
		bottomPanel.add(Box.createHorizontalStrut(strutSize));
		bottomPanel.add(numberField);
		bottomPanel.add(Box.createHorizontalStrut(strutSize));
		
		setTitle("Report");
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		add(Box.createVerticalStrut(strutSize));
		add(reportLabel);
		add(Box.createVerticalStrut(strutSize));
		add(reportTable);
		add(Box.createVerticalStrut(strutSize));
		add(bottomPanel);
		add(Box.createVerticalStrut(strutSize));
		
		pack();
//		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	/**
	 * Displays a report on our frame
	 * @param r
	 */
	public void displayReport(Report report) {
		reportTable.clear();
		reportLabel.setText(report.getName());
		for(ReportEntry e : report.getEntries()) {
			reportTable.addEntry(e);
		}
	}
}
