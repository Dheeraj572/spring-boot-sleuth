package com.projects.springbootsleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootSleuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSleuthApplication.class, args);
	}

}
