package toDoListUnlimited2019;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
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
				dispose();	
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
	}
}
