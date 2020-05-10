package com.stickynotes.sticky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
@ComponentScan("com.stickynotes")
@EntityScan("com.stickynotes")
@EnableJpaRepositories(basePackages = {"com.stickynotes"})
public class StickyApplication {

	public static void main(String[] args) {
		SpringApplication.run(StickyApplication.class, args);
	}

	
	@Bean
	   public MessageSource messageSource() {
	      ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	      messageSource.setBasename("classpath:content");
	      messageSource.setDefaultEncoding("UTF-8");
	      return messageSource;
	   }
	
	@Bean
	 public LocalValidatorFactoryBean validator(MessageSource messageSource) {
	    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	    bean.setValidationMessageSource(messageSource);
	    return bean;
	 }
}
