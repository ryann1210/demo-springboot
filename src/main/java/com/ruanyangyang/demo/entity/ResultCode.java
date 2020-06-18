package com.ruanyangyang.demo.entity;

public enum ResultCode implements IResultCode {
    /**
     * 101** 通用异常
     */
    ERR(10100, "系统繁忙"),
    ERR_NO_AUTHENTICATION(10101, "登陆已过期,请重新登陆"),
    ERR_NO_AUTHORIZATION(10102, "权限不足"),

    /**
     * 102** 用户异常
     */
    ERR_WRONG_ACCOUNT(10201, "账户名错误"),
    ERR_WRONG_PASSWORD(10201, "密码错误"),
    ERR_LOCKED_USER(10201, "用户已锁定"),

    /**
     * 10000 成功返回
     */
    OK(10000, "请求成功");


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
