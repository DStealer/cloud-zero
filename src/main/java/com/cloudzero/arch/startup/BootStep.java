package com.cloudzero.arch.startup;

/**
 * 启动顺序
 * Created by LiShiwu on 06/27/2017.
 */
public interface BootStep {
    /**
     * 加载配置之前
     *
     * @param args
     * @throws Exception
     */
    void beforeLoadConfig(String[] args) throws Exception;

    /**
     * 加载配置
     *
     * @param args
     * @throws Exception
     */
    void loadConfig(String[] args) throws Exception;

    /**
     * 加载配置之前
     *
     * @param args
     * @throws Exception
     */
    void afterLoadConfig(String[] args) throws Exception;

    /**
     * 初始化Xwork之前
     *
     * @param args
     * @throws Exception
     */
    void beforeInitXwork(String[] args) throws Exception;

    /**
     * 初始化Xwork
     *
     * @param args
     * @throws Exception
     */
    void initXwork(String[] args) throws Exception;

    /**
     * 初始化Xwork之后
     *
     * @param args
     * @throws Exception
     */
    void afterInitXwork(String[] args) throws Exception;

    /**
     * 初始化Ice Server之前
     *
     * @param args
     * @throws Exception
     */
    void beforeInitServer(String[] args) throws Exception;

    /**
     * 初始化Ice Server
     *
     * @param args
     * @throws Exception
     */
    void initServer(String[] args) throws Exception;

    /**
     * 初始化Ice Server之后
     *
     * @param args
     * @throws Exception
     */
    void afterInitServer(String[] args) throws Exception;
}
