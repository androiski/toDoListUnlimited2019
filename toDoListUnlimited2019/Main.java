package toDoListUnlimited2019;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Main {

	private JFrame frame;
	private JTextField nameTextField;
	private JTextField priTextField;
	private Vector tasks;
	private JList taskList;
	private DefaultListModel<String> selectTask;
	//nTasks is a global variable that keeps track of how many tasks are currently in the list
	//its value is changed when we add, delete, and edit
	private static int nTasks = 0;
	
	//sortBy is a global variable that keeps track of whether or not the list is sorted by priority or description.
	//0 means priority, 1 means description
	private static int sortBy = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		//3rd was 814
		frame.setBounds(100, 100, 1500, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//list
		tasks = new Vector();
		selectTask = new DefaultListModel<>();
		taskList = new JList(selectTask);
		//3rd was 459
		taskList.setBounds(329, 11, 1450, 429);
		frame.getContentPane().add(taskList);
		frame.setResizable(false);
		JLabel tName = new JLabel("Name:");
		tName.setBounds(10, 55, 48, 14);
		frame.getContentPane().add(tName);
		
		priTextField = new JTextField();
		priTextField.setBounds(102, 130, 96, 20);
		frame.getContentPane().add(priTextField);
		priTextField.setColumns(10);
		
		JLabel tDescription = new JLabel("Description:");
		tDescription.setBounds(10, 80, 80, 14);
		frame.getContentPane().add(tDescription);
		
		JLabel tPriority = new JLabel("Priority:");
		tPriority.setBounds(10, 133, 48, 14);
		frame.getContentPane().add(tPriority);
		
		JLabel tDue = new JLabel("Due:");
		tDue.setBounds(10, 158, 48, 14);
		frame.getContentPane().add(tDue);
		
		JComboBox dueDateYR = new JComboBox();
		dueDateYR.setModel(new DefaultComboBoxModel(new String[] {"YEAR", "2019", "2020", "2021", "2022", "2023", "2024"}));
		dueDateYR.setBounds(51, 154, 69, 22);
		frame.getContentPane().add(dueDateYR);
		
		JComboBox dueDateMT = new JComboBox();
		dueDateMT.setModel(new DefaultComboBoxModel(new String[] {"MONTH", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		dueDateMT.setBounds(129, 154, 69, 22);
		frame.getContentPane().add(dueDateMT);
		
		JComboBox dueDateDY = new JComboBox();
		dueDateDY.setModel(new DefaultComboBoxModel(new String[] {"DAY", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dueDateDY.setBounds(208, 154, 69, 22);
		frame.getContentPane().add(dueDateDY);
		
		JLabel tDateStarted = new JLabel("Started:");
		tDateStarted.setBounds(10, 238, 63, 14);
		frame.getContentPane().add(tDateStarted);
		
		JComboBox dateStartYR = new JComboBox();
		dateStartYR.setEnabled(false);
		dateStartYR.setModel(new DefaultComboBoxModel(new String[] {"YEAR", "2019", "2020", "2021", "2022", "2023", "2024"}));
		dateStartYR.setBounds(61, 235, 69, 20);
		frame.getContentPane().add(dateStartYR);
		
		JComboBox dateStartMT = new JComboBox();
		dateStartMT.setEnabled(false);
		dateStartMT.setModel(new DefaultComboBoxModel(new String[] {"MONTH", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		dateStartMT.setBounds(140, 235, 69, 20);
		frame.getContentPane().add(dateStartMT);
		
		JComboBox dateStartDY = new JComboBox();
		dateStartDY.setEnabled(false);
		dateStartDY.setModel(new DefaultComboBoxModel(new String[] {"DAY", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dateStartDY.setBounds(219, 235, 69, 20);
		frame.getContentPane().add(dateStartDY);
		
		JCheckBox chckbxStarted = new JCheckBox("Started");
		chckbxStarted.setBounds(10, 208, 97, 23);
		frame.getContentPane().add(chckbxStarted);
		
		JLabel errMsg = new JLabel("");
		errMsg.setBounds(21, 21, 256, 23);
		errMsg.setForeground(Color.red);
		frame.getContentPane().add(errMsg);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(100, 52, 177, 20);
		frame.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		
		JTextArea descTextPane = new JTextArea();
		descTextPane.setBounds(100, 75, 177, 37);
		frame.getContentPane().add(descTextPane);
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
		
		//button to add to the list
		JButton btnNewButton = new JButton("FINISH\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxStarted.isSelected() && (dateStartYR.getSelectedItem().toString().equals("YEAR") || dateStartMT.getSelectedItem().toString().equals("MONTH") || dateStartDY.getSelectedItem().toString().equals("DAY"))){
					errMsg.setText("FILL IN DATE STARTED OR UNCHECK IT");
				}
				else if(nameTextField.getText().equals("") || priTextField.getText().equals("") || descTextPane.getText().equals("") || dueDateYR.getSelectedItem().toString().equals("YEAR") || dueDateMT.getSelectedItem().toString().equals("MONTH") || dueDateDY.getSelectedItem().toString().equals("DAY")) {
					errMsg.setText("PLEASE FILL IN ALL THE FIELDS");
					}
				else {
					errMsg.setText("");
					Task newTask = new Task();
					String name = "";
					String desc = "";
					String pri = "";
					
					String dueYr = "";
					String dueMo = "";
					String dueDa = "";
					String dueDate = "";
					
					String startYr = "";
					String startMo = "";
					String startDa = "";
					String startDate = "";
					
					String finYr = "";
					String finMo = "";
					String finDa = "";
					String finDate = "";
					int status = 0;
					
					//retrieving data from base fields name, desc, pri, due date
					name = nameTextField.getText();
					desc = descTextPane.getText();
					pri = priTextField.getText();
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
						int x = Integer.parseInt(pri);
						newTask.setPri(x);
						int dDate = Integer.parseInt(dueDate);
						newTask.setDue(dDate);
					}
					else
					{
						newTask.setName(name);
						newTask.setDesc(desc);
						int x = Integer.parseInt(pri);
						newTask.setPri(x);
						int dDate = Integer.parseInt(dueDate);
						newTask.setDue(dDate);
					}
					
					int unique = 1;
					if (nTasks >= 1)
					{
						for (int i = 0; i < nTasks; i++)
						{
							//creating a temporary task object to see if the newTasks' name/description are unique
							Task checkTask = (Task)tasks.get(i);
							if (checkTask.getName().equals(newTask.getName()))
							{
								unique = 0;
								errMsg.setText("INVALID NAME: MUST BE UNIQUE");
							}
							else if (checkTask.getDesc().equals(newTask.getDesc()))
							{
								unique = 0;
								errMsg.setText("INVALID DESCRIPTION: MUST BE UNIQUE");
							}
						}
					}
					
					//checking if the name/description are unique. if they are, then the task is added to the list
					if (unique == 1)
					{
						//clearing the fields for next inputs
						nameTextField.setText("");
						descTextPane.setText("");
						priTextField.setText("");
						tasks.add(newTask);
						updateTaskList();
						nTasks++;
					}
					
				}
			}
		});
		btnNewButton.setBounds(10, 319, 109, 22);
		frame.getContentPane().add(btnNewButton);
		
		//listener to delete the selected index
		JButton delButton = new JButton("DELETE");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int delIndex = taskList.getSelectedIndex();
				if (delIndex == -1)
				{
					errMsg.setText("SELECT A TASK TO DELETE");
				}
				else
				{
					//removes the selected task from the JList, decrements number of tasks
					selectTask.removeElement(tasks.remove(delIndex));
					nTasks--;
				}
				updateTaskList();
			}
		});
		delButton.setBounds(10, 380, 110, 23);
		frame.getContentPane().add(delButton);
		
		//edit button listener
		JButton editButton = new JButton("EDIT");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int delIndex = taskList.getSelectedIndex();
				//deletes the task from the list if it finds it
				if (delIndex == -1)
				{
					errMsg.setText("SELECT A TASK TO EDIT");
				}
				else
				{
					//this block of code fills in the name/desc/priority fields on the left side of the screen.
					//removes the selected task from the JList, decrements number of tasks
					Task newTask = (Task) tasks.get(delIndex);
					nameTextField.setText(newTask.getName());
					descTextPane.setText(newTask.getDesc());
					int x = newTask.getPri();
					priTextField.setText(Integer.toString(x));
					selectTask.removeElement(tasks.remove(delIndex));
					nTasks--;
				}
				updateTaskList();
			}
		});
		editButton.setBounds(10, 417, 110, 23);
		frame.getContentPane().add(editButton);
		
		//SAVE BUTTON
		JButton saveButton = new JButton("SAVE");
		saveButton.setBounds(140, 380, 109, 23);
		frame.getContentPane().add(saveButton);
		
		//LOAD BUTTON
		JButton loadButton = new JButton("LOAD");
		loadButton.setBounds(140, 417, 109, 23);
		frame.getContentPane().add(loadButton);
		
		
		
		
	}
	//fills JList with updated Vector information
	//this method is called whenever we alter the JList after clicking the Finish, Delete, or Edit buttons.
	public void updateTaskList()
	{
		selectTask.removeAllElements();
		for(int i = 0; i < tasks.size(); i++)
		{
			selectTask.addElement(tasks.get(i).toString());
		}
		taskList.setModel(selectTask);
		taskList.updateUI();
	}
}