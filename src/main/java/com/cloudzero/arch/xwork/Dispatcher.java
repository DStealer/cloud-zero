package com.cloudzero.arch.xwork;

import com.cloudzero.arch.comm.ReturnCode;
import com.cloudzero.arch.pb.CloudRequest;
import com.cloudzero.arch.pb.CloudResponse;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionProxyFactory;
import com.opensymphony.xwork2.config.Configuration;
import com.opensymphony.xwork2.config.ConfigurationException;
import com.opensymphony.xwork2.config.ConfigurationManager;
import com.opensymphony.xwork2.config.providers.XWorkConfigurationProvider;
import com.opensymphony.xwork2.config.providers.XmlConfigurationProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 请求分发管理
 * Created by lishiwu on 2016/10/9.
 */
public class Dispatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(Dispatcher.class);
    private static ActionProxyFactory actionProxyFactory;

    private Dispatcher() {
    }

    /**
     * 初始化Xwork配置
     *
     * @param fileName
     */
    public static synchronized void init(String fileName) {
        if (actionProxyFactory == null) {
            com.opensymphony.xwork2.util.logging.LoggerFactory.setLoggerFactory(new Slf4jLoggerFactory());
            ConfigurationManager configurationManager = new ConfigurationManager();
            configurationManager.addContainerProvider(new XWorkConfigurationProvider());
            configurationManager.addContainerProvider(new XmlConfigurationProvider(fileName));
            Configuration configuration = configurationManager.getConfiguration();
            actionProxyFactory = configuration.getContainer().getInstance(ActionProxyFactory.class);
            LOGGER.info("Dispatcher initialization is complete");
        } else {
            LOGGER.warn("Dispatcher has been initialized");
        }
    }

    /**
     * 执行请求
     *
     * @param request
     * @return
     * @throws Exception
     */
    public static CloudResponse invoke(CloudRequest request) {
        try {
            Map<String, Object> params = new HashMap<>();
            MessageHolder holder = new MessageHolder();
            params.put(XworkConstant.ACTION_MESSAGE_HOLDER, holder);
            if (request.hasBody()) {
                holder.request = request.getBody();
            }
            ActionProxy actionProxy = actionProxyFactory.createActionProxy(request.getAction(), request.getActVersion(), "execute", params, false, true);
            actionProxy.execute();
            CloudResponse.Builder builder = CloudResponse.newBuilder();
            builder.setReturnCode(ReturnCode.CZ000000.name())
                    .setDescription(ReturnCode.CZ000000.toString());
            if (holder.response != null) {
                builder.setBody(holder.response);
            }
            return builder.build();
        } catch (CloudException e) {
            LOGGER.error(e.getMessage(), e);
            CloudResponse.Builder builder = CloudResponse.newBuilder();
            builder.setReturnCode(e.getErrorCode())
                    .setDescription(e.getDescription());
            return builder.build();
        } catch (ConfigurationException e) {
            LOGGER.error(e.getMessage(), e);
            CloudResponse.Builder builder = CloudResponse.newBuilder();
            builder.setReturnCode(ReturnCode.CZ000003.name())
                    .setDescription(ReturnCode.CZ000003.toString());
            return builder.build();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            CloudResponse.Builder builder = CloudResponse.newBuilder();
            builder.setReturnCode(ReturnCode.CZ000001.name())
                    .setDescription(ReturnCode.CZ000001.toString());
            return builder.build();
        }
    }

    /**
     * 执行请求
     *
     * @param request
     * @return
     * @throws Exception
     */
    public static void send(CloudRequest request) {
        try {
            Map<String, Object> params = new HashMap<>();
            MessageHolder holder = new MessageHolder();
            params.put(XworkConstant.ACTION_MESSAGE_HOLDER, holder);
            if (request.hasBody()) {
                holder.request = request.getBody();
            }
            ActionProxy actionProxy = actionProxyFactory.createActionProxy(request.getAction(), request.getActVersion(), "execute", params, false, true);
            actionProxy.execute();
        } catch (CloudException e) {
            LOGGER.error(e.getErrorCode(), e);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
