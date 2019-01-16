package com.jixs.cloud.ekcluster.provider.controller;

import com.jixs.cloud.ekcluster.provider.dto.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jixs
 * @date 2019/1/3
 */
@RestController
public class ClusterProviderController {
    @RequestMapping(value = "/person/{personId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findPerson(@PathVariable("personId") Integer personId, HttpServletRequest request) {

        Person p = new Person(personId, "jixs", 28);
        p.setMessage(request.getRequestURL().toString());
        return p;
    }
}
