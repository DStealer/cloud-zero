package com.cloudzero.arch.ice;

import com.cloudzero.arch.pb.CloudRequest;
import com.cloudzero.arch.pb.CloudResponse;
import com.google.protobuf.Any;
import org.testng.annotations.Test;

/**
 * Created by LiShiwu on 06/22/2017.
 */
public class ClientConnectorManagerTest {
    @Test
    public void test01() throws Exception {
        CloudRequest.Builder builder = CloudRequest.newBuilder();
        builder.setNgLabel("MockNg").setNgVersion("0.0.1").setAction("TestAC").setActVersion("0.0.1");
        builder.setBody(Any.pack(builder.build()));
        CloudResponse response = ClientConnectorManager.invoke(builder.build());
        System.out.println(response.getReturnCode());
        System.out.println(response.getDescription());
        System.out.println("body:");
        if (response.hasBody()) {
            System.out.println(response.getBody());
        }
    }

    @Test
    public void test02() throws Exception {
        for (int i = 1000; i > 0; i--) {
            this.test01();
        }
    }
}