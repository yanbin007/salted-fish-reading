package com.saltedfish.reading.controller;

import com.saltedfish.reading.common.GenericResponse;
import com.saltedfish.reading.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanbin on 2019/8/11.
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/login/wxlogin")
    public GenericResponse wxLogin(@RequestParam("code") String code) {
        String token = loginService.login(code);

        if (token != null && token != "") {
            return new GenericResponse("000", "登录成功", token);
        }

        return new GenericResponse("100", "登录失败", null);
    }
}
