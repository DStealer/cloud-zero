package com.cloudzero.arch.startup;

import com.cloudzero.arch.config.ConfigHelper;

/**
 * Created by LiShiwu on 06/27/2017.
 */
public class BootMainTest extends BootMain {
    public static void main(String[] args) throws Exception {
        ConfigHelper.setConfigFilePath("D:\\Workspace\\serverprojects_other\\cloud_zero\\arch-m3\\src\\main\\resources\\node-cloud.xml");
        new BootMain().run(args);
    }
}