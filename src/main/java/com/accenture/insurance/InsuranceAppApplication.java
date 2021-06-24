package com.accenture.insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.accenture.insurance")
public class InsuranceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceAppApplication.class, args);
	}
	

	
}
