package services;

import java.text.SimpleDateFormat;

public class DateService {
	public static String toDate(long timestamp) {
		return new SimpleDateFormat("dd.MM.yyyy hh:mm:ss").format(timestamp);
	}
}
