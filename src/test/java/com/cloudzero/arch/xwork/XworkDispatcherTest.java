package com.cloudzero.arch.xwork;

import com.opensymphony.xwork2.XWork;
import com.opensymphony.xwork2.config.ConfigurationManager;
import com.opensymphony.xwork2.config.providers.XWorkConfigurationProvider;
import com.opensymphony.xwork2.config.providers.XmlConfigurationProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * Created by lishiwu on 2016/10/10.
 */
public class XworkDispatcherTest {
    @BeforeClass
    public void setUp() throws Exception {

    }

    @Test
    public void test0001() throws Exception {
        ConfigurationManager configurationManager = new ConfigurationManager();
        configurationManager.addContainerProvider(new XWorkConfigurationProvider());
        configurationManager.addContainerProvider(new XmlConfigurationProvider("xwork-test.xml"));
        XWork xWork = new XWork(configurationManager);
        xWork.executeAction("NotExistNg", "0.0.1", "execute");
    }

}