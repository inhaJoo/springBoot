package com.example.ch1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Ch1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ch1Application.class, args);
	}

	@RequestMapping("/")
	public String hello() {
		return "Hello Spring boot";
	}
}
