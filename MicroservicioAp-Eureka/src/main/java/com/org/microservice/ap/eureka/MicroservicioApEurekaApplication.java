package com.org.microservice.ap.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MicroservicioApEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioApEurekaApplication.class, args);
	}

}
