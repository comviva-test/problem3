package com.comviva.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NumberValidatorTest {
	
	@Test
	public void wordIsANumberTest() {
		String word = "1234";
		assertTrue(NumberValidator.validate(word));
	}
	
	@Test
	public void wordIsADoubleTest() {
		String word = "1234.23";
		assertTrue(NumberValidator.validate(word));
	}
	
	@Test
	public void wordIsNotANumberTest() {
		String word = "word";
		assertFalse(NumberValidator.validate(word));
	}
	
	@Test
	public void nullIsNotANumberThrowNullExceptionTest() {
		String word = null;
		assertFalse(NumberValidator.validate(word));
	}
}
