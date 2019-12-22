package io.sge.blog.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String getCurrentDate(String pattern) {

		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.format(today);
	}
}
