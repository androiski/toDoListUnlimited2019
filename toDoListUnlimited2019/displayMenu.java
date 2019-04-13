package toDoListUnlimited2019;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class displayMenu extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displayMenu frame = new displayMenu();
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
	public displayMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setTitle("To Do List Unlimited 2019\r\n");
		getContentPane().setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddMenu menuadd = new AddMenu();
				menuadd.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		btnAdd.setFont(new Font("Rockwell", Font.PLAIN, 15));
		btnAdd.setBounds(181, 366, 120, 27);
		getContentPane().add(btnAdd);
		
		JButton btnNewButton = new JButton("Load");
		btnNewButton.setFont(new Font("Rockwell", Font.PLAIN, 15));
		btnNewButton.setBounds(452, 366, 125, 27);
		getContentPane().add(btnNewButton);
		
		JList list_1 = new JList();
		list_1.setBounds(725, 169, 16, 1);
		contentPane.add(list_1);
		
		JLabel lblToDoList = new JLabel("To Do List Unlimted 2019");
		lblToDoList.setFont(new Font("Rockwell", Font.PLAIN, 40));
		lblToDoList.setBounds(150, 0, 500, 100);
		contentPane.add(lblToDoList);
		
		
		String[] colName= {"Priority","Name", "Description", "Due Date", "Status"};
		String[][] fillerData=new String[6][5];	
		String[] arr0= {"1","Task 1","Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1", "Due Date 1", "Status 1"};
		String[] arr1= {"1","Task 1","Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1", "Due Date 1", "Status 1"};
		String[] arr2= {"1","Task 1","Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1", "Due Date 1", "Status 1"};
		String[] arr3= {"1","Task 1","Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1", "Due Date 1", "Status 1"};
		String[] arr4= {"1","Task 1","Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1", "Due Date 1", "Status 1"};
		String[] arr5= {"1","Task 1","Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1Description 1", "Due Date 1", "Status 1"};
		fillerData[0]=arr0;
		fillerData[1]=arr1;
		fillerData[2]=arr2;
		fillerData[3]=arr3;
		fillerData[4]=arr4;
		fillerData[5]=arr5;
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 77, 720, 80);
		contentPane.add(scrollPane);
		table = new JTable(fillerData,colName);
		scrollPane.setViewportView(table);
		
		//DEAL WITH COLUMN RESIZE LATER
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.setDefaultEditor(Object.class, null);
		
	}
}