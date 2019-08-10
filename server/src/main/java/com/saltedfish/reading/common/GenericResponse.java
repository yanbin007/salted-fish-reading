package com.saltedfish.reading.common;

import lombok.Builder;
import lombok.Data;

/**
 * Created by yanbin on 2019/8/10.
 */
public class GenericResponse<T> {
    private static final String HAS_NO_TOKEN = "999";
    private String code;
    private String msg;
    private T content;

    public GenericResponse(String code, String msg, T content) {
        this.code = code;
        this.msg = msg;
        this.content = content;
    }

    public GenericResponse() {
    }

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

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public static GenericResponse tokenError() {
        return new GenericResponse(HAS_NO_TOKEN, "请先登录", null);
    }
}

