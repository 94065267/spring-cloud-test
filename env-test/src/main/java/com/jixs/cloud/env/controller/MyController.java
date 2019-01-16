package com.jixs.cloud.env.controller;

import com.jixs.cloud.env.dto.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author jixs
 * @date 2019/1/2
 */
@RestController
public class MyController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping(value = "/person/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findPerson(@PathVariable("personId") Integer personId) {
        Person p =new Person() ;
        p.setId(personId);
        p. setName ("jixs" ) ;
        p.setAge(28) ;
        return p;
    }
}
