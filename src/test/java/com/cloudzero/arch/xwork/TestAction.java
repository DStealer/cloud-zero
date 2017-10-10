package com.cloudzero.arch.xwork;

import com.cloudzero.arch.pb.CloudRequest;
import com.cloudzero.arch.pb.CloudResponse;
import com.cloudzero.arch.pb.Void;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lishiwu on 2016/10/9.
 */
public class TestAction extends CloudAction<CloudRequest, Void> {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestAction.class);

    @Override
    protected Void internalExec() throws CloudException {
        LOGGER.info("Receive  message :{}", this.request);
        CloudResponse.Builder builder = CloudResponse.newBuilder();
        return Void.getDefaultInstance();
    }
}
