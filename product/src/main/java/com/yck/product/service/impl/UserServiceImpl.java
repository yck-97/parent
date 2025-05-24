package com.yck.product.service.impl;

import com.yck.product.dto.UserDTO;
import com.yck.product.mapper.UserMapper;
import com.yck.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 描述
 * Author：yangchangkui
 * Date: 2023/7/18
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<UserDTO> queryUser(String userName) {
        redisTemplate.opsForValue().set("YCK", "李四", 300000l, TimeUnit.SECONDS);
        return userMapper.queryUserList(userName);
    }
}
