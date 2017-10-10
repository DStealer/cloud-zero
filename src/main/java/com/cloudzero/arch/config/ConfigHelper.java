package com.cloudzero.arch.config;

import com.cloudzero.arch.ice.ServerCfgHelper;
import org.apache.commons.configuration2.ImmutableConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置工具类
 * Created by LiShiwu on 06/26/2017.
 */
public class ConfigHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigHelper.class);
    /**
     * 基础配置文件
     */
    private static String CONFIG_FILE_PATH;

    /**
     * 设置基础配置文件路径
     *
     * @param filePath
     */
    public static void setConfigFilePath(String filePath) throws NoSuchFieldException {
        if (new File(filePath).exists()) {
            CONFIG_FILE_PATH = filePath;
        } else {
            throw new NoSuchFieldException("Config file don't exists");
        }
    }

    /**
     * 获取基础配置
     *
     * @return
     */
    public static ImmutableConfiguration getConfig() {
        return ConfigKit.use(CONFIG_FILE_PATH);
    }

    /**
     * 配置节点信息
     */
    public static void initNodeConfig() {
        ImmutableConfiguration cfg = ConfigKit.use(CONFIG_FILE_PATH);
        ServerCfgHelper.NG_NAME = cfg.getString("node-cfg.server-node.label");
        if (StringUtils.isEmpty(ServerCfgHelper.NG_NAME)) {
            throw new InvalidParameterException("node-cfg.server-node.label must be config");
        }
        ServerCfgHelper.NG_VERSION = cfg.getString("node-cfg.server-node.version");
        if (StringUtils.isEmpty(ServerCfgHelper.NG_VERSION)) {
            throw new InvalidParameterException("node-cfg.server-node.version must be config");
        }
        ServerCfgHelper.XWORK_CFG_FILE_PATH = cfg.getString("node-cfg.xwork_cfg_file");
        if (StringUtils.isEmpty(ServerCfgHelper.XWORK_CFG_FILE_PATH)) {
            throw new InvalidParameterException("node-cfg.xwork_cfg_file must be config");
        }
        ServerCfgHelper.NODE_CFG_FILE_DIR = ConfigKit.use(CONFIG_FILE_PATH).getString("node-cfg.node-cfg-dir");
        if (StringUtils.isEmpty(ServerCfgHelper.NODE_CFG_FILE_DIR)) {
            throw new InvalidParameterException("node-cfg.node-cfg-dir must be config");
        }
    }

    /**
     * 加载节点配置
     *
     * @param ngLabel
     * @param ngVersion
     * @return
     */
    public static Map<String, String> loadNodeCfg(String ngLabel, String ngVersion) {
        String cfgPath = String.format("%s%s%s-%s.properties", ServerCfgHelper.NODE_CFG_FILE_DIR, File.separator, ngLabel, ngVersion);
        if (new File(cfgPath).exists()) {
            LOGGER.info("Load configuration file:{}", cfgPath);
            ImmutableConfiguration configuration = ConfigKit.use(cfgPath);
            Map<String, String> cfgMap = new HashMap<>();
            configuration.getKeys().forEachRemaining(k -> cfgMap.put(k, configuration.getString(k)));
            ConfigKit.useless(cfgPath);
            return cfgMap;
        } else {
            LOGGER.warn("Configuration file:{} not exist,use default", cfgPath);
            return Collections.emptyMap();
        }
    }
}
