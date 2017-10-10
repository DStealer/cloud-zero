package com.cloudzero.arch.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;

/**
 * Created by LiShiwu on 06/18/2017.
 */
public class AppKit {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppKit.class);

    /**
     * 堆栈信息输出
     *
     * @param e
     * @return
     */
    public static String stack2string(Throwable e) {
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            return sw.toString();
        } catch (Exception e2) {
            LOGGER.warn(e2.getMessage(), e2);
            return e2.toString();
        }
    }

    /**
     * 获取指定资源文件
     *
     * @param resourceName
     * @param callingClass
     * @return
     */
    public static URL getResource(String resourceName, Class callingClass) {
        URL url = Thread.currentThread().getContextClassLoader().getResource(resourceName);
        if (url == null) {
            url = AppKit.class.getClassLoader().getResource(resourceName);
        }
        if (url == null && callingClass != null) {
            ClassLoader cl = callingClass.getClassLoader();
            if (cl != null) {
                url = cl.getResource(resourceName);
            }
        }
        if ((url == null) && (resourceName != null) && ((resourceName.length() == 0) || (resourceName.charAt(0) != '/'))) {
            return getResource('/' + resourceName, callingClass);
        }
        return url;
    }
}
