package com.vedruna.filmsmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FilmsmicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmsmicroserviceApplication.class, args);
	}

}
