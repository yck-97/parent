package com.yck.user.dto;

import lombok.Data;

/**
 * 描述: user实体
 * Author：yangchangkui
 * Date: 2023/7/18
 */
@Data
public class UserDTO {
    private int id;

    private String userName;

    private String userAge;

    private String password;

    private String realname;
}
