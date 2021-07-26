package com.hengxin.rpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author: zhouhengxin
 * @create: 2021-07-26 00:18
 **/
public class Client {

    public static void main(String[] args) {
        try {
            MyInterface proxy = RPC.getProxy(MyInterface.class, MyInterface.versionID, new InetSocketAddress(12345), new Configuration());
            long studentID = 20210123456789L;
            String name = proxy.findName(studentID);
            System.out.println("studentID " + studentID + " is " + name);

            long studentID2 = 20210000000000L;
            String name2 = proxy.findName(studentID2);
            System.out.println("studentID " + studentID2 + " is " + name2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
