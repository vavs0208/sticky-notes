package com.stickynotes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
/* @Import annotation is used to import defined configuration files */
/* If there are multiple configuration files then use like this @Import({ Module1Config.class, Module2Config.class }) */
/* To enable auto creation of service beans */

@Configuration
@Import(DatabaseConfig.class) 
public class AppConfig {

}