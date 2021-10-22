package Login;

import javax.swing.*;
import java.sql.Connection;

import java.sql.DriverManager;



public class sqliteConnection {
	static Connection con = null;

	public static Connection dbConnector(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/infomanage","root","");
			//JOptionPane.showMessageDialog(null, "Connection Successful!");
			return con;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		return null;
	}
	

}
