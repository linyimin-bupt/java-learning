package com.linyimin.java.design.pattern.proxy.dynamicproxy;

/**
 * 趁夜幕还没降临，重新出发
 *
 * @Author: linyimin
 * @Description:
 * @Date: Created in 上午9:53 18-7-10
 */
public class ProxyTest {
    public static void main(String[] args){
        DynamicProxy proxy = new DynamicProxy(RealSubject.class);
        Subject subjectProxy = proxy.getProxy();
        subjectProxy.buyMac();
    }
}
