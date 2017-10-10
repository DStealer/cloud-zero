package com.cloudzero.arch.ice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lishiwu on 2016/10/9.
 */
public class Slf4jIceLogger implements Ice.Logger {
    private static final Logger LOGGER = LoggerFactory.getLogger(Slf4jIceLogger.class);

    @Override
    public void print(String message) {
        LOGGER.info(message);
    }

    @Override
    public void trace(String category, String message) {
        LOGGER.debug(message);
    }

    @Override
    public void warning(String message) {
        LOGGER.warn(message);
    }

    @Override
    public void error(String message) {
        LOGGER.error(message);
    }

    @Override
    public String getPrefix() {
        return LOGGER.getName();
    }

    @Override
    public Ice.Logger cloneWithPrefix(String prefix) {
        if (LOGGER.getName().equals(prefix)) {
            return new Slf4jIceLogger();
        }
        return null;
    }
}
