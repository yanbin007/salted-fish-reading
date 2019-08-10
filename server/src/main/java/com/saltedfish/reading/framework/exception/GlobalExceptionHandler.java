package com.saltedfish.reading.framework.exception;

import com.saltedfish.reading.common.GenericResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yanbin on 2019/8/10.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public GenericResponse exceptionHandler(HttpServletRequest request, Exception e) {
        //绑定异常是需要明确提示给用户的
        if (e instanceof ApiException) {
            ApiException exception = (ApiException) e;
            return new GenericResponse(exception.getCode(), exception.getMsg(), null);
        }

        return new GenericResponse("9999", "系统异常", null);
    }
}
