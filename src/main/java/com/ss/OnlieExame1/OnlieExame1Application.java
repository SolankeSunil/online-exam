 package com.ss.OnlieExame1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EntityScan("com")
@ComponentScan("com")
public class OnlieExame1Application {
	public static void main(String[] args) {
		SpringApplication.run(OnlieExame1Application.class, args);
		
	}
}
