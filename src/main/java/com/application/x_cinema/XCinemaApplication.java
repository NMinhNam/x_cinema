package com.application.x_cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class XCinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(XCinemaApplication.class, args);
	}

}
