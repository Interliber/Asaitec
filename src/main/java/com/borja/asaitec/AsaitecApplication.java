package com.borja.asaitec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AsaitecApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsaitecApplication.class, args);
	}

}
