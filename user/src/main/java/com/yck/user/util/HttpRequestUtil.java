package com.yck.user.util;

import org.springframework.web.client.RestTemplate;

public class HttpRequestUtil {

    public static <T> T postForObject(String url, Class<T>  tClass, Object req) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url, req, tClass);
    }
}
