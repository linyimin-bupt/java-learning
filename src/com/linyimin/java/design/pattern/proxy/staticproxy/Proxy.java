package com.linyimin.java.design.pattern.proxy.staticproxy;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 下午2:40 18-7-9
 */
public class Proxy implements Subject {
    private RealSubject realSubject;
    public Proxy(RealSubject realSubject){
        this.realSubject = realSubject;
    }
    @Override
    public void buyMac() {
        // 完成代理操作
        this.realSubject.buyMac();
        // 完成相关收尾工作
        this.wrapMac();

    }

    public void wrapMac(){
        System.out.println("包装Mac");
    }
}
