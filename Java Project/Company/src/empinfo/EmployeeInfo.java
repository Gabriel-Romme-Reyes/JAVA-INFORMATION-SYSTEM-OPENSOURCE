package empinfo;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Login.sqliteConnection;
import Login.Clock;
import update.*;
import javax.swing.JButton;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import addemployee.AddEmployee;

@SuppressWarnings("serial")
public class EmployeeInfo extends JFrame {
	
	//features
	Refresh refresh = new Refresh();
	Search search = new Search();
	Clock clock = new Clock();
	Save save = new Save();
	Delete delete = new Delete();

	//features
	private JPanel contentPane;
	private JTable table;


	private JComboBox<Object> comboBoxSelect;
	private JLabel lblClock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeInfo frame = new EmployeeInfo();
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
	Connection connection = null;
	private JTextField textFieldEID;

	private JScrollPane scrollPane;

	private JTextField textFieldSearch;
	private JButton btnSearch;

	
	public EmployeeInfo() {
		
		this.setTitle("Employee Information Management");
		setResizable(false);
		
		//Background and size
		
		Color bgcolor = new Color(5, 150, 163);
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 450);
		contentPane = new JPanel();
		contentPane.setBackground(bgcolor);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Background and size
		
		//hidden textfield
	    textFieldEID = new JTextField();
		textFieldEID.setBounds(10, 20, 0, 0);
		contentPane.add(textFieldEID);
		textFieldEID.setColumns(10);
		//hidden
		
		JButton btnLoadTable = new JButton("Load All Data");
		btnLoadTable.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLoadTable.setForeground(new Color(30, 144, 255));
		btnLoadTable.setBounds(205, 20, 140, 23);
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refresh.refreshTable(connection, table);
			}
		});
		contentPane.add(btnLoadTable);
		
		textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				//Search();
			}
		});
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search.Searchbox(table, comboBoxSelect, connection, textFieldSearch);
			}
		});		
		comboBoxSelect = new JComboBox<Object>();
		comboBoxSelect.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxSelect.setModel(new DefaultComboBoxModel<Object>(new String[] {"EID", "Name", "Surname", "Age"}));
		comboBoxSelect.setBounds(354, 20, 96, 23);
		contentPane.add(comboBoxSelect);
		btnSearch.setBounds(592, 20, 84, 23);
		contentPane.add(btnSearch);
		
		
		textFieldSearch.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldSearch.setBounds(465, 20, 117, 22);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);	
		
		//table
		scrollPane = new JScrollPane();
		scrollPane.setBounds(140, 70, 530, 320);
		scrollPane.getViewport().setBackground(Color.white);
		contentPane.add(scrollPane);
		

		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					int row = table.getSelectedRow();
					String EID = (table.getModel().getValueAt(row, 0).toString());				
					String query = "select * from Employeeinfo where EID = '" + EID + "' ";
					PreparedStatement pst = connection.prepareStatement(query);					
					ResultSet rs = pst.executeQuery();					
					while(rs.next()){
						textFieldEID.setText(rs.getString("EID"));
					}
					pst.close();					
					
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
		});
		// Update button
		final UPemployee update = new UPemployee();
		update.setVisible(false);
		JButton btnUP = new JButton("Update");
		btnUP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!update.isVisible()) {
					update.setVisible(true);
				}
				
			}
			
			
		});
		btnUP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnUP.setBounds(10, 229, 96, 31);
		contentPane.add(btnUP);
		
		// Delete button
		delete.infoDelete(textFieldEID, connection, contentPane, table);
		

		final AddEmployee add = new AddEmployee(table);
		add.setVisible(false);
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				if(!add.isVisible()) {
					add.setVisible(true);
				}
				
			}
		});
		btnNew.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNew.setBounds(10, 109, 96, 31);
		contentPane.add(btnNew);
		
		lblClock = new JLabel("");
		lblClock.setBounds(510, 380, 220, 44);
		lblClock.setForeground(Color.black);
		contentPane.add(lblClock);
		
			
		refresh.refreshTable(connection,table);
		clock.time(lblClock);
	}
	
}
