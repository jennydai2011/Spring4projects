package com.jdai.SpringThymeleafPagination.repositories;

import com.jdai.SpringThymeleafPagination.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
