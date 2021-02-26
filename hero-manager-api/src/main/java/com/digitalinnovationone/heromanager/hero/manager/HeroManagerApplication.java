package com.digitalinnovationone.heromanager.hero.manager;

import com.digitalinnovationone.heromanager.hero.manager.config.DB_Connect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;

@SpringBootApplication
public class HeroManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeroManagerApplication.class, args);
	}

}
