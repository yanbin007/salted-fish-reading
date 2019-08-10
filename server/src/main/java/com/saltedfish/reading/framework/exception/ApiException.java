package com.saltedfish.reading.framework.exception;

import com.sun.xml.internal.ws.api.pipe.ServerTubeAssemblerContext;

/**
 * Created by yanbin on 2019/8/10.
 */
public class ApiException extends RuntimeException {
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

    public ApiException() {

    }

    public ApiException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ApiException exception() {
        return new ApiException("999", "未知异常");
    }

    public static ApiException exception(String code, String msg) {
        return new ApiException(code, msg);
    }
}
