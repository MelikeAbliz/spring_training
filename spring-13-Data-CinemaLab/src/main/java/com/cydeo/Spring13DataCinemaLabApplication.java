package com.cydeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring13DataCinemaLabApplication {
	public static void main(String[] args) {
		SpringApplication.run(Spring13DataCinemaLabApplication.class, args);
	}

	//	@Bean
//	public MigrateResult migrateResult(DataSource dataSource){
//		return Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
//	}
}
