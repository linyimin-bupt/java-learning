package com.linyimin.java.distributed.service.framework.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @Author: linyimin
 * @Description:
 * @Date: Created in 上午11:33 18-7-9
 */
public class RpcTest {
    public static void main(String [] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    RpcExporter.exporter("localhost", 8080);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        RpcImporter<EchoService> importer = new RpcImporter<>();
        EchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8080));
        System.out.println(echo.echo("Rpc"));
    }
}
