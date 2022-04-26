package com.wy.ddd.infrastructure.exception;

/**
 * @Author wangyang
 * @Create 2022/1/18 8:33
 */
public class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }


    public BaseException(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
