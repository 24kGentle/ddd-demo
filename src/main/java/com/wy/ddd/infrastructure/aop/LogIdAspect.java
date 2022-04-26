package com.wy.ddd.infrastructure.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author: zhao.cy
 * @since: 2021/1/7
 * create at : 2021/1/7 17:03
 */
@Slf4j
@Aspect
@Component
public class LogIdAspect {
    private final static String REQUEST_ID = "requestId";
    /**
     * 自定义切点
     */
    @Pointcut("@annotation(com.wy.ddd.infrastructure.annotation.LogId)")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
        // MDC容器增加requestId
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        MDC.put(REQUEST_ID, uuid);

    }

    @AfterReturning(pointcut = "pointCut()", returning = "result")
    public void doAfterReturningAdvice(JoinPoint joinPoint, Object result) {
        MDC.remove(REQUEST_ID);

    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
        MDC.remove(REQUEST_ID);
    }

}
