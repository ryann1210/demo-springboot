package com.ruanyangyang.demo.common.util;

/**
 * Created by brander on 2019/11/28
 */
public class TimeUtil {

    public static Long getUnixTime() {
        return System.currentTimeMillis() / 1000;
    }
}
