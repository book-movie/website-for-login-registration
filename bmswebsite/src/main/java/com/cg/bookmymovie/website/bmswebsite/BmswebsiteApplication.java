package com.cg.bookmymovie.website.bmswebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BmswebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmswebsiteApplication.class, args);
	}
	
	@Bean
	public RestTemplate temp() {
		return new RestTemplate();
		
	}

}

