package io.sge.blog.common.util;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

	/**
	 * @param size
	 * @param padChar
	 * @return String
	 */
	public static String getFixedRandomStringId(int size, char padChar) {
		int randomNum = (int) Math.round(1000 * Math.random());
		return StringUtils.leftPad(String.valueOf(randomNum), size, padChar);
	}
}
