package com.comviva;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.comviva.dataBase.Database;
import com.comviva.exception.FileProcessException;
import com.comviva.exception.SQLInsertException;
import com.comviva.file.FileProcess;

@SpringBootApplication
public class App {
	
	private static Database db;
	
	@Autowired
	private Database dbAutowired;
	 
	@PostConstruct
	private void init() {
		db = this.dbAutowired;
	}
	 
	public static void main(String[] args) {
		System.out.println("Start Process");
		SpringApplication.run(App.class, args);
		System.out.println("initialize tables");
		db.initializedTables();
		String path = args[0];
		Double sum = null;
		System.out.println("Process File");
		sum = processFile(path);
		System.out.println("Insert Register");
		insertRegister(path, sum, new Date());
		System.out.println("Finish Process");
	}

	private static void insertRegister(String path, Double sum, Date date) {
		try {
			db.insert(path, sum, date);
		} catch (SQLInsertException e) {
			e.printStackTrace();
		}
	}

	private static Double processFile(String path) {
		FileProcess fp = new FileProcess();
		Double sum = null;
		try {
			sum = fp.sumAllNumbers(path);
		} catch (FileProcessException e) {
			e.printStackTrace();
		}
		return sum;
		
	}

}
