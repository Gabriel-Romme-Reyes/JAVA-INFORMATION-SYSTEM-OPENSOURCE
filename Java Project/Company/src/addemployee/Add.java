package addemployee;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import empinfo.Refresh;


public class Add {

	
	public void infoAdd(final JTextField textFieldName ,final JTextField textFieldSurname ,final JTextField textFieldAge ,final Connection connection,final JPanel contentPane,final JTable table){
		
	final Refresh refresh = new Refresh();
	JButton btnAdd = new JButton("Add");
	btnAdd.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		
			try {
				String query = "Insert into Employeeinfo(Name,Surname,Age) " + "Values('"+textFieldName.getText()+"','"+textFieldSurname.getText()+ "','"+textFieldAge.getText()+"')";
				PreparedStatement pst = connection.prepareStatement(query);
				pst.execute();
				JOptionPane.showMessageDialog(null, "Data Added");
				pst.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}
			refresh.refreshTable(connection,table);
			}
	});
	btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 18));
	btnAdd.setBounds(10, 169, 96, 31);
	contentPane.add(btnAdd);
	}
	
	public void back(JPanel contentPane,final JFrame addemployee) {
		JButton btnAdd = new JButton("Back");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					addemployee.dispose();

				} catch (Exception e) {
					e.printStackTrace();
				}

				}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnAdd.setBounds(160, 169, 96, 31);
		contentPane.add(btnAdd);
		}
	}
	
	

