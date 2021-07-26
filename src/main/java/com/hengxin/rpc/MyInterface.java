package com.hengxin.rpc;

import com.jcraft.jsch.IO;
import org.apache.hadoop.ipc.VersionedProtocol;

import java.io.IOException;

public interface MyInterface extends VersionedProtocol {
    public static final long versionID = 1L;

    String echo(String value) throws IOException;

    String findName(long studentID) throws IOException;
}
