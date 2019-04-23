package toDoListUnlimited2019;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.regex.Pattern;

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
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;

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
		frame.setBounds(100, 100, 1023, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("To Do List Unlimited 2019");
		//list
		tasks = new Vector();
		selectTask = new DefaultListModel<>();
		frame.setResizable(false);
		JLabel tName = new JLabel("Name:");
		tName.setBounds(10, 21, 48, 14);
		frame.getContentPane().add(tName);
		
		priTextField = new JTextField();
		priTextField.setBounds(102, 130, 40, 20);
		frame.getContentPane().add(priTextField);
		priTextField.setColumns(10);
		
		JLabel tDescription = new JLabel("Description:");
		tDescription.setBounds(10, 45, 80, 14);
		frame.getContentPane().add(tDescription);
		
		JLabel tPriority = new JLabel("Priority:");
		tPriority.setBounds(10, 133, 48, 14);
		frame.getContentPane().add(tPriority);
		
		JLabel tDue = new JLabel("Due:");
		tDue.setBounds(10, 158, 48, 14);
		frame.getContentPane().add(tDue);
		
		JComboBox dueDateYR = new JComboBox();
		dueDateYR.setModel(new DefaultComboBoxModel(new String[] {"YEAR", "2019", "2020", "2021", "2022", "2023", "2024"}));
		dueDateYR.setBounds(73, 154, 69, 22);
		frame.getContentPane().add(dueDateYR);
		
		JComboBox dueDateMT = new JComboBox();
		dueDateMT.setModel(new DefaultComboBoxModel(new String[] {"MONTH", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		dueDateMT.setBounds(152, 154, 69, 22);
		frame.getContentPane().add(dueDateMT);
		
		JComboBox dueDateDY = new JComboBox();
		dueDateDY.setModel(new DefaultComboBoxModel(new String[] {"DAY", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dueDateDY.setBounds(231, 154, 69, 22);
		frame.getContentPane().add(dueDateDY);
		
		JLabel tDateStarted = new JLabel("Started:");
		tDateStarted.setBounds(10, 213, 63, 14);
		frame.getContentPane().add(tDateStarted);
		
		JComboBox dateStartYR = new JComboBox();
		dateStartYR.setEnabled(false);
		dateStartYR.setModel(new DefaultComboBoxModel(new String[] {"YEAR", "2019", "2020", "2021", "2022", "2023", "2024"}));
		dateStartYR.setBounds(73, 210, 69, 20);
		frame.getContentPane().add(dateStartYR);
		
		JComboBox dateStartMT = new JComboBox();
		dateStartMT.setEnabled(false);
		dateStartMT.setModel(new DefaultComboBoxModel(new String[] {"MONTH", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		dateStartMT.setBounds(152, 210, 69, 20);
		frame.getContentPane().add(dateStartMT);
		
		JComboBox dateStartDY = new JComboBox();
		dateStartDY.setEnabled(false);
		dateStartDY.setModel(new DefaultComboBoxModel(new String[] {"DAY", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dateStartDY.setBounds(231, 210, 69, 20);
		frame.getContentPane().add(dateStartDY);
		
		JCheckBox chckbxStarted = new JCheckBox("Started");
		chckbxStarted.setBounds(10, 183, 97, 23);
		frame.getContentPane().add(chckbxStarted);
		
		JCheckBox chckbxFinished = new JCheckBox("Finished");
		chckbxFinished.setBounds(10, 238, 99, 23);
		frame.getContentPane().add(chckbxFinished);
		
		JLabel lblFinished = new JLabel("Finished:");
		lblFinished.setBounds(12, 268, 63, 14);
		frame.getContentPane().add(lblFinished);
		
		JComboBox dateFinYR = new JComboBox();
		dateFinYR.setEnabled(false);
		dateFinYR.setModel(new DefaultComboBoxModel(new String[] {"YEAR", "2019", "2020", "2021", "2022", "2023", "2024"}));
		dateFinYR.setBounds(75, 262, 69, 20);
		frame.getContentPane().add(dateFinYR);
		
		JComboBox dateFinMO = new JComboBox();
		dateFinMO.setEnabled(false);
		dateFinMO.setModel(new DefaultComboBoxModel(new String[] {"MONTH", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		dateFinMO.setBounds(154, 262, 69, 20);
		frame.getContentPane().add(dateFinMO);
		
		JComboBox dateFinDY = new JComboBox();
		dateFinDY.setEnabled(false);
		dateFinDY.setModel(new DefaultComboBoxModel(new String[] {"DAY", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dateFinDY.setBounds(233, 262, 69, 20);
		frame.getContentPane().add(dateFinDY);
		chckbxFinished.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				if(chckbxFinished.isSelected()) {
					dateFinYR.setEnabled(true);
					dateFinMO.setEnabled(true);
					dateFinDY.setEnabled(true);
				}
				else {
					dateFinYR.setEnabled(false);
					dateFinMO.setEnabled(false);
					dateFinDY.setEnabled(false);
				}
			}
		});
		
		JScrollPane descScrollPane = new JScrollPane();
		descScrollPane.setBounds(102, 54, 198, 71);
		frame.getContentPane().add(descScrollPane);
		
		JTextArea descTextPane = new JTextArea();
		descScrollPane.setViewportView(descTextPane);
		
		
		JLabel errMsg = new JLabel("");
		errMsg.setBounds(340, 414, 334, 23);
		errMsg.setForeground(Color.red);
		frame.getContentPane().add(errMsg);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(102, 19, 198, 20);
		frame.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
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
				else if(chckbxFinished.isSelected() && (dateFinYR.getSelectedItem().toString().equals("YEAR") || dateFinMO.getSelectedItem().toString().equals("MONTH") || dateFinDY.getSelectedItem().toString().equals("DAY"))){
					errMsg.setText("FILL IN DATE FINISHED OR UNCHECK IT");
				}
				else if(nameTextField.getText().equals("") || priTextField.getText().equals("") || descTextPane.getText().equals("") || dueDateYR.getSelectedItem().toString().equals("YEAR") || dueDateMT.getSelectedItem().toString().equals("MONTH") || dueDateDY.getSelectedItem().toString().equals("DAY")) {
					errMsg.setText("PLEASE FILL IN ALL THE FIELDS");
					}
				else if((Pattern.matches("[0-9]+", priTextField.getText())) == false){
					errMsg.setText("PLEASE USE ONLY INTEGERS FOR PRIORITY");
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
						newTask.setStartStr();
						status = 1;
						//newTask.setName(name);
						//newTask.setDesc(desc);
						//int x = Integer.parseInt(pri);
						//newTask.setPri(x);
						//int dDate = Integer.parseInt(dueDate);
						//newTask.setDue(dDate);
					}
					if(chckbxFinished.isSelected())
					{
						finYr = dateFinYR.getSelectedItem().toString();
						finMo = dateFinMO.getSelectedItem().toString();
						finDa = dateFinDY.getSelectedItem().toString();
						if(finMo.equals("January"))
						{
							finMo = "01";
						}
						else if(finMo.equals("February"))
						{
							finMo = "02";
						}
						else if(finMo.equals("March"))
						{
							finMo = "03";
						}
						else if(finMo.equals("April"))
						{
							finMo = "04";
						}
						else if(finMo.equals("May"))
						{
							finMo = "05";
						}
						else if(finMo.equals("June"))
						{
							finMo = "06";
						}
						else if(finMo.equals("July"))
						{
							finMo = "07";
						}
						else if(finMo.equals("August"))
						{
							finMo = "08";
						}
						else if(finMo.equals("September"))
						{
							finMo = "09";
						}
						else if(finMo.equals("October"))
						{
							finMo = "10";
						}
						else if(finMo.equals("November"))
						{
							finMo = "11";
						}
						else if(finMo.equals("December"))
						{
							finMo = "12";
						}
						finDate = finYr + finMo + finDa;
						int fiDate = Integer.parseInt(finDate);
						newTask.setFinished(fiDate);
						newTask.setFinStr();
						status = 2;
					}
					
					newTask.setName(name);
					newTask.setDesc(desc);
					int x = Integer.parseInt(pri);
					newTask.setPri(x);
					int dDate = Integer.parseInt(dueDate);
					newTask.setDue(dDate);
					newTask.setDueStr();
					newTask.setStatus(status);
					
					
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
						nTasks++;
						sortList();
						updateTaskList();
					}
					
				}
			}
		});
		btnNewButton.setBounds(10, 329, 109, 22);
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
		editButton.setBounds(10, 414, 110, 23);
		frame.getContentPane().add(editButton);
		
		//SAVE BUTTON
		JButton saveButton = new JButton("SAVE");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (nTasks >= 1)
				{
					try {
						//creating an array of tasks in order to save task list to a file
					    Task[] saveList = new Task[nTasks];
					    for (int i = 0; i < nTasks; i++)
					    {
					    	saveList[i] = (Task)tasks.get(i);
					    }
					    //writing the temporary task array to file
					    FileOutputStream fos = new FileOutputStream("saveList.ser");
					    ObjectOutputStream oos = new ObjectOutputStream(fos);
					    oos.flush();
					    oos.writeObject(saveList);
					    oos.close();
					    errMsg.setText("");
					}
					catch (FileNotFoundException e) {
					    e.printStackTrace();
					}
					catch (IOException e) {
					    e.printStackTrace();
					}
				}
				else
				{
					errMsg.setText("CANNOT SAVE EMPTY LIST");
				}
			}
		});
		saveButton.setBounds(129, 380, 109, 23);
		frame.getContentPane().add(saveButton);
		
		//LOAD BUTTON
		JButton loadButton = new JButton("LOAD");
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				    //creating inputstreams to read from file
				    FileInputStream fis = new FileInputStream("saveList.ser");
				    ObjectInputStream ois = new ObjectInputStream(fis);
				    //creating a temporary array to read objects into
				    Task[] savedList = (Task[]) ois.readObject();
				    ois.close();
				    if (nTasks >= 1)
				    {
				    	tasks.removeAllElements();
				    	updateTaskList();
				    	nTasks = 0;
				    }
				    for (int i = 0; i < savedList.length; i++)
				    {
				    	Task newTask = savedList[i];
				    	tasks.add(newTask);
				    	updateTaskList();
				    	nTasks++;
				    }
				}
				catch (FileNotFoundException e) {
				    errMsg.setText("SAVED LIST DOES NOT EXIST");
				}
				catch (IOException e) {
				    e.printStackTrace();
				}
				catch (ClassNotFoundException e) {
				    e.printStackTrace();
				}
			}
		});
		loadButton.setBounds(129, 414, 109, 23);
		frame.getContentPane().add(loadButton);
		
		JScrollPane taskListscrollPane = new JScrollPane();
		taskListscrollPane.setBounds(330, 10, 667, 393);
		frame.getContentPane().add(taskListscrollPane);
		taskList = new JList(selectTask);
		taskListscrollPane.setViewportView(taskList);
		
		JRadioButton sortCheck = new JRadioButton("Sort by Description");
		sortCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sortCheck.isSelected()) {
					sortBy = 1;
					sortList();
					updateTaskList();
				}
				else {
					sortBy = 0;
					sortList();
					updateTaskList();
				}
			}
		});
		sortCheck.setBounds(10, 300, 175, 21);
		frame.getContentPane().add(sortCheck);
		
		JButton RESET = new JButton("RESET");
		RESET.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tasks.removeAllElements();
				nTasks = 0;
				updateTaskList();
			}
		});
		RESET.setBounds(888, 424, 109, 23);
		frame.getContentPane().add(RESET);
		

		
		
	}
	
	public void sortList()
	{
		//if sortBy = 0, we sort the tasks by priority
		if (sortBy == 0)
		{
			//copy Vector contents into a temporary array and sort inside of the array
			Task[] sortList = new Task[nTasks];
		    for (int i = 0; i < nTasks; i++)
		    {
		    	sortList[i] = (Task)tasks.get(i);
		    }
		    tasks.removeAllElements();
		    //now to sort
		    
		    int i, j;
		    for (j = 1; j < nTasks; j++)
		    {
		    	Task s = sortList[j];
		    	i = j;
		    	while (i > 0 && sortList[i - 1].getPri() > s.getPri())
		    	{
		    		sortList[i] = sortList[i - 1];
		    		--i;
		    	}
		    	sortList[i] = s;
		    }
		    //nTasks = 0;
		    for (int x = 0; x < sortList.length; x++)
		    {
		    	Task newTask = sortList[x];
		    	tasks.add(x, newTask);
		    	//updateTaskList();
		    	//nTasks++;
		    }
		    
		}
		//sort by description
		else if (sortBy == 1)
		{
			//copy Vector contents into a temporary array and sort inside of the array
			Task[] sortList = new Task[nTasks];
		    for (int i = 0; i < nTasks; i++)
		    {
		    	sortList[i] = (Task)tasks.get(i);
		    }
		    tasks.removeAllElements();
		    //now to sort
		    
		    int i, j;
		    for (j = 1; j < nTasks; j++)
		    {
		    	Task s = sortList[j];
		    	i = j;
		    	while (i > 0 && sortList[i - 1].getDesc().compareTo(s.getDesc()) > 0)
		    	{
		    		sortList[i] = sortList[i - 1];
		    		--i;
		    	}
		    	sortList[i] = s;
		    }
		    //nTasks = 0;
		    for (int x = 0; x < sortList.length; x++)
		    {
		    	Task newTask = sortList[x];
		    	tasks.add(x, newTask);
		    	//updateTaskList();
		    	//nTasks++;
		    }
		}
	}
	
	public void WriteObjectToFile(Object listItem) {
		 
        try {
            FileOutputStream fileOut = new FileOutputStream("saveList.sav");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(listItem);
            objectOut.close();
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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