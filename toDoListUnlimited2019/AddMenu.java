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

public class AddMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
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
		
		textField = new JTextField();
		textField.setBounds(153, 27, 250, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(97, 30, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblDescription = new JLabel("Description:");
		lblDescription.setBounds(71, 61, 72, 14);
		contentPane.add(lblDescription);
		
		JLabel lblDueDate = new JLabel("Due Date:");
		lblDueDate.setBounds(71, 150, 72, 14);
		contentPane.add(lblDueDate);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"YEAR", "2019", "2020", "2021", "2022", "2023", "2024"}));
		comboBox.setBounds(153, 147, 86, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"MONTH", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox_1.setBounds(239, 147, 99, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"DAY", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_2.setBounds(332, 147, 86, 20);
		contentPane.add(comboBox_2);
		
		JLabel lblDateStarted = new JLabel("Date Started:");
		lblDateStarted.setBounds(57, 238, 86, 14);
		contentPane.add(lblDateStarted);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"YEAR", "2019", "2020", "2021", "2022", "2023", "2024"}));
		comboBox_3.setBounds(153, 235, 86, 20);
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"MONTH", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox_4.setBounds(239, 235, 99, 20);
		contentPane.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"DAY", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_5.setBounds(332, 235, 86, 20);
		contentPane.add(comboBox_5);
		
		JButton btnNewButton = new JButton("FINISH\r\n");
		btnNewButton.setBounds(475, 125, 152, 65);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(153, 58, 250, 79);
		contentPane.add(scrollPane);
		
		JEditorPane editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
	}
}
