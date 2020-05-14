package com.stickynotes.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
/* @Import annotation is used to import defined configuration files */
/* If there are multiple configuration files then use like this @Import({ Module1Config.class, Module2Config.class }) */
/* To enable auto creation of service beans */
import org.springframework.web.client.RestTemplate;

@Configuration
@Import(DatabaseConfig.class) 
public class AppConfig {
	
	@Bean @LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
}

}