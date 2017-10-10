package com.cloudzero.arch.ice;

/**
 * Created by LiShiwu on 06/27/2017.
 */
public class PropMapping {
    private String cloudPropName;
    private String icePropName;
    private String defaultVal;

    public PropMapping(String cloudPropName, String icePropName, String defaultVal) {
        this.cloudPropName = cloudPropName;
        this.icePropName = icePropName;
        this.defaultVal = defaultVal;
    }

    public String getCloudPropName() {
        return cloudPropName;
    }

    public String getIcePropName() {
        return icePropName;
    }

    public String getDefaultVal() {
        return defaultVal;
    }
}
