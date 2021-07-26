package com.hengxin.rpc;

import org.apache.hadoop.ipc.ProtocolSignature;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author: zhouhengxin
 * @create: 2021-07-25 23:57
 **/
public class MyInterfaceImpl implements MyInterface {

    //重载的方法，用于获取自定义的协议版本号
    public long getProtocolVersion(String protocol, long clientVersion) {
        return MyInterface.versionID;
    }

    //重载的方法，用于获取协议签名
    public ProtocolSignature getProtocolSignature(String protocol, long clientVersion, int hashcode) {
        return new ProtocolSignature(MyInterface.versionID, null);
    }

    private static HashMap<Long, String> hashMap = new HashMap<Long, String>() {
        {
            put(20210123456789L, "心心");
            put(20210735010242L, "周恒新");
        }
    };

    @Override
    public String echo(String value) throws IOException {
        return value;
    }

    @Override
    public String findName(long studentID) {
        return MyInterfaceImpl.hashMap.get(studentID);
    }
}
