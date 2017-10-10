package com.cloudzero.arch.ice;

import com.cloudzero.arch.pb.CloudRequest;
import com.cloudzero.arch.pb.CloudResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lishiwu on 2016/10/9.
 */
public class ClientConnectorManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientConnectorManager.class);
    //Client容器
    private static final ConcurrentHashMap<String, ClientConnector> CONCURRENT_HASH_MAP = new ConcurrentHashMap<>();

    private ClientConnectorManager() {
    }

    /**
     * 发送请求
     *
     * @param request
     * @return
     * @throws Exception
     */
    public static CloudResponse invoke(CloudRequest request) throws Exception {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Invoke request to ngLabel:{},ngVersion:{}", request.getNgLabel(), request.getNgVersion());
        }
        return findConnector(request.getNgLabel(), request.getNgVersion()).invoke(request);
    }

    /**
     * 异步发送请求
     *
     * @param request
     * @return
     * @throws Exception
     */
    public static CloudResponse asyncInvoke(CloudRequest request) throws Exception {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Async invoke request to ngLabel:{},ngVersion:{}", request.getNgLabel(), request.getNgVersion());
        }
        return findConnector(request.getNgLabel(), request.getNgVersion()).asyncInvoke(request);
    }

    /**
     * 发送请求
     *
     * @param request
     * @return
     * @throws Exception
     */
    public static void call(CloudRequest request) throws Exception {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Call ngLabel:{},ngVersion:{}", request.getNgLabel(), request.getNgVersion());
        }
        findConnector(request.getNgLabel(), request.getNgVersion()).call(request);
    }

    /**
     * 异步发送请求
     *
     * @param request
     * @return
     * @throws Exception
     */
    public static void asyncCall(CloudRequest request) throws Exception {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Async call ngLabel:{},ngVersion:{}", request.getNgLabel(), request.getNgVersion());
        }
        findConnector(request.getNgLabel(), request.getNgVersion()).asyncCall(request);
    }

    /**
     * 查询需要发送的服务连接，如果没有这尝试新建连接
     *
     * @param ngLabel
     * @param ngVersion
     * @return
     * @throws Exception
     */
    private static ClientConnector findConnector(String ngLabel, String ngVersion) throws Exception {
        return CONCURRENT_HASH_MAP.computeIfAbsent(IceUtil.ngToRGI(ngLabel, ngVersion), id -> {
            try {
                ClientConnector connector = new ClientConnector();
                connector.init(ngLabel, ngVersion);
                return connector;
            } catch (Exception e) {
                LOGGER.error("Error in init client", e);
            }
            return null;
        });
    }
}
