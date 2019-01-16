package com.jixs.hystrix.client;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

public class CacheMain {

    public static void main(String[] args) {
        // 初始化请求上下文
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        // 请求正常的服务
        String key = "cache-key";
        MyCommand c1 = new MyCommand(key);
        MyCommand c2 = new MyCommand(key);
        MyCommand c3 = new MyCommand(key);
        // 输出结果
        System.out.println(c1.execute() + "c1 是否读取缓存: " + c1.isResponseFromCache());
        System.out.println(c2.execute() + "c2 是否读取缓存: " + c2.isResponseFromCache());
        System.out.println(c3.execute() + "c3 是否读取缓存: " + c3.isResponseFromCache());
        // 获取缓存实例
        HystrixRequestCache cache = HystrixRequestCache.getInstance(
                HystrixCommandKey.Factory.asKey("MyCommandKey"),
                HystrixConcurrencyStrategyDefault.getInstance());
        // 清空缓存
        cache.clear(key);
        // 重新执行命令
        MyCommand c4 = new MyCommand(key);
        System.out.println(c4.execute() + "c4 是否读取缓存: " + c4.isResponseFromCache());

        context.shutdown();
    }

    static class MyCommand extends HystrixCommand<String> {

        private String key;

        public MyCommand(String key) {
            super(
                    Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                            .andCommandKey(HystrixCommandKey.Factory.asKey("MyCommand"))
            );
            this.key = key;
        }

        @Override
        protected String run() throws Exception {
            System.out.println("执行命令");
            return "";
        }

        @Override
        protected String getCacheKey() {
            return this.key;
        }
    }
}
