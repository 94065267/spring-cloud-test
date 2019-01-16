package com.jixs.hystrix.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jixs
 * @date 2019/1/16
 */
@RestController
public class MyController {

    @GetMapping("/normalHello")
    @ResponseBody
    public String normalHello(HttpServletRequest request) {
        return "Hello World";
    }

    @GetMapping("/errorHello")
    @ResponseBody
    public String errorHello(HttpServletRequest request) throws Exception {
        // 模拟需要处理10秒
        Thread.sleep(10000);
        return "Error Hello World";
    }
}
