package com.ruanyangyang.demo.common.aspect;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.ruanyangyang.demo.common.annotation.OperationLog;
import com.ruanyangyang.demo.common.util.TimeUtil;
import com.ruanyangyang.demo.controller.BaseController;
import com.ruanyangyang.demo.entity.pojo.OperateLog;
import com.ruanyangyang.demo.service.OperateLogService;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.List;

@Aspect
@Component
@Order(1)
public class OperationLogAspect extends BaseController {

    @Autowired
    private OperateLogService operateLogService;

    @Pointcut(value = "@annotation(com.ruanyangyang.demo.common.annotation.OperationLog)")
    public void operationLog() {
    }

    @Around(value = "operationLog()")
    public Object aroundService(ProceedingJoinPoint pjp) throws Throwable {
        Object obj;
        try {
            obj = pjp.proceed();
            saveOperationLog(pjp);
        } catch (Throwable t) {
            throw t;
        }
        return obj;
    }

    private void saveOperationLog(ProceedingJoinPoint pjp) {
        //获取用户信息
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        if (request == null) {
            return;
        }
        long userId = -1L;
        try {
            userId = getCurrentUserId();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        String[] op = this.getMethodAnnotation(methodSignature, pjp.getTarget().getClass());

        if (StringUtils.isBlank(op[0])) {
            return;
        }
        Object[] objects = pjp.getArgs();
        if (objects == null || objects.length == 0) {
            return;
        }
        List<Object> params = Lists.newArrayList();
        for (Object object : objects) {
            if (object instanceof HttpServletRequest) {
                continue;
            }
            if (!object.toString().contains("pass")) {
                params.add(object);
            }
        }
        OperateLog operateLog = new OperateLog();
        operateLog.setModule(op[1]);
        if (op[1].contains("上传")) {
            operateLog.setOperateDetail(op[0]);
        } else {
            operateLog.setOperateDetail(JSON.toJSONString(params));
        }
        operateLog.setOperateType(op[0]);
        operateLog.setSource("系统");
        operateLog.setUserId(userId);
        operateLog.setIp(request.getRemoteHost());
        operateLog.setCreateTime(TimeUtil.getUnixTime());

        log.info("切面打印的操作日志：" + operateLog.toString());
        operateLogService.save(operateLog);
    }

    /**
     * 取方法注释
     *
     * @param cls
     * @return the method annotation
     * @throws SecurityException
     * @throws NoSuchMethodException
     */
    String[] getMethodAnnotation(MethodSignature methodSignature, Class<? extends Object> cls) {
        Method method = methodSignature.getMethod();
        try {
            method = cls.getMethod(method.getName(), method.getParameterTypes());
            OperationLog operationLog = method.getAnnotation(OperationLog.class);
            if (operationLog != null) {
                return new String[]{operationLog.method(), operationLog.module()};
            }
        } catch (NoSuchMethodException e) {
        } catch (SecurityException e) {
        }
        return null;
    }

}
