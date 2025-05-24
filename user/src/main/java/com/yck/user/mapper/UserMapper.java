package com.yck.user.mapper;

import com.yck.user.dto.UserDTO;

import java.util.List;

/**
 * 描述
 * Author：yangchangkui
 * Date: 2023/7/18
 */
public interface UserMapper {
    List<UserDTO> queryUserList(String userName);
}
