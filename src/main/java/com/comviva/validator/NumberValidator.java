package com.comviva.validator;

import java.util.regex.Pattern;

public class NumberValidator {
	public static final String PATTERN = "^-*[0-9]+(\\.[0-9]+)?$";
	
	/*
	 * Return :
	 * 		* true if word is a whole number or decimal number (positive, negative)
	 * 		* false in  other case
	 */
	public static boolean validate(String word) {
		if (word != null) {
			Pattern pattern = Pattern.compile(PATTERN);
			return pattern.matcher(word).find();
		} else {
			return false;
		}
	}
}
