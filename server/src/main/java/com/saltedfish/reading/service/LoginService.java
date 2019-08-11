package com.saltedfish.reading.service;

import com.saltedfish.reading.framework.redis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by yanbin on 2019/8/11.
 */
@Service
public class LoginService extends BaseService {

    private static final String TOKEN_CACHE_KEY_PRE = "token_";

    @Autowired
    private RedisClient redisClient;
    @Autowired
    private WxService wxService;

    public Long login(String code) {
        //如果Header中已有TOKEN就不重新登录，如果没有就到微信授权
        if (wxToken != null && wxToken != null) {
            String cache = redisClient.getValue(TOKEN_CACHE_KEY_PRE + wxToken);

            if (cache != null && cache != "") {
                return Long.parseLong(cache);
            }
        }

        if (code != null && code != "") {
            String openId = wxService.login(code);

            //
        }

        return null;

    }
}
