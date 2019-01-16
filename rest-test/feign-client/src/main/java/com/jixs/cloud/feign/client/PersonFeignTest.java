package com.jixs.cloud.feign.client;


import feign.Feign;
import feign.Logger;
import feign.jaxrs.JAXRSContract;

/**
 * Person服务的运行主类
 *
 * @author jixs
 */
public class PersonFeignTest {

    public static void main(String[] args) {
        //JSON
        //解码器
//		PersonClient personService = Feign.builder()
//				//解码器：会对服务响应的内容进行处理
//				.decoder(new GsonDecoder())
//				.target(PersonClient.class, "http://localhost:8080/");
//		PersonClient.Person person = personService.findById(2);
//		System.out.println("person = "+ person);


        //编码器
//        PersonClient personClient = Feign.builder()
//                //向服务发送请求的过程中，有些情况需要对请求的内容进行处理。例如服务端发布的
//                //服务接收的是JSON 格式的参数，而客户端使用的是对象，这种情况就可以使用编码器，
//                //将对象转换为JSON 字符串。
////                .encoder(new MyEncoder())
//                .encoder(new GsonEncoder())
//                .target(PersonClient.class, "http://localhost:8080/");
//        PersonClient.Person person = new PersonClient.Person();
//        person.id = 1;
//        person.name = "jixs";
//        person.age = 28;
//        String response = personClient.createPerson(person);
//        System.out.println(response);

        //XML
//        JAXBContextFactory contextFactory = new JAXBContextFactory.Builder().build();
//        PersonClient personClient = Feign.builder()
//                .encoder(new JAXBEncoder(contextFactory))
//                .decoder(new JAXBDecoder(contextFactory))
//                .target(PersonClient.class, "http://localhost:8080/");
//        PersonClient.Person person = new PersonClient.Person();
//        person.id = 1;
//        person.name = "jixs";
//        person.age = 28;
//        PersonClient.Result response = personClient.createXMLPerson(person);
//        System.out.println(response);


        //自己写的客户端测试
        // 获取服务接口
//        PersonClient personClient = Feign.builder()
//                .encoder(new GsonEncoder())
//                //自己洗的客户端
//                .client(new MyFeignClient())
//                .target(PersonClient.class, "http://localhost:8080/");
//        // 请求Hello World接口
//        String result = personClient.sayHello();
//        System.out.println("    接口响应内容：" + result);

        //注解方式测试
        // 获取服务接口
        PersonClient personClient = Feign.builder()
                .logLevel(Logger.Level.FULL)
                .logger(new Logger.JavaLogger().appendToFile("logs/http.log"))
                .contract(new JAXRSContract())
                .target(PersonClient.class, "http://localhost:8080/");
        // 请求Hello World接口
        String result = personClient.sayHello();
        System.out.println("    接口响应内容：" + result);

    }
}
