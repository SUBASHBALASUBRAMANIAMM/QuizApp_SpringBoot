package com.example.QuizApp_SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizAppSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizAppSpringBootApplication.class, args);
		System.out.println("server started");
	}

}
