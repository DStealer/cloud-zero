package com.cloudzero.arch.ice;

import Ice.Properties;
import com.cloudzero.arch.config.ConfigHelper;
import org.apache.commons.lang3.StringUtils;

import java.security.InvalidParameterException;
import java.util.Map;

/**
 * 客户端配置信息
 * Created by LiShiwu on 06/21/2017.
 */
public class ClientCfgHelper {
    //配置映射关系
    private static final PropMapping[] PROP_MAPPINGS = new PropMapping[]{
            new PropMapping("node.type", null, null),

            new PropMapping("ssl.keystore", "IceSSL.Keystore", null),
            new PropMapping("ssl.truststore", "IceSSL.Truststore", null),
            new PropMapping("ssl.password", "IceSSL.Password", null),

            new PropMapping(null, "Ice.Plugin.IceDiscovery", "IceDiscovery:IceDiscovery.PluginFactory"),
            new PropMapping(null, "Ice.MessageSizeMax", "20480"),
            new PropMapping(null, "Ice.Plugin.IceSSL", "IceSSL:IceSSL.PluginFactory"),
    };

    /**
     * 从默认配置产生自定义配置
     *
     * @param ngLabel
     * @param ngVersion
     * @return
     */
    public static Properties customWithDefault(String ngLabel, String ngVersion) {
        Map<String, String> cfgMap = ConfigHelper.loadNodeCfg(ngLabel, ngVersion);
        if (StringUtils.equals(cfgMap.remove("node.type"), "client")) {
            return IceUtil.mergeIfPresent(cfgMap, PROP_MAPPINGS);
        } else {
            throw new InvalidParameterException("node.type is incorrect");
        }
    }
}
