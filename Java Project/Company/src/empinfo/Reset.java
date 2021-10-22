package empinfo;
import javax.swing.*;
public class Reset {


	public void reset( JTextField textFieldEID,JTextField textFieldName,JTextField textFieldSurname,JTextField textFieldAge) {
	textFieldEID.setText("");
	textFieldName.setText("");
	textFieldSurname.setText("");
	textFieldAge.setText("");
}
}