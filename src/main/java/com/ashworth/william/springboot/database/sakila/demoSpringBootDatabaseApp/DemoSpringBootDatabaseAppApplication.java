package com.ashworth.william.springboot.database.sakila.demoSpringBootDatabaseApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DemoSpringBootDatabaseAppApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(DemoSpringBootDatabaseAppApplication.class, args);
	}
}
