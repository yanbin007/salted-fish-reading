package com.saltedfish.reading.controller;

import com.saltedfish.reading.common.GenericResponse;
import com.saltedfish.reading.framework.annotation.TokenValidate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanbin on 2019/8/10.
 */
@RestController
public class HcController {
    @TokenValidate
    @GetMapping("/hc")
    public String hc() {
        return "OK";
    }
}
