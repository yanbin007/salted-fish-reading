package com.saltedfish.reading.service;

import com.saltedfish.reading.dao.UserMapper;
import com.saltedfish.reading.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yanbin on 2019/8/11.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User createUser(String openId, String photoUrl, String nickName) {
        User user = new User();
        user.setOpenId(openId);
        user.setNickName(nickName);
        user.setPhotoUrl(photoUrl);
        if (userMapper.insertSelective(user) > 0) {
            return user;
        }
        return null;
    }

    public User getUserByOpenId(String openId) {
        return userMapper.selectByOpenId(openId);
    }
}
