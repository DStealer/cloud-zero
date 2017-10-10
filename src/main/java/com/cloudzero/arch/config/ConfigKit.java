package com.cloudzero.arch.config;

import org.apache.commons.configuration2.ImmutableConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.convert.DisabledListDelimiterHandler;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.ex.ConfigurationRuntimeException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.InvalidParameterException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 配置文件读取工具类，不适合频繁读取,不适合修改
 * Created by LiShiwu on 06/20/2017.
 */
public class ConfigKit {
    //日志对象
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigKit.class);
    //内部配置容器
    private static final ConcurrentHashMap<String, ImmutableConfiguration> CFG_MAP = new ConcurrentHashMap<>();
    //当前线程内配置对象
    private static final ThreadLocal<ImmutableConfiguration> CUR_CFG = new ThreadLocal<>();

    /**
     * 读取配置
     *
     * @param fileName
     * @return
     */
    public static ImmutableConfiguration use(String fileName) {
        return use(fileName, "UTF-8");
    }

    /**
     * 读取配置
     *
     * @param fileName
     * @param enc
     * @return
     */
    public static ImmutableConfiguration use(String fileName, String enc) {
        return CFG_MAP.computeIfAbsent(fileName, (f) -> buildConfiguration(fileName, enc));
    }

    /**
     * 构建配置
     *
     * @param fileName
     * @param enc
     * @return
     */
    private static ImmutableConfiguration buildConfiguration(String fileName, String enc) {
        if (StringUtils.isEmpty(fileName)) {
            throw new InvalidParameterException("FileName can't be empty");
        }
        Map<String, Object> parameters = new Parameters().fileBased()
                .setListDelimiterHandler(new DisabledListDelimiterHandler())
                .setThrowExceptionOnMissing(true)
                .setEncoding(enc)
                .setFileName(fileName)
                .getParameters();
        try {
            if (fileName.toLowerCase().endsWith(".xml")) {
                FileBasedConfigurationBuilder<XMLConfiguration> builder = new FileBasedConfigurationBuilder<>(XMLConfiguration.class, parameters, true);
                LOGGER.info("FileName:{} => {}", fileName, builder.getFileHandler().getFile().getAbsoluteFile());
                return builder.getConfiguration();
            } else if (fileName.toLowerCase().endsWith(".properties")) {
                FileBasedConfigurationBuilder<PropertiesConfiguration> builder = new FileBasedConfigurationBuilder<>(PropertiesConfiguration.class, parameters, true);
                LOGGER.info("FileName:{} => {}", fileName, builder.getFileHandler().getFile().getAbsoluteFile());
                return builder.getConfiguration();
            } else {
                throw new InvalidParameterException("Unsupported file:" + fileName);
            }
        } catch (ConfigurationException e) {
            throw new ConfigurationRuntimeException(e);
        }
    }

    /**
     * 移除配置
     *
     * @param fileName
     */
    public static void useless(String fileName) {
        CFG_MAP.remove(fileName);
    }

    /**
     * 清空所有配置
     */
    public static void clear() {
        CFG_MAP.clear();
    }

    /**
     * 存于当前线程
     *
     * @param fileName
     */
    public static void local(String fileName) {
        CUR_CFG.remove();
        CUR_CFG.set(use(fileName));
    }

    /**
     * 从当前线程驱逐
     */
    public static void evict() {
        CUR_CFG.remove();
    }

    /**
     * 配置对象子集
     *
     * @param prefix
     * @return
     */
    public static ImmutableConfiguration subset(String prefix) {
        return CUR_CFG.get().immutableSubset(prefix);
    }
}
