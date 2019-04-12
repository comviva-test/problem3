package com.comviva.service;

import com.comviva.exception.ComvivaException;
import com.comviva.exception.FileProcessException;

public interface FileProcessService {
	
	public void addAllNumbers(String path) throws FileProcessException, ComvivaException;
}
