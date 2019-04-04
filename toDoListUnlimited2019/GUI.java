package toDoListUnlimited2019;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

public class GUI extends JFrame {
	public GUI() {
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
		btnAdd.setFont(new Font("Rockwell", Font.PLAIN, 15));
		btnAdd.setBounds(176, 281, 125, 50);
		getContentPane().add(btnAdd);
	}
}
