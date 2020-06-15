package com.ruanyangyang.demo.entity;

public interface IResultCode {
    /**
     * 错误编码
     */
    long getCode();

    /**
     * 错误描述
     */
    String getMsg();
}
