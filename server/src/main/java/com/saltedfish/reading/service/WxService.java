package com.saltedfish.reading.service;

import com.saltedfish.reading.model.dto.WxLoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yanbin on 2019/8/11.
 */
@Service
public class WxService {

    @Value("${wx.appId}")
    private String appId;
    @Value("${wx.secret}")
    private String secret;

    @Autowired
    private RestTemplate restTemplate;

    public WxLoginResult login(String code) {
        return restTemplate.getForObject("https://api.weixin.qq.com/sns/jscode2session?appid={appId}&secret={secert}&js_code={code}&grant_type=authorization_code", WxLoginResult.class, appId, secret, code);
    }
}
