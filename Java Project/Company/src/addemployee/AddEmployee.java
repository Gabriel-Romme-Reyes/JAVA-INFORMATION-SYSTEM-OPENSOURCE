package addemployee;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Login.sqliteConnection;
import java.awt.Color;
import java.awt.Font;



@SuppressWarnings("serial")
public class AddEmployee extends JFrame{
	private JPanel contentPane;

	Add add = new Add();
	Connection con = null;
	

	
	public AddEmployee(JTable table) {
		Color bgcolor = new Color(5, 150, 163);
		

		con = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 288, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(bgcolor);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName.setBounds(10, 10, 65, 31);
		contentPane.add(lblName);

		JTextField textFieldName = new JTextField();
		textFieldName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldName.setBounds(76, 10, 156, 22);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSurname.setBounds(10, 50, 65, 31);
		contentPane.add(lblSurname);
		
		JTextField textFieldSurname = new JTextField();
		textFieldSurname.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldSurname.setBounds(76, 50, 156, 22);
		contentPane.add(textFieldSurname);
		textFieldSurname.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAge.setBounds(10, 90, 65, 31);
		contentPane.add(lblAge);
		
		JTextField textFieldAge = new JTextField();
		textFieldAge.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldAge.setBounds(76, 90, 156, 22);
		contentPane.add(textFieldAge);
		textFieldAge.setColumns(10);
		
		add.infoAdd(textFieldName,textFieldSurname,textFieldAge, con, contentPane,table);
		add.back(contentPane,this);
	}
}
