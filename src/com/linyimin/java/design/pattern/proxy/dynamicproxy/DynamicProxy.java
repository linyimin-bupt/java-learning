package com.linyimin.java.design.pattern.proxy.dynamicproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 趁夜幕还没降临，重新出发
 *
 * @Author: linyimin
 * @Description:
 * @Date: Created in 上午9:40 18-7-10
 */
public class DynamicProxy implements InvocationHandler {
    private final Class<?> serviceClass;

    public DynamicProxy(Class<?> serviceClass) {
        this.serviceClass = serviceClass;
    }

    public <T> T getProxy(){
        return (T) Proxy.newProxyInstance(serviceClass.getClassLoader(), serviceClass.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("办事之前先收取点费用");
        System.out.println("开始办事");
        Object result = method.invoke(serviceClass.newInstance(), args);
        System.out.println("办完事了");
        return result;
    }
}
