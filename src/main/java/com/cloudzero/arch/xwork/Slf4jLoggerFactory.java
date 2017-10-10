package com.cloudzero.arch.xwork;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * 使用Slf4j替代Xwork的日志
 * Created by lishiwu on 2016/10/10.
 */
public class Slf4jLoggerFactory extends LoggerFactory {
    @Override
    protected Logger getLoggerImpl(Class<?> cls) {
        return new Slf4jLogger(org.slf4j.LoggerFactory.getLogger(cls));
    }

    @Override
    protected Logger getLoggerImpl(String name) {
        return new Slf4jLogger(org.slf4j.LoggerFactory.getLogger(name));
    }
}
