package update;
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
public class Update {
	
	public void infoUpdate(final JTextField textFieldEID,final JTextField textFieldName ,final JTextField textFieldSurname,final JTextField textFieldAge,final Connection connection,final JPanel contentPane,final JTable table ){
		
	final Refresh refresh = new Refresh();
	JButton btnUpdate = new JButton("Update");
	btnUpdate.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			try {
				String query = "update Employeeinfo set EID = '" + textFieldEID.getText() + "', Name = '" + textFieldName.getText() + "', Surname = '" + textFieldSurname.getText() +"', Age = '" + textFieldAge.getText() + "' where EID = '" + textFieldEID.getText() + "'";
				PreparedStatement pst = connection.prepareStatement(query);									
				pst.execute();				
				JOptionPane.showMessageDialog(null, "Data Updated");	
				pst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			refresh.refreshTable(connection,table);

		}
	});
	btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
	btnUpdate.setBounds(10, 229, 96, 31);
	contentPane.add(btnUpdate);
}
	
	public void back(JPanel contentPane,final JFrame UPemployee) {
		JButton btnAdd = new JButton("Back");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					UPemployee.dispose();

				} catch (Exception e) {
					e.printStackTrace();
				}

				}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnAdd.setBounds(160, 229, 96, 31);
		contentPane.add(btnAdd);
		}
}
