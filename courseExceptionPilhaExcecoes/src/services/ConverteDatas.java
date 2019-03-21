package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverteDatas {
	
	
	public Date stringToDate(String data) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.parse(data);
	}
}
