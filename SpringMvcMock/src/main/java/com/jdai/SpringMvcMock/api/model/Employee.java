package com.jdai.SpringMvcMock.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String dept;

}
