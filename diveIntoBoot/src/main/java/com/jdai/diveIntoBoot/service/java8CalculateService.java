package com.jdai.diveIntoBoot.service;

import org.springframework.context.annotation.Profile;

import java.util.stream.Stream;

@Profile("Java8")
public class java8CalculateService implements CalculateService {

    @Override
    public Integer sum(Integer... values) {
        int sum = Stream.of(values).reduce(0, Integer::sum);
        return sum;
    }

    public static void main(String[] args) {
        CalculateService calculateService = new Java7CalculateService();
        int actual = calculateService.sum(1, 2, 3,4,5,6,7,8,9,10);
        System.out.println(actual);


    }
}
