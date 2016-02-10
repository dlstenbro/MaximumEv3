package remoteDragRacer;

import java.util.Calendar;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateTime {
	
	String dateValue;
	String calTime;
	
	public DateTime(){
		
		   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		   DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		   //get current date time with Date()
		   Date date = new Date();
		   dateValue = dateFormat.format(date);
		  
		   //get current date time with Calendar()
		   Calendar cal = Calendar.getInstance();
		   calTime = timeFormat.format(cal.getTime());
		   System.out.println(timeFormat.format(cal.getTime()));

	}
	
	public String getDate(){
		return dateValue;
	}
	
	public String getCalTime(){
		return calTime;
	}
	
}

