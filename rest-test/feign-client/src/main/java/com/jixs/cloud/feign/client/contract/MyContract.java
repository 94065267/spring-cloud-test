package com.jixs.cloud.feign.client.contract;

import feign.Contract;
import feign.MethodMetadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author jixs
 * @date 2019/1/12
 */
public class MyContract extends Contract.BaseContract {
    /**
     * 处理类注解
     * @param methodMetadata
     * @param aClass
     */
    @Override
    protected void processAnnotationOnClass(MethodMetadata methodMetadata, Class<?> aClass) {

    }

    /**
     * 处理方法注解
     * @param methodMetadata
     * @param annotation
     * @param method
     */
    @Override
    protected void processAnnotationOnMethod(MethodMetadata methodMetadata, Annotation annotation, Method method) {
       System.out.println("这是自定义的方法注解实现");
        if (MyUrlAnnotation.class.isInstance(annotation)) {
            MyUrlAnnotation myUrlAnnotation = method.getAnnotation(MyUrlAnnotation.class);
            //获取配置的HTTP 方法
            String myMethod = myUrlAnnotation.method();
            String myUrl = myUrlAnnotation.url();
            methodMetadata.template().method(myMethod);
            methodMetadata.template().append(myUrl);
        }
    }

    /**
     * 处理参数注解
     * @param methodMetadata
     * @param annotations
     * @param i
     * @return
     */
    @Override
    protected boolean processAnnotationsOnParameter(MethodMetadata methodMetadata, Annotation[] annotations, int i) {
        return false;
    }
}
