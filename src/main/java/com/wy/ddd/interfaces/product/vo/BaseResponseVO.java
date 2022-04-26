package com.wy.ddd.interfaces.product.vo;

import com.wy.ddd.infrastructure.exception.BaseException;
import lombok.Data;
import org.slf4j.MDC;

/**
 * @Author wangyang
 * @Create 2022/4/25 13:36
 */
@Data
public class BaseResponseVO<T> {

    private Integer code;

    private String message;

    private T data;

    private String logId;

    private static final Integer SUCCESS = 200;

    private static final Integer FAIL = 100;

    public BaseResponseVO() {
        this.logId = MDC.get("requestId");
    }

    public BaseResponseVO(Integer code, String message, T data, String logId) {
        verifyParam(code);
        this.logId = logId;
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public BaseResponseVO(Integer code, String message, String logId) {
        verifyParam(code);
        this.code = code;
        this.message = message;
        this.logId = logId;
    }

//    public BaseResponseVO(String message) {
//
//        this.message = message;
//    }

    private void verifyParam(Integer code) {
        if (!SUCCESS.equals(code) || !FAIL.equals(code)) {
            throw new BaseException("返回的code不符合规范");
        }
    }
}
