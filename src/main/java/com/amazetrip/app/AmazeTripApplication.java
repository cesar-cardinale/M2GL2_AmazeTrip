package com.amazetrip.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.amazetrip" })
@EnableJpaRepositories(basePackages = { "com.amazetrip" })
@EntityScan(basePackages = { "com.amazetrip" })
public class AmazeTripApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazeTripApplication.class, args);
	}

}
