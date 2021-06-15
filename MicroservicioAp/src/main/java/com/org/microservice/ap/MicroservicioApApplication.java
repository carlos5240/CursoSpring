package com.org.microservice.ap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.org.microservice.commons.alumnos.model.entity"})
public class MicroservicioApApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioApApplication.class, args);
	}

}
