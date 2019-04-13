package toDoListUnlimited2019;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;

public class AddMenu extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextField;
	private JLabel lblDescription;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMenu frame = new AddMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 397);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(153, 27, 250, 20);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(97, 30, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblDescription = new JLabel("Description:");
		lblDescription.setBounds(57, 56, 86, 14);
		contentPane.add(lblDescription);
		
		JLabel lblDueDate = new JLabel("Due Date:");
		lblDueDate.setBounds(71, 150, 72, 14);
		contentPane.add(lblDueDate);
		
		JComboBox dueDateYR = new JComboBox();
		dueDateYR.setModel(new DefaultComboBoxModel(new String[] {"YEAR", "2019", "2020", "2021", "2022", "2023", "2024"}));
		dueDateYR.setBounds(153, 147, 86, 20);
		contentPane.add(dueDateYR);
		
		JComboBox dueDateMT = new JComboBox();
		dueDateMT.setModel(new DefaultComboBoxModel(new String[] {"MONTH", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		dueDateMT.setBounds(239, 147, 99, 20);
		contentPane.add(dueDateMT);
		
		JComboBox dueDateDY = new JComboBox();
		dueDateDY.setModel(new DefaultComboBoxModel(new String[] {"DAY", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dueDateDY.setBounds(332, 147, 86, 20);
		contentPane.add(dueDateDY);
		
		JLabel lblDateStarted = new JLabel("Date Started:");
		lblDateStarted.setBounds(57, 238, 86, 14);
		contentPane.add(lblDateStarted);
		
		JComboBox dateStartYR = new JComboBox();
		dateStartYR.setEnabled(false);
		dateStartYR.setModel(new DefaultComboBoxModel(new String[] {"YEAR", "2019", "2020", "2021", "2022", "2023", "2024"}));
		dateStartYR.setBounds(153, 235, 86, 20);
		contentPane.add(dateStartYR);
		
		JComboBox dateStartMT = new JComboBox();
		dateStartMT.setEnabled(false);
		dateStartMT.setModel(new DefaultComboBoxModel(new String[] {"MONTH", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		dateStartMT.setBounds(239, 235, 99, 20);
		contentPane.add(dateStartMT);
		
		JComboBox dateStartDY = new JComboBox();
		dateStartDY.setEnabled(false);
		dateStartDY.setModel(new DefaultComboBoxModel(new String[] {"DAY", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dateStartDY.setBounds(332, 235, 86, 20);
		contentPane.add(dateStartDY);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(153, 58, 250, 79);
		contentPane.add(scrollPane);
		
		JEditorPane descTextPane = new JEditorPane();
		scrollPane.setViewportView(descTextPane);
		
		JCheckBox chckbxStarted = new JCheckBox("Started");
		chckbxStarted.setBounds(153, 203, 97, 23);
		contentPane.add(chckbxStarted);
		chckbxStarted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				if(chckbxStarted.isSelected()) {
					dateStartYR.setEnabled(true);
					dateStartMT.setEnabled(true);
					dateStartDY.setEnabled(true);
				}
				else {
					dateStartYR.setEnabled(false);
					dateStartMT.setEnabled(false);
					dateStartDY.setEnabled(false);
				}
			}
		});

		
		
		JLabel errMsg = new JLabel("");
		errMsg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		errMsg.setForeground(Color.RED);
		errMsg.setBounds(71, 293, 543, 64);
		contentPane.add(errMsg);
		
		JButton btnNewButton = new JButton("FINISH\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxStarted.isSelected() && (dateStartYR.getSelectedItem().toString().equals("YEAR") || dateStartMT.getSelectedItem().toString().equals("MONTH") || dateStartDY.getSelectedItem().toString().equals("DAY"))){
					errMsg.setText("PLEASE FILL IN DATE STARTED OR UNCHECK IT");
				}
				else if(nameTextField.getText().equals("") || descTextPane.getText().equals("") || dueDateYR.getSelectedItem().toString().equals("YEAR") || dueDateMT.getSelectedItem().toString().equals("MONTH") || dueDateDY.getSelectedItem().toString().equals("DAY")) {
					errMsg.setText("PLEASE FILL IN ALL THE FIELDS");
					}
				else {
					errMsg.setText("");
					Task newTask = new Task();
					String name = "";
					String desc = "";
					String dueYr = "";
					String dueMo = "";
					String dueDa = "";
					String dueDate = "";
					String startYr = "";
					String startMo = "";
					String startDa = "";
					String startDate = "";
					int status = 0;
					
					name = nameTextField.getText();
					desc = descTextPane.getText();
					dueYr = dueDateYR.getSelectedItem().toString();
					dueMo = dueDateMT.getSelectedItem().toString();
					dueDa = dueDateDY.getSelectedItem().toString();
					
					if(dueMo.equals("January"))
					{
						dueMo = "01";
					}
					else if(dueMo.equals("February"))
					{
						dueMo = "02";
					}
					else if(dueMo.equals("March"))
					{
						dueMo = "03";
					}
					else if(dueMo.equals("April"))
					{
						dueMo = "04";
					}
					else if(dueMo.equals("May"))
					{
						dueMo = "05";
					}
					else if(dueMo.equals("June"))
					{
						dueMo = "06";
					}
					else if(dueMo.equals("July"))
					{
						dueMo = "07";
					}
					else if(dueMo.equals("August"))
					{
						dueMo = "08";
					}
					else if(dueMo.equals("September"))
					{
						dueMo = "09";
					}
					else if(dueMo.equals("October"))
					{
						dueMo = "10";
					}
					else if(dueMo.equals("November"))
					{
						dueMo = "11";
					}
					else if(dueMo.equals("December"))
					{
						dueMo = "12";
					}
					dueDate = dueYr + dueMo + dueDa;
					
					if(chckbxStarted.isSelected())
					{
						startYr = dateStartYR.getSelectedItem().toString();
						startMo = dateStartMT.getSelectedItem().toString();
						startDa = dateStartDY.getSelectedItem().toString();
						if(startMo.equals("January"))
						{
							startMo = "01";
						}
						else if(startMo.equals("February"))
						{
							startMo = "02";
						}
						else if(startMo.equals("March"))
						{
							startMo = "03";
						}
						else if(startMo.equals("April"))
						{
							startMo = "04";
						}
						else if(startMo.equals("May"))
						{
							startMo = "05";
						}
						else if(startMo.equals("June"))
						{
							startMo = "06";
						}
						else if(startMo.equals("July"))
						{
							startMo = "07";
						}
						else if(startMo.equals("August"))
						{
							startMo = "08";
						}
						else if(startMo.equals("September"))
						{
							startMo = "09";
						}
						else if(startMo.equals("October"))
						{
							startMo = "10";
						}
						else if(startMo.equals("November"))
						{
							startMo = "11";
						}
						else if(startMo.equals("December"))
						{
							startMo = "12";
						}
						startDate = startYr + startMo + startDa;
						int stDate = Integer.parseInt(startDate);
						newTask.setStarted(stDate);
						status = 1;
						newTask.setName(name);
						newTask.setDesc(desc);
						int dDate = Integer.parseInt(dueDate);
						newTask.setDue(dDate);
						newTask.setInfo(0, name, desc, dDate, status, stDate, 0);
					}
					else
					{
						newTask.setName(name);
						newTask.setDesc(desc);
						int dDate = Integer.parseInt(dueDate);
						newTask.setDue(dDate);
						newTask.setInfo(0, name, desc, dDate, status, 0, 0);
					}
					
					
					dispose();
					
				}
			}
		});
		btnNewButton.setBounds(475, 125, 152, 65);
		contentPane.add(btnNewButton);
		


	}
}
