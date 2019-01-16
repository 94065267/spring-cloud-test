package com.jixs.cloud.feign.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import lombok.Data;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Person客户端服务类
 *
 * @author jixs
 */
public interface PersonClient {

    //    @RequestLine("GET /person/{personId}")
    @GET
    @Path("/person/{personId}")
    Person findById(@Param("personId") Integer personId);

    //    @RequestLine("POST /person/create")
    @POST
    @Path("/person/create")
    @Headers("Content-Type: application/json")
    String createPerson(Person person);

    //    @RequestLine("POST /person/createXML")
    @POST
    @Path("/person/createXML")
    @Headers("Content-Type: application/xml")
    Result createXMLPerson(Person person);

    //    @RequestLine("GET /hello")
    //使用注解方式
    @GET
    @Path("/hello")
    String sayHello();

    @XmlRootElement
    class Person {
        @XmlElement
        Integer id;
        @XmlElement
        String name;
        @XmlElement
        Integer age;
        @XmlElement
        String message;

        @XmlTransient
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @XmlTransient
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @XmlTransient
        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @XmlTransient
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

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

    @XmlRootElement
    class Result {
        @XmlElement
        String message;

        @XmlTransient
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "{"
                    + "\"message\":\"" + message + "\""
                    + "}";
        }
    }
}
