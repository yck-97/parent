package com.yck.product.controller;


import com.yck.product.dto.UserDTO;
import com.yck.product.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api("测试")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/query")
    @ResponseBody
    @ApiOperation(value = "查询")
    public ResponseEntity queryUser(@RequestParam String name) {
        List<UserDTO> userDTOS = userService.queryUser(name);
        return ResponseEntity.ok(userDTOS);
    }

}

