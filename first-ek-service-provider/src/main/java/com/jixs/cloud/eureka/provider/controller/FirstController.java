package com.jixs.cloud.eureka.provider.controller;

import com.jixs.cloud.eureka.provider.dto.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jixs
 * @date 2019/1/3
 */
@RestController
public class FirstController {
    @RequestMapping(value = "/person/{personId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findPerson(@PathVariable("personId") Integer personId) {
        Person p = new Person(personId, "jixs", 28);
        return p;
    }
}
