package com.yck.user.service.impl;

import com.yck.user.dto.UserDTO;
import com.yck.user.mapper.UserMapper;
import com.yck.user.service.UserService;
import com.yck.user.util.HttpRequestUtil;
import org.apache.ibatis.util.MapUtil;
import org.omg.CORBA.TIMEOUT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private static final String API_URL = "https://api.deepseek.com/v1/chat/completions";
    private static final String API_KEY = "sk-80f44ef337334d8dbbb69ea86219be2e";

    public List<UserDTO> queryUser(String userName) {
        redisTemplate.opsForValue().set("YCK", userName, 10, TimeUnit.SECONDS);
        String yck = redisTemplate.opsForValue().get("YCK").toString();
        return userMapper.queryUserList(yck);
    }

    @Override
    public String queryDeepseek(Map<String, Object> requestParam) {
        String question = (String) requestParam.get("question");
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> message = new HashMap<>();
        message.put("content", question);
        message.put("role", "system");
        map.put("messages", Stream.of(message).collect(Collectors.toList()));
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("type", "text");
        map.put("response_format", responseMap);
        map.put("model", "deepseek-chat");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        httpHeaders.add("Accept", "application/json");
        httpHeaders.add("Authorization", "Bearer " + API_KEY);
        HttpEntity tHttpEntity = new HttpEntity<Map>(map, httpHeaders);
        String s = HttpRequestUtil.postForObject(API_URL, String.class, tHttpEntity);
        return s;
    }

    @Override
    public Map beta(Map<String, Object> requestParam) {
        String url = "https://api.deepseek.com/beta/completions";
        Map<String, Object> request = new HashMap<>();
        request.put("model","deepseek-chat");
        request.put("prompt", (String) requestParam.get("question"));
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer "  + API_KEY);
        httpHeaders.add("Content-Type", "application/json");
        httpHeaders.add("Accept", "application/json");
        HttpEntity<Map> mapHttpEntity = new HttpEntity<>(request, httpHeaders);
        return HttpRequestUtil.postForObject(url, Map.class, mapHttpEntity);
    }


}
