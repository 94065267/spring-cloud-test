package com.jixs.hystrix.client;


/**
 * @author jixs
 * @date 2019/1/16
 */
public class HystrixClientTest {
    public static void main(String[] args) {
//        HelloCommand helloCommand = new HelloCommand("http://127.0.0.1:8080/normalHello");
//        HelloCommand helloCommand = new HelloCommand("http://127.0.0.1:8080/errorHello");
//        System.out.println(helloCommand.execute());
        for (int i = 0; i < 15; i++) {
            HelloCommand helloCommand = new HelloCommand("http://127.0.0.1:8080/normalHello");
            helloCommand.execute();
            if (helloCommand.isCircuitBreakerOpen()) {
                System.out.println("断路器被打开，执行第" + (i + 1) + "个命令");
            }
        }
    }
}
