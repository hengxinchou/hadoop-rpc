package com.hengxin.rpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;

/**
 * @author: zhouhengxin
 * @create: 2021-07-26 00:03
 **/
public class Server {
    public static void main(String[] args) {
        RPC.Builder builder = new RPC.Builder(new Configuration());
        builder.setBindAddress("127.0.0.1")
                .setPort(12345)
                .setProtocol(MyInterface.class)
                .setInstance(new MyInterfaceImpl());
        try {
            RPC.Server server = builder.build();
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
