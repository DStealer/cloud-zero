package com.cloudzero.arch.xwork;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerUtils;

/**
 *  Delegates to jdk logger,Maps fatal to error
 * Created by lishiwu on 2016/10/10.
 */
public class Slf4jLogger implements Logger {
    private org.slf4j.Logger logger;

    public Slf4jLogger(org.slf4j.Logger logger) {
        this.logger = logger;
    }

    @Override
    public void trace(String msg, String... args) {
        logger.trace(LoggerUtils.format(msg, args));
    }

    @Override
    public void trace(String msg, Throwable ex, String... args) {
        logger.trace(LoggerUtils.format(msg, args), ex);
    }

    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    @Override
    public void debug(String msg, String... args) {
        logger.debug(LoggerUtils.format(msg, args));
    }

    @Override
    public void debug(String msg, Throwable ex, String... args) {
        logger.debug(LoggerUtils.format(msg, args),ex);
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    @Override
    public void info(String msg, String... args) {
        logger.info(LoggerUtils.format(msg, args));
    }

    @Override
    public void info(String msg, Throwable ex, String... args) {
        logger.info(LoggerUtils.format(msg, args),ex);
    }

    @Override
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    @Override
    public void warn(String msg, String... args) {
        logger.warn(LoggerUtils.format(msg, args));
    }

    @Override
    public void warn(String msg, Throwable ex, String... args) {
        logger.warn(LoggerUtils.format(msg, args),ex);
    }

    @Override
    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    @Override
    public void error(String msg, String... args) {
        logger.error(LoggerUtils.format(msg, args));
    }

    @Override
    public void error(String msg, Throwable ex, String... args) {
        logger.error(LoggerUtils.format(msg, args),ex);
    }

    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    @Override
    public void fatal(String msg, String... args) {
        logger.error(LoggerUtils.format(msg, args));
    }

    @Override
    public void fatal(String msg, Throwable ex, String... args) {
        logger.error(LoggerUtils.format(msg, args),ex);
    }

    @Override
    public boolean isFatalEnabled() {
        return logger.isErrorEnabled();
    }
}
