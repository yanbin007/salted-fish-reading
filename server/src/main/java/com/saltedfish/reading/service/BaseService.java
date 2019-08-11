package com.saltedfish.reading.service;

/**
 * Created by yanbin on 2019/8/11.
 */
public class BaseService {
    protected Long userId;
    protected String wxToken;

    protected Long getUserId() {
        if (userId == null || userId <= 0) {

        }

        return userId;
    }
}
