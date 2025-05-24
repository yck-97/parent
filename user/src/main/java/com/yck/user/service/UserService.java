package com.yck.user.service;

import com.yck.user.dto.UserDTO;

import java.util.List;
import java.util.Map;

/**
 * 描述
 * Author：yangchangkui
 * Date: 2023/7/18
 */
public interface UserService {
    List<UserDTO> queryUser(String name);

    String queryDeepseek(Map<String, Object> requestParam);

    Map beta(Map<String, Object> requestParam);
}
