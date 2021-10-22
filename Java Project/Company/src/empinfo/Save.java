package empinfo;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Save {
	public void infoSave(final JTextField textFieldEID,final JTextField textFieldName ,final JTextField textFieldSurname,final JTextField textFieldAge,final Connection connection,final JPanel contentPane,final JTable table ) {
	
	final Refresh refresh = new Refresh();
	final Reset reset = new Reset();	
	JButton btnSave = new JButton("Save");
	btnSave.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			try {
				String query = "insert into Employeeinfo (EID, Name, SurName, Age) values (?, ?, ?, ?) ";
				PreparedStatement pst = connection.prepareStatement(query);					
				pst.setString(1, textFieldEID.getText());
				pst.setString(2, textFieldName.getText());
				pst.setString(3, textFieldSurname.getText());
				pst.setString(4, textFieldAge.getText());					
				pst.execute();					
				JOptionPane.showMessageDialog(null, "Data Saved");					
				pst.close();					
			} catch (Exception e) {
				e.printStackTrace();
			}
			refresh.refreshTable(connection,table);
			reset.reset(textFieldAge, textFieldAge, textFieldAge, textFieldAge);
		}
	});
	btnSave.setFont(new Font("Times New Roman", Font.BOLD, 18));
	btnSave.setBounds(10, 169, 96, 31);
	contentPane.add(btnSave);
}
	
	public void Savevalue() {
		
	}
}
