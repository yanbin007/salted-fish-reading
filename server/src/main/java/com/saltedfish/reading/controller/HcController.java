package com.saltedfish.reading.controller;

import com.saltedfish.reading.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanbin on 2019/8/10.
 */
@RestController
public class HcController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/hc")
    public String hc() {
        return "OK";
    }
}
