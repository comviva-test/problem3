package com.comviva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class App extends SpringBootServletInitializer{
	
//	private static Database db;
//	
//	@Autowired
//	private Database dbAutowired;
//	 
//	@PostConstruct
//	private void init() {
//		db = this.dbAutowired;
//	}
	 
	public static void main(String[] args) {
		System.out.println("Start Process");
		SpringApplication.run(App.class, args);
		System.out.println("initialize tables");
//		db.initializedTables();
	}

}
