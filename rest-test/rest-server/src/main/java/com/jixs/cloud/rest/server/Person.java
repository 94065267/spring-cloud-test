package com.jixs.cloud.rest.server;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private String message;

    @Override
    public String toString() {
        return "{"
                + "\"id\":\"" + id + "\""
                + ", \"name\":\"" + name + "\""
                + ", \"age\":\"" + age + "\""
                + ", \"message\":\"" + message + "\""
                + "}";
    }
}
