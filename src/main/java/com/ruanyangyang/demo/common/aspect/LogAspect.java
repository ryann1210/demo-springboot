package com.ruanyangyang.demo.common.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Log收集
 *
 * @author wangban
 * @date 11:50 2018/10/30
 */
@Aspect
@Component
@Order(1)
public class LogAspect {
    private Logger log = LoggerFactory.getLogger(LogAspect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 申明切点 execution表达式
     */
    @Pointcut("execution(* com.ruanyangyang.demo.controller..*.*(..))")
    private void controllerAspect() {
    }

    /**
     * 方法执行前 打印请求内容
     *
     * @param joinPoint obj
     */
    @Before(value = "controllerAspect()")
    public void methodBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());

        // 获取请求
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        // 打印请求内容
        log.info("╔═══════════════请求内容══════════════");
        log.info("║  请求地址：" + request.getRequestURL().toString());
        log.info("║  请求方式：" + request.getMethod());
        log.info("║  请求类方法：" + joinPoint.getSignature());
        log.info("║  请求类方法参数：" + Arrays.toString(joinPoint.getArgs()));
        log.info("╚═══════════════请求内容══════════════");
    }

    /**
     * 方法执行完 打印返回内容
     *
     * @param o obj
     */
    @AfterReturning(returning = "o", pointcut = "controllerAspect()")
    public void methodAfterReturning(Object o) {
        log.info("╔═══════════════返回内容══════════════");
        log.info("║  Response内容：" + JSON.toJSONString(o));
        log.info("║  ");
        log.info("║  请求处理时间(ms)：" + (System.currentTimeMillis() - startTime.get()));
        log.info("╚═══════════════返回内容══════════════");
    }
}
