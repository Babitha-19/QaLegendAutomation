package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility { //to find currentdate inbuilt class
	public static String getCurrentDate() {
		
		Date date=new Date();
		SimpleDateFormat sd= new SimpleDateFormat("YYYY-MM-DD");
		String formattedDate=sd.format(date);
		return formattedDate;
	}

}
