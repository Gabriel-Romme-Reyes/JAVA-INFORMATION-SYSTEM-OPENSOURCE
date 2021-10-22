package empinfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;

public class Refresh {
	public void refreshTable(final Connection connection,final JTable table){
		
		try {
			String query = "select EID, Name, Surname, Age from Employeeinfo";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
