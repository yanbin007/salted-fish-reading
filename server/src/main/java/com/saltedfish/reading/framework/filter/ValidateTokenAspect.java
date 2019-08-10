package com.saltedfish.reading.framework.filter;

import com.saltedfish.reading.common.GenericResponse;
import com.saltedfish.reading.framework.exception.ApiException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yanbin on 2019/8/10.
 */
@Aspect
@Component
public class ValidateTokenAspect {
    @Pointcut("@annotation(com.saltedfish.reading.framework.annotation.TokenValidate)")
    public void validatePointCut() {
    }

    @Before("validatePointCut()")
    public void before(JoinPoint point) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String wxToken = request.getHeader("WX-TOKEN");
        if (wxToken == null || wxToken == "") {
            throw new ApiException("998", "Token校验失败");
        }
    }
}
