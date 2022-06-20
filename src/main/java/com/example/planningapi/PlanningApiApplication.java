package com.example.planningapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlanningApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanningApiApplication.class, args);
		System.out.println("----- Successfully connected with MySQL database! -----");
	}

}
