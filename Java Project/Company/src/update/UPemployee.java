package update;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Login.sqliteConnection;
import empinfo.Refresh;
public class UPemployee extends JFrame{
	private JPanel contentPane;
	Connection con = null;
	Refresh refresh = new Refresh();
	Update up = new Update();
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UPemployee() {
		
		
		Color bgcolor = new Color(5, 150, 163);
		

		con = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(bgcolor);
		contentPane.setLayout(null);
		
		JLabel lblEID = new JLabel("EID");
		lblEID.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEID.setBounds(10, 10, 65, 31);
		contentPane.add(lblEID);
		
		final JTextField textFieldEID = new JTextField();
		textFieldEID.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldEID.setBounds(76, 10, 156, 22);
		contentPane.add(textFieldEID);
		textFieldEID.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName.setBounds(10, 50, 65, 31);
		contentPane.add(lblName);

		final JTextField textFieldName = new JTextField();
		textFieldName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldName.setBounds(76, 50, 156, 22);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSurname.setBounds(10, 90, 65, 31);
		contentPane.add(lblSurname);
		
		final JTextField textFieldSurname = new JTextField();
		textFieldSurname.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldSurname.setBounds(76, 90, 156, 22);
		contentPane.add(textFieldSurname);
		textFieldSurname.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAge.setBounds(10, 130, 65, 31);
		contentPane.add(lblAge);
		
		final JTextField textFieldAge = new JTextField();
		textFieldAge.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldAge.setBounds(76, 130, 156, 22);
		contentPane.add(textFieldAge);
		textFieldAge.setColumns(10);
		

		
		
		//table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(440, 10, 530, 320);
		scrollPane.getViewport().setBackground(Color.white);
		contentPane.add(scrollPane);
		

		final JTable table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					int row = table.getSelectedRow();
					String EID = (table.getModel().getValueAt(row, 0).toString());				
					String query = "select * from Employeeinfo where EID = '" + EID + "' ";
					PreparedStatement pst = con.prepareStatement(query);					
					ResultSet rs = pst.executeQuery();					
					while(rs.next()){
						textFieldEID.setText(rs.getString("EID"));
						textFieldName.setText(rs.getString("NAME"));
						textFieldSurname.setText(rs.getString("SURNAME"));
						textFieldAge.setText(rs.getString("AGE"));
					}
					pst.close();					
					
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
		});
		refresh.refreshTable(con, table);
		
		//update button
		up.infoUpdate(textFieldEID, textFieldName, textFieldSurname, textFieldAge, con, contentPane, table);
		up.back(contentPane, this);
	}
}
