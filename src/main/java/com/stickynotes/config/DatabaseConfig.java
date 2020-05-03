package com.stickynotes.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource("classpath:application.properties") 
public class DatabaseConfig {

	@Bean
	public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();	 
	    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	    dataSource.setUsername("root");
	    dataSource.setPassword("Adivavstirtha");
	    dataSource.setUrl("jdbc:mysql://database-1.cx2xcf3xljdq.ap-south-1.rds.amazonaws.com:3306/telusko"); 
	     
	    return dataSource;
	}
	
	/* EntityManagerFactory bean definition */
	 @Bean
	   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	      LocalContainerEntityManagerFactoryBean em 
	        = new LocalContainerEntityManagerFactoryBean();
	      em.setDataSource(dataSource());
	      em.setPackagesToScan(new String[] { "com.stickynotes" });
	 
	      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	      em.setJpaVendorAdapter(vendorAdapter);
	      em.setJpaProperties(additionalProperties());
	 
	      return em;
	   }
	/* TransactionManager bean definition */
	
	@Bean
	public PlatformTransactionManager transactionManager() {
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
	 
	    return transactionManager;
	}
	/* Setting required hibernate properties */
		Properties additionalProperties() {
	    Properties properties = new Properties();
	    properties.setProperty("hibernate.hbm2ddl.auto", "update");
	    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	        
	    return properties;
	}
		
		@Bean
		public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
		    return new PersistenceExceptionTranslationPostProcessor();
		}
	
}