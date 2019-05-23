package com.jdai.SpringThymeleafPagination;

import com.jdai.SpringThymeleafPagination.entities.Country;
import com.jdai.SpringThymeleafPagination.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringThymeleafPaginationApplication implements CommandLineRunner {

    @Autowired
    private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringThymeleafPaginationApplication.class, args);
	}


	@Override
    public void run(String... args) throws Exception {
	    countryRepository.save(new Country("Earth", "world"));
        countryRepository.save(new Country("China", "beijing"));
        countryRepository.save(new Country("Germany", "Berlin"));
        countryRepository.save(new Country("USA", "Washington"));
        countryRepository.save(new Country("Russia", "Moscow"));
        countryRepository.save(new Country("Namibia", "Windhoek"));
        countryRepository.save(new Country("Canada", "Ottawa"));
        countryRepository.save(new Country("Egypt", "Cairo"));
        countryRepository.save(new Country("India", "New delhi"));
    }
}
