package com.yck.product.mapper;


import com.yck.product.dto.UserDTO;

import java.util.List;

/**
 * 描述
 * Author：yangchangkui
 * Date: 2023/7/18
 */
public interface UserMapper {
    List<UserDTO> queryUserList(String userName);
}
