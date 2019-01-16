package com.jixs.cloud.feign.client.coder;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import feign.jaxb.JAXBContextFactory;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.lang.reflect.Type;

/**
 * @author jixs
 * @date 2019/1/12
 */
public class MyEncoder implements Encoder {
    @Override
    public void encode(Object o, Type type, RequestTemplate requestTemplate) throws EncodeException {
        System.out.println("这是自己写的编码器");
    }
}
