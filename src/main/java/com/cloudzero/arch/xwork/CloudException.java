package com.cloudzero.arch.xwork;

/**
 * Created by LiShiwu on 06/23/2017.
 */
public class CloudException extends Exception {
    private String errorCode;
    private String description;

    public CloudException(String errorCode, String description) {
        this.errorCode = errorCode;
        this.description = description;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
