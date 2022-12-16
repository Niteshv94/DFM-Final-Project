/**
 * 
 */
package com.dfm.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Nitesh
 *
 */
public class Helper {
	
	public static String getCurrentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

}
