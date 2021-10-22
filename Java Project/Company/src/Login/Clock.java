package Login;
import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
public class Clock {

	public void time(final JLabel lblClock){
		
		Thread clock = new Thread()
		{
			public void run(){
				try {
					while(true){
					Calendar cal = new GregorianCalendar();
					int day = cal.get(Calendar.DAY_OF_MONTH);
					int month = cal.get(Calendar.MONTH);
					int year = cal.get(Calendar.YEAR);
					
					int second = cal.get(Calendar.SECOND);
					int minute = cal.get(Calendar.MINUTE);
					int hour = cal.get(Calendar.HOUR);
					
					lblClock.setForeground(Color.white);
					lblClock.setText("Time " + hour +" : "+ minute + " : " + second +" " + month + " / " + day + " / " + year );
					sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}

}

