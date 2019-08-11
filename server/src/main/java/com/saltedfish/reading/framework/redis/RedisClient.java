package com.saltedfish.reading.framework.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by yanbin on 2019/8/11.
 */
@Service
public class RedisClient {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public boolean setValue(String key, String value, Long time, TimeUnit timeUnit) {
        stringRedisTemplate.opsForValue().set(key, value, time, timeUnit);

        return true;
    }

    public String getValue(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
}
