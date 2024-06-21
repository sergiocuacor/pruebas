package com.msclientecontactos.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages = {"com.msclientecontactos.controller"})
@SpringBootApplication
public class MsClienteContactosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsClienteContactosApplication.class, args);
	}

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
	
}
