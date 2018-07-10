package com.linyimin.java.design.pattern.proxy;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 下午2:39 18-7-9
 */
public class RealSubject implements Subject {
    @Override
    public void buyMac() {
        System.out.println("Buy a mac!!!");
    }
}
