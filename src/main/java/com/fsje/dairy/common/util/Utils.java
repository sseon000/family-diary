package com.fsje.dairy.common.util;

import java.util.Random;

public class Utils {
	private static String init(boolean lowerCheck, int size) {
		Random ran = new Random();
		StringBuffer sb = new StringBuffer();
		int num = 0;

		do {
			num = ran.nextInt(75) + 48;
			if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
				sb.append((char) num);
			} else {
				continue;
			}

		} while (sb.length() < size);
		if (lowerCheck) {
			return sb.toString().toLowerCase();
		}
		return sb.toString();
	}

	public static String getKey(boolean lowerCheck, int size) {
		return init(lowerCheck, size);
	}
}
