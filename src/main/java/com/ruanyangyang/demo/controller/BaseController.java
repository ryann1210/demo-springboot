package com.ruanyangyang.demo.controller;

import com.ruanyangyang.demo.common.cache.LocalCache;
import org.omg.CORBA.LongSeqHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

/**
 * Controller基类
 *
 * @author ryan
 * @date 15:19 2020/6/11
 */
@Component
public class BaseController {
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected LocalCache localCache;

    /**
     * 获取当前请求
     *
     * @return servlet
     */
    protected HttpServletRequest getCurrentHttpServletRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest();
    }

    /**
     * 获取当前用户id
     *
     * @return 用户id
     */
    protected Integer getCurrentUserId() {
        HttpServletRequest request = getCurrentHttpServletRequest();

        try {
            Object userId = request.getAttribute("userId");
            return Integer.parseInt(String.valueOf(userId));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return -1;
    }

    /**
     * 获取用户请求来源
     *
     * @return 来源
     */
    protected String getCurrentLoginSource() {
        HttpServletRequest request = getCurrentHttpServletRequest();

        return request.getHeader("from") == null ?
                "Unknown" : request.getHeader("from").toLowerCase();
    }


    /**
     * 获取用户IP地址
     *
     * @return 来源
     */
    protected String getCurrentIpAddress() {
        HttpServletRequest request = getCurrentHttpServletRequest();

        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
