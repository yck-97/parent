package com.yck.user.controller;

import com.yck.user.dto.UserDTO;
import com.yck.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/query")
    @ResponseBody
    public ResponseEntity queryUser(@RequestParam String name) {
        List<UserDTO> userDTOS = userService.queryUser(name);
        return ResponseEntity.ok(userDTOS);
    }


    @RequestMapping("/deepseek")
    @ResponseBody
    public ResponseEntity queryDeepseek(@RequestBody Map<String, Object> requestParam) {
        String content = userService.queryDeepseek(requestParam);
        return ResponseEntity.ok(content);
    }

    @RequestMapping("/beta")
    @ResponseBody
    public ResponseEntity beta(@RequestBody Map<String, Object> requestParam) {
        Map content = userService.beta(requestParam);
        return ResponseEntity.ok(content);
    }
}

