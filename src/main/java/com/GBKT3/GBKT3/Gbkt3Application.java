package com.GBKT3.GBKT3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Gbkt3Application {
	
	private static final Logger logger = LogManager.getLogger(Gbkt3Application.class);

	public static void main(String[] args) {
		logger.info("Starting GBKT3");
		SpringApplication.run(Gbkt3Application.class, args);
	}
}
