package empinfo;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;

public class Delete {

	
	public void infoDelete(final JTextField textFieldEID ,final Connection connection,final JPanel contentPane,final JTable table ){
	
	final Refresh refresh = new Refresh();
	JButton btnDelete = new JButton("Delete");
	btnDelete.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			int action = JOptionPane.showConfirmDialog(null, "Do you want to delete!", "Delete", JOptionPane.YES_NO_OPTION);
			if(action == 0){
			try {
				String query = "delete from Employeeinfo where EID = '" + textFieldEID.getText() + "' ";
				PreparedStatement pst = connection.prepareStatement(query);
				pst.execute();
				JOptionPane.showMessageDialog(null, "Data Deleted");
				pst.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}
			refresh.refreshTable(connection,table);

			}
		}
	});
	btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 18));
	btnDelete.setBounds(10, 169, 96, 31);
	contentPane.add(btnDelete);
	}
}
