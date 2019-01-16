package com.jixs.cloud.health.provider.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    public Person() {
    }

    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    private Integer id;
    private String name;
    private Integer age;
    private String message;
}
