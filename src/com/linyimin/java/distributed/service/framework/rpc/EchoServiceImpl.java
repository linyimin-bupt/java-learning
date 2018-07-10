package com.linyimin.java.distributed.service.framework.rpc;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 上午10:24 18-7-9
 */
public class EchoServiceImpl implements EchoService{
    @Override
    public String echo(String ping) {
        return ping != null ? ping + " --> I am OK." : "I am OK.";
    }
}
