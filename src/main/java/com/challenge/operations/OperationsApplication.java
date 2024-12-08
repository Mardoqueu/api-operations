package com.challenge.operations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The OperationsApplication class serves as the entry point for the Spring Boot application.
 * It is annotated with @SpringBootApplication, which is a convenience annotation that adds
 * the following annotations:
 * - @Configuration: Tags the class as a source of bean definitions for the application context.
 * - @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings,
 *   other beans, and various property settings.
 * - @ComponentScan: Tells Spring to look for other components, configurations, and services
 *   in the specified package, allowing it to find the controllers.
 *
 * The main method uses Spring Boot's SpringApplication.run() method to launch the application.
 */
@SpringBootApplication
public class OperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OperationsApplication.class, args);
	}

}
