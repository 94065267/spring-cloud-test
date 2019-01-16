package com.jixs.hystrix.client;

import com.netflix.hystrix.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author jixs
 * @date 2019/1/16
 */
public class HelloCommand extends HystrixCommand<String> {
    private String url;
    private CloseableHttpClient httpClient;

    public HelloCommand(String url) {
        //调用父类的构造器，设直命令组的key，默认用来作为线程池的key
        super(Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("ExampleCommand"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ExampleThreadPool"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        //命令的超时设置
//                        .withExecutionTimeoutInMilliseconds(11000)
//                        //打开断路器
//                        .withCircuitBreakerForceOpen(true)
                        //如果在10 秒内，有大于10 个请求发生，并且请求的错误率超过50% ，则开启断路器。
                        //配置数据统计时间：
                        .withMetricsRollingStatisticalWindowInMilliseconds(10000)
                        .withCircuitBreakerRequestVolumeThreshold(10)
                        //请求错误率
                        .withCircuitBreakerErrorThresholdPercentage(50)));
        //创建客户端
        this.httpClient = HttpClients.createDefault();
        this.url = url;
    }

    @Override
    protected String run() throws Exception {
//        //调用方法
//        HttpGet httpGet = new HttpGet(url);
//        //服务返回
//        HttpResponse response = httpClient.execute(httpGet);
//        //返回处理结果
//        return EntityUtils.toString(response.getEntity());
        Thread.sleep(800);
        return "";
    }

    /**
     * 实现回退方法
     *
     * @return
     */
    @Override
    protected String getFallback() {
        System.out.println("回退测试");
        return "error";
    }
}
