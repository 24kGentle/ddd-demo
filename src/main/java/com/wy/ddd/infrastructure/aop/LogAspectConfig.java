package com.wy.ddd.infrastructure.aop;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 统一日志打印
 * @author wangyang
 *
 */
@Aspect
@Component
@Slf4j
public class LogAspectConfig {
    private JSONObject jsonObject = new JSONObject();

    // 申明一个切点 里面是 execution表达式
    @Pointcut("execution(public * com.wy.ddd.interfaces.product.control.*.*(..))")
    private void controllerAspect() {
    }

    @Around("controllerAspect()")
    public Object decryptVerification(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("===============请求内容===============");
        Object proceed = new Object();
        try {
            // 打印请求内容
            log.info("请求地址:" + request.getRequestURL().toString());
            log.info("请求方式:" + request.getMethod());
            log.info("请求类方法:" + joinPoint.getSignature());
            log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
            Object[] args = joinPoint.getArgs();
            if (args.length > 0) {
                System.out.println("NO1:" + args[0]);
            }
            proceed = joinPoint.proceed(args);
        } catch (Exception e) {
            log.error("###LogAspectServiceApi.class methodBefore() ### ERROR:", e);
        }
       return proceed;
    }

//    // 请求method前打印内容
//    @Before(value = "controllerAspect()")
//    public void methodBefore(JoinPoint joinPoint) {
//        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
//                .getRequestAttributes();
//        HttpServletRequest request = requestAttributes.getRequest();
//        log.info("===============请求内容===============");
//        try {
//            // 打印请求内容
//            log.info("请求地址:" + request.getRequestURL().toString());
//            log.info("请求方式:" + request.getMethod());
//            log.info("请求类方法:" + joinPoint.getSignature());
//            log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
//        } catch (Exception e) {
//            log.error("###LogAspectServiceApi.class methodBefore() ### ERROR:", e);
//        }
//        log.info("===============请求内容===============");
//    }
//
//    // 在方法执行完结后打印返回内容
//    @SuppressWarnings("static-access")
//    @AfterReturning(returning = "o", pointcut = "controllerAspect()")
//    public void methodAfterReturing(Object o) {
//        log.info("--------------返回内容----------------");
//        try {
//            log.info("Response内容:" + jsonObject.toJSONString(o));
//        } catch (Exception e) {
//            log.error("###LogAspectServiceApi.class methodAfterReturing() ### ERROR:", e);
//        }
//        log.info("--------------返回内容----------------");
//    }
}