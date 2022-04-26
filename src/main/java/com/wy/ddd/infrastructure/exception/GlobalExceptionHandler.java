package com.wy.ddd.infrastructure.exception;

import com.wy.ddd.interfaces.product.vo.BaseResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wy.ddd.infrastructure.enums.BaseResponseEnum;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author wangyang
 * @Create 2022/1/18 8:34
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    Object handleException(Exception e, HttpServletRequest request){
        //f返回json数据
        Map<String, Object> map = new HashMap<>();
        map.put("code", (e.getStackTrace() == null ? "" : e.getStackTrace()[0]));
        map.put("msg", e.getMessage());
        map.put("url", request.getRequestURL());
        map.put("logId", MDC.get("requestId"));
        return map;
    }

    /**
     * 抛什么异常就走哪个逻辑
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    BaseResponseVO<Object> handleMyException(BaseException e, HttpServletRequest request){
        BaseResponseVO<Object> baseResponseVO = new BaseResponseVO<>();
        baseResponseVO.setCode(BaseResponseEnum.FAIL.getCode());
        baseResponseVO.setMessage(e.getMessage());
        baseResponseVO.setLogId(MDC.get("requestId"));
        return baseResponseVO;
    }

}
