package com.jdai.SpringSecurityDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1. add security starter in pom.xml spring-boot-starter-security
 * 2. create a Security config class
 * @EnableWebSecurity extends WebSecurityConfigurerAdapter
 */
@SpringBootApplication
public class SpringSecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);
	}

}
