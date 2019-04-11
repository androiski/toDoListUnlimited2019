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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		setTitle("To Do List Unlimited 2019\r\n");
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Load");
		btnNewButton.setFont(new Font("Rockwell", Font.PLAIN, 15));
		btnNewButton.setBounds(447, 281, 125, 50);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("To Do List Unlimited 2019");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Rockwell", Font.PLAIN, 48));
		lblNewLabel.setBounds(72, 53, 627, 104);
		getContentPane().add(lblNewLabel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				frame.dispose();
				AddMenu menuadd = new AddMenu();
				menuadd.setVisible(true);
			}
		});
		btnAdd.setFont(new Font("Rockwell", Font.PLAIN, 15));
		btnAdd.setBounds(176, 281, 125, 50);
		getContentPane().add(btnAdd);
	}

}
