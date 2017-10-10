package com.cloudzero.arch.xwork;

import com.google.protobuf.Any;

/**
 * Created by LiShiwu on 06/26/2017.
 */
public class MessageHolder {

    public Any request;
    public Any response;

    public MessageHolder() {
    }

    public MessageHolder(Any request, Any response) {
        this.request = request;
        this.response = response;
    }
}
