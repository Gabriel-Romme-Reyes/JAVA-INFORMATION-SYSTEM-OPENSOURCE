package Login;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import empinfo.EmployeeInfo;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



@SuppressWarnings("serial")
public class Login extends JFrame {
	Clock clock = new Clock();
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textFieldUN;
	private JLabel lblClock;

	
	

	/**
	 * Launch the application.
	 */
	Connection connection = null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();

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
	public Login() {
		this.setTitle("Login");
		Color bgcolor = new Color(5, 150, 163);
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(bgcolor);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblClock = new JLabel("");
		lblClock.setBounds(300, 223, 219, 18);
		contentPane.add(lblClock);

		
		JLabel label_UserName = new JLabel("Username");
		label_UserName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_UserName.setBounds(100, 71, 71, 30);
		label_UserName.setForeground(Color.white);
		contentPane.add(label_UserName);
		
		JLabel label_Password = new JLabel("Password");
		label_Password.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_Password.setBounds(100, 112, 71, 30);
		label_Password.setForeground(Color.white);
		contentPane.add(label_Password);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				try{
					String query="select * from User where UserName = ? and Password = ?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFieldUN.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while(rs.next()){
						count = count + 1;
					}
					if (count == 1){
						Login.this.setVisible(false);
						EmployeeInfo Emplinfo = new EmployeeInfo();
						Emplinfo.setVisible(true);
					}
					else if(count > 1){
						JOptionPane.showMessageDialog(null, "Duplicate UserName and Password");
					}
					else{
						JOptionPane.showMessageDialog(null, "UserName and Password is not correct Try Again...");
					}
					rs.close();
					pst.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnLogin.setBounds(280, 153, 97, 30);
		contentPane.add(btnLogin);
		
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 112, 200, 23);
		contentPane.add(passwordField);
		
		textFieldUN = new JTextField();
		textFieldUN.setColumns(10);
		textFieldUN.setBounds(180, 71, 200, 23);
		contentPane.add(textFieldUN);
		
		

		
		clock.time(lblClock);
	}
}

