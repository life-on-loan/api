package ru.pet.api_test4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("ru.pet.api_test4")
@EntityScan("ru.pet.api_test4.entities")
public class ApiTest4Application {

	public static void main(String[] args) {
		SpringApplication.run(ApiTest4Application.class, args);
	}

}
