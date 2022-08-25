package com.sparta.week04_assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Week04AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(Week04AssignmentApplication.class, args);
	}

}
