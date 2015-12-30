package com.psamp.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.psamp.transcipts.JDBCLayer;
import com.psamp.transcipts.Transcript;

public class Gui {
	private JPanel panel;
	private JDBCLayer jdbc = new JDBCLayer("agile");
	private JTextField firstName = new JTextField("First Name");
	private JTextField lastName = new JTextField("Last Name");
	private JTextField email = new JTextField("Email");
	private JTextField grade = new JTextField("Grade");
	private JTextField year = new JTextField("Year (e.g. 2000)");
	private JTextField month = new JTextField("Month (e.g. 12)");
	private JTextField day = new JTextField("Day (e.g. 25)");
	private JButton allStudents = new JButton("See All Students");
	private JButton newStudent = new JButton("Add New Student");
	private List<Component> fields = new ArrayList<Component>();

	{
		panel = new JPanel();
		this.prepareComponents(panel);
		JOptionPane.showMessageDialog(null, panel);
	}

	private void reset() {
		firstName.setText("First Name");
		lastName.setText("Last Name");
		email.setText("Email");
		grade.setText("Grade");
		year.setText("Year (e.g. 2000)");
		month.setText("Month (e.g. 12)");
		day.setText("Day (e.g. 25)");
	}

	private void prepareComponents(JPanel panel) {
		fields.add(firstName);
		fields.add(lastName);
		fields.add(email);
		fields.add(grade);
		fields.add(year);
		fields.add(month);
		fields.add(day);

		newStudent.addActionListener(new AddNewStudent());
		fields.add(newStudent);

		allStudents.addActionListener(new DisplayAllStudents());
		fields.add(allStudents);

		for (Component component : fields) {

			if (component instanceof JTextField) {
				component.setForeground(Color.GRAY);
			}

			panel.add(component);
		}

	}

	class DisplayAllStudents implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JPanel panel = new JPanel();

			panel.add(new JLabel(this.getTranscriptData()));

			JOptionPane.showMessageDialog(null, panel);

		}

		private String getTranscriptData() {
			StringBuilder sb = new StringBuilder();

			sb.append("<html>");
			sb.append("<h2>All Students</h2>");
			sb.append("<ul>");

			for (Transcript ts : jdbc.getAllFromCurrentTable()) {
				sb.append("<li><bold>Name:</bold> " + ts.getFirstName() + " " + ts.getLastName() + " (" + ts.getEmail()
						+ ")</li>");
				sb.append("<li><bold>Grade:</bold> " + ts.getGrade() + "</li>");
				sb.append("<li><bold>Passed:</bold> " + ts.isPassed() + "</li>");
				// add location
				sb.append("<li><bold>Date</bold>: " + ts.getDateTaken() + "</li>");
				sb.append("<br></br>");
			}

			sb.append("</ul>");
			sb.append("</html>");

			return sb.toString();
		}

	}

	class AddNewStudent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			int response = 0;

			try {

				response = jdbc.postNewTranscript(firstName.getText(), lastName.getText(), email.getText(),
						year.getText() + "-" + month.getText() + "-" + day.getText(),
						Integer.parseInt(grade.getText()));

				if (response > 0) {
					JOptionPane.showMessageDialog(null, "Thank you for submitting your information.");
					reset();
				} else {
					JOptionPane.showMessageDialog(null, "Please try again.");
					reset();
				}

			} catch (Exception exp) {
				exp.printStackTrace();

				JOptionPane.showMessageDialog(null, "Check that fields are properly formatted (or have input.)");

			}

		}

	}

}
