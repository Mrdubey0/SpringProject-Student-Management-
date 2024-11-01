package com.jsp.config;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.jsp")
public class StudentConfig {
	
	@Bean
	public EntityManager getEM() {
		return Persistence.createEntityManagerFactory("Development").createEntityManager();
	}

}
