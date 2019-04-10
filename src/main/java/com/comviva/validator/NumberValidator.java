package com.comviva.validator;

import java.util.regex.Pattern;

public class NumberValidator {
	public static final String PATTERN = "^-*[0-9]+(\\.[0-9]+)?$";
	
	public static boolean validate(String word) {
		if (word != null) {
			Pattern pattern = Pattern.compile(PATTERN);
			return pattern.matcher(word).find();
		} else {
			return false;
		}
	}
}
