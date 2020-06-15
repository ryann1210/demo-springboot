package com.ruanyangyang.demo.entity;

public enum ResultCode implements IResultCode {

    OK(200, "请求成功"),
    NO_AUTH(401, "没有权限"),
    ERROR(500, "系统繁忙");



    private final long code;
    private final String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "ResultCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
