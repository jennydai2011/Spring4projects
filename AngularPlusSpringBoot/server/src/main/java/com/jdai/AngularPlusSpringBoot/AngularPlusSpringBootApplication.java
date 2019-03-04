package com.jdai.AngularPlusSpringBoot;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class AngularPlusSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularPlusSpringBootApplication.class, args);
	}

	@Bean
	ApplicationRunner init(com.jdai.AngularPlusSpringBoot.repository.CarRepository repository) {
		return args -> {
			Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
					"AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> {
				repository.save(new com.jdai.AngularPlusSpringBoot.model.Car(name));
			});
			repository.findAll().forEach(System.out::println);
		};
	}
}

