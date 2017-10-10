package com.cloudzero.arch.ice;

import Ice.Properties;
import Ice.Util;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by lishiwu on 2016/10/14.
 */
public class IceUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(IceUtil.class);

    /**
     * 将ng name和version 转换成 replication group id
     *
     * @param ngLabel
     * @param naVersion
     * @return
     */
    public static String ngToRGI(String ngLabel, String naVersion) {
        if (StringUtils.isEmpty(ngLabel) || StringUtils.isEmpty(ngLabel)) {
            throw new InvalidParameterException();
        }
        return String.format("%s[%s]", ngLabel, naVersion);
    }

    /**
     * 将 proxyId,ng name和version 转换成 replication group proxy 标识
     *
     * @param proxyId
     * @param ngLabel
     * @param ngVersion
     * @return
     */
    public static String stringToRGIProxy(String proxyId, String ngLabel, String ngVersion) {
        if (StringUtils.isEmpty(proxyId) || StringUtils.isEmpty(ngLabel) || StringUtils.isEmpty(ngLabel)) {
            throw new InvalidParameterException();
        }
        return String.format("'%s'@%s", proxyId, ngToRGI(ngLabel, ngVersion));
    }

    /**
     * 生成配置,使用source如果没有则使用默认值
     *
     * @param source
     * @param propMappingWithDefault 带默认值的属性映射
     */
    public static Properties mergeIfPresent(Map<String, String> source, PropMapping[] propMappingWithDefault) {
        Properties dest = Util.createProperties();
        //第一步拷贝IcePropName 和 defaultVal非空默认值
        Arrays.stream(propMappingWithDefault).filter(pm -> StringUtils.isNotEmpty(pm.getIcePropName()))
                .filter(pm -> StringUtils.isNotEmpty(pm.getDefaultVal()))
                .forEach(pm -> dest.setProperty(pm.getIcePropName(), pm.getDefaultVal()));
        //第二步 拷贝source配置
        Arrays.stream(propMappingWithDefault).filter(pm -> StringUtils.isNotEmpty(pm.getCloudPropName()))
                .filter(pm -> StringUtils.isNotEmpty(pm.getIcePropName()))
                .filter(pm -> StringUtils.isNotEmpty(source.get(pm.getCloudPropName())))
                .forEach(pm -> dest.setProperty(pm.getIcePropName(), source.remove(pm.getCloudPropName())));
        if (source.size() > 0) {
            LOGGER.warn("Unused properties:{}", source);
        }
        return dest;
    }
}
