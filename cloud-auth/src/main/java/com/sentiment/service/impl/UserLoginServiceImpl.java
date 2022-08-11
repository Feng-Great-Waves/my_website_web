package com.sentiment.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONObject;
import com.sentiment.model.dto.LoginUserDto;
import com.sentiment.service.IUserLoginService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/11 10:22
 */
@Service
public class UserLoginServiceImpl implements IUserLoginService {
    @Value("${login.url}")
    private String loginUrl;
    @Override
    public String login(LoginUserDto loginUser) {
        HashMap<String, Object> paramMap = new HashMap<>(16);
        paramMap.put("client_id","8P.~gR%");
        paramMap.put("client_secret", "sentiment");
        paramMap.put("grant_type", "password");
        paramMap.put("username", loginUser.getUserName());
        paramMap.put("password", loginUser.getPassword());
        String post = HttpUtil.post(loginUrl+"/oauth/token", paramMap);
        JSONObject jsonObject = JSONObject.parseObject(post);
        String accessToken = jsonObject.get("access_token").toString();
        if(accessToken==null){
            return null;
        }
        return accessToken;
    }
}
