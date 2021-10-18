package com.amazetrip.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = AmazeTripApplication.class)
@EntityScan(basePackageClasses = AmazeTripApplication.class)
public class AmazeTripApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazeTripApplication.class, args);
	}

}
