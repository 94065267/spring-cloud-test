package com.jixs.cloud.rest.client;

import org.restlet.data.MediaType;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import java.io.IOException;
import java.util.Map;

/**
 * @author jixs
 * @date 2019/1/12
 */
public class RestletClient {
    public static void main(String[] args) throws IOException {
        ClientResource clientResource = new ClientResource("http://localhost:8080/person/1");
        Representation representation = clientResource.get(MediaType.APPLICATION_JSON);
        JacksonRepresentation jacksonRepresentation = new JacksonRepresentation(representation, Map.class);
        Map result = (Map) jacksonRepresentation.getObject();
        // 输出结果
        System.out.println("结果返回result：" + result);
    }
}
