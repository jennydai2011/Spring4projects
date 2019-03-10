package com.jdai.springbootdive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.jdai.springbootdive.web.servlet")
public class SpringbootdiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdiveApplication.class, args);
	}

}
