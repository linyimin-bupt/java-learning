package com.linyimin.java.design.pattern.proxy.staticproxy;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 下午2:43 18-7-9
 */
public class ProxyTest {
    public static void main(String[] args){
        Proxy proxy = new Proxy(new RealSubject());
        proxy.buyMac();
    }
}
