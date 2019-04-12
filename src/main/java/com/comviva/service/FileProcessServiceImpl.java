package com.comviva.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comviva.exception.ComvivaException;
import com.comviva.exception.FileParseException;
import com.comviva.exception.FileProcessException;
import com.comviva.file.FileParse;
import com.comviva.model.Comviva;
import com.comviva.repository.ComvivaPersistance;


@Service
public class FileProcessServiceImpl implements FileProcessService{
		
		@Autowired
		ComvivaPersistance repository;
	
		public void addAllNumbers(String path) throws FileProcessException, ComvivaException {
			FileParse fileParse = new FileParse(path);
			List<Double> numbers;
			try {
				numbers = fileParse.parseFile();
			} catch (FileParseException e) {
				e.printStackTrace();
				throw new FileProcessException("File can't process");
			}
			try {
				Double sum = numbers.stream().mapToDouble(n -> n.doubleValue()).sum();
				Comviva record = new Comviva(path, sum, new Date());
				repository.save(record);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ComvivaException("Error saving register");
			}
		}
}
