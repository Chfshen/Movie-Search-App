package com.changfeng.movieweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MovieWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieWebApplication.class, args);
	}

}
