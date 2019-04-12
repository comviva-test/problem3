package com.comviva.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.junit.Test;

import com.comviva.exception.FileProcessException;
import com.comviva.service.FileProcessServiceImpl;

public class FileProcessTest {
	@Test
	public void fileProcessIsNull() {
		FileProcessServiceImpl fp = null;
		assertNull(fp);
	}

	@Test
	public void fileProcessIsNotNull() {
		FileProcessServiceImpl fp = new FileProcessServiceImpl();
		assertNotNull(fp);;
	}
	
//	@Test()
//	public void fileProcessSumAllNumberOfFile() throws FileProcessException {
//		FileProcessServiceImpl fp = new FileProcessServiceImpl();
//		Double sum = fp.processFile("/home/hernan/workspace/eclipse-workspace/comviva/files/test1.txt");
//		assertEquals(new Double(124.20), new Double(new BigDecimal(sum).setScale(2, RoundingMode.HALF_EVEN).doubleValue()));
//	}
//	
//	@Test(expected=FileProcessException.class)
//	public void fileProcessReturnException() throws FileProcessException {
//		FileProcessServiceImpl fp = new FileProcessServiceImpl();
//		Double sum = fp.processFile("/home/hernan/workspace/eclipse-workspace/comviva/files/test2.txt");
//		assertEquals(new Double(124.20), new Double(new BigDecimal(sum).setScale(2, RoundingMode.HALF_EVEN).doubleValue()));
//	}
}
