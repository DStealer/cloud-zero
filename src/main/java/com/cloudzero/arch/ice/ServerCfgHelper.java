package com.cloudzero.arch.ice;

import Ice.Properties;
import com.cloudzero.arch.config.ConfigHelper;
import org.apache.commons.lang3.StringUtils;

import java.security.InvalidParameterException;
import java.util.Map;
import java.util.Random;

/**
 * 服务节点配置
 * Created by LiShiwu on 06/21/2017.
 */
public class ServerCfgHelper {
    //配置映射关系
    private static final PropMapping[] PROP_MAPPINGS = new PropMapping[]{
            new PropMapping("node.type", null, null),
            new PropMapping("node.host", "Ice.Default.Host", null),
            new PropMapping("node.protocol", "Ice.Default.Protocol", "tcp"),

            new PropMapping("pool.min", "Ice.ThreadPool.Server.Size", "1"),
            new PropMapping("pool.max", "Ice.ThreadPool.Server.SizeMax", "10"),
            new PropMapping("pool.warn", "Ice.ThreadPool.Server.SizeWarn", null),

            new PropMapping("connection.timeout", "Ice.Default.Timeout", null),

            new PropMapping("ssl.keystore", "IceSSL.Keystore", null),
            new PropMapping("ssl.truststore", "IceSSL.Truststore", null),
            new PropMapping("ssl.password", "IceSSL.Password", null),

            new PropMapping(null, "Ice.MessageSizeMax", "20480"),
            new PropMapping(null, "Ice.Plugin.IceDiscovery", "IceDiscovery:IceDiscovery.PluginFactory"),
            new PropMapping(null, "Ice.Plugin.IceSSL", "IceSSL:IceSSL.PluginFactory"),
    };
    //服务节点名称
    public static String NG_NAME;
    //服务节点版本
    public static String NG_VERSION;
    //Xwork配置文件路径
    public static String XWORK_CFG_FILE_PATH;
    //节点配置文件夹
    public static String NODE_CFG_FILE_DIR;

    /**
     * 生成随机端口的EndPoints
     *
     * @return
     */
    public static String generateEndPoints(Properties properties) {
        return String.format("%s -h %s -p %s", properties.getProperty("Ice.Default.Protocol"),
                properties.getPropertyWithDefault("Ice.Default.Host", "*"), new Random().nextInt(10000) + 10000);
    }

    /**
     * 从默认配置产生自定义配置
     *
     * @return
     */
    public static Properties customWithDefault() {
        if (StringUtils.isEmpty(NG_NAME) || StringUtils.isEmpty(NG_VERSION)) {
            throw new InvalidParameterException("ng name or ng version is empty");
        }
        Map<String, String> cfgMap = ConfigHelper.loadNodeCfg(NG_NAME, NG_VERSION);
        if (StringUtils.equals(cfgMap.remove("node.type"), "server")) {
            return IceUtil.mergeIfPresent(cfgMap, PROP_MAPPINGS);
        } else {
            throw new InvalidParameterException("node.type is incorrect");
        }
    }
}
