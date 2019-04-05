package com.jdai.diveIntoBoot.repository;

import com.jdai.diveIntoBoot.annotation.FirstLevelRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@FirstLevelRepository(value="myFirstLevelRepository")
@Component(value="myFirstLevelRepository")
public class MyFirstLevelRepository {
}
