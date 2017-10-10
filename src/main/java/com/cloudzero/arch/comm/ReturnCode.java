package com.cloudzero.arch.comm;

/**
 * 系统错误码
 * Created by lishiwu on 2016/10/9.
 */
public enum ReturnCode {
    CZ000000("成功"),
    CZ000001("未知错误,请联系负责人"),
    CZ000002("ngLabel或ngVersion不匹配"),
    CZ000003("请求执行错误");
    private final String desc;

    ReturnCode(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}
