package empinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class Search {
	public void Searchbox(JTable table,JComboBox<Object> comboBoxSelect,Connection connection,JTextField textFieldSearch){
		try {
			String selection = (String)comboBoxSelect.getSelectedItem();
            String query = "select EID, Name, Surname, Age from Employeeinfo where " + selection +" = ? ";
			PreparedStatement pst = connection.prepareStatement(query);
			
			pst.setString(1, textFieldSearch.getText());
			ResultSet rs = pst.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

