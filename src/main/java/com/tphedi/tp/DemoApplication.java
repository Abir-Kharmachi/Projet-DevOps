package com.tphedi.tp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication(scanBasePackages= "com.tphedi.tp")
public class DemoApplication {

	@Bean
	public org.springframework.web.client.RestTemplate restTemplate(){
		return new org.springframework.web.client.RestTemplate();
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
