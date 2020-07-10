package com.infinity.bank.api.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {
	
	public static Boolean isNull(Object object) {
		return object == null;
	}
	
    public static String getCurrentTimestamp() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        return dateFormat.format(Calendar.getInstance().getTime());
    }
}
