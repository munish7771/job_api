package com.tropogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.tropogo")
public class JobogoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobogoApplication.class, args);
	}

}
