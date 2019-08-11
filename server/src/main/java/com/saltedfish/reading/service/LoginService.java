package com.saltedfish.reading.service;

import com.saltedfish.reading.framework.redis.RedisClient;
import com.saltedfish.reading.model.dto.WxLoginResult;
import com.saltedfish.reading.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
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
    @Autowired
    private UserService userService;

    public String login(String code) {
        //如果Header中已有TOKEN就不重新登录，如果没有就到微信授权
        if (wxToken != null && wxToken != null) {
            return wxToken;
        }

        if (code != null && code != "") {
            WxLoginResult wxLoginResult = wxService.login(code);
            if (wxLoginResult != null && wxLoginResult.getOpenId() != null && wxLoginResult.getOpenId() != "") {
                User user = userService.getUserByOpenId(wxLoginResult.getOpenId());

                if (user == null) {
                    user = userService.createUser(wxLoginResult.getOpenId(), null, null);
                }

                if (user != null) {
                    //生成wxtoken加缓存
                    String token = UUID.randomUUID().toString();
                    redisClient.setValue(TOKEN_CACHE_KEY_PRE + token, user.getUserId().toString(), 1l, TimeUnit.HOURS);

                    return token;
                }
            }
        }

        return null;

    }

    public Long getUserIdByToken(String token) {
        String cache = redisClient.getValue(TOKEN_CACHE_KEY_PRE + wxToken);

        if (cache != null && cache != "") {
            return Long.parseLong(cache);
        }

        return null;
    }
}
