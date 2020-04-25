package com.stickynotes.sticky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.stickynotes")
public class StickyApplication {

	public static void main(String[] args) {
		SpringApplication.run(StickyApplication.class, args);
	}

}
