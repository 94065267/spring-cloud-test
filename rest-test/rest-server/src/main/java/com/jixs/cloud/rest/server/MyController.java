package com.jixs.cloud.rest.server;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MyController {

    /**
     * 查询方法，参数为Person的id
     */
    @RequestMapping(value = "/person/{personId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findPerson(@PathVariable("personId") Integer personId, HttpServletRequest request) {
        Person p = new Person();
        p.setId(personId);
        p.setName("jixs");
        p.setAge(28);
        p.setMessage(request.getRequestURL().toString());
        return p;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "Hello World";
    }

    /**
     * 参数为JSON
     */
    @RequestMapping(value = "/person/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String createPerson(@RequestBody Person person) {
        System.out.println(person.getName() + "-" + person.getAge());
        return "Success, Person Id: " + person.getId();
    }

    /**
     * 参数与返回值均为XML
     */
    @RequestMapping(value = "/person/createXML", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public String createXMLPerson(@RequestBody Person person) {
        System.out.println(person.getName() + "-" + person.getId());
        return "<result><message>success</message></result>";
    }
}
