package com.sentiment.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONObject;
import com.sentiment.exception.ServiceException;
import com.sentiment.model.dto.LoginUserDto;
import com.sentiment.service.IUserLoginService;
import com.sentiment.utils.RedisCache;
import com.sentiment.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private RedisCache redisCache;
    @Override
    public String login(LoginUserDto loginUser) {
        String cacheObject = redisCache.getCacheObject(loginUser.getKey());
        if(!loginUser.getCode().equals(cacheObject)){
            throw new ServiceException("验证码错误");
        }
        HashMap<String, Object> paramMap = new HashMap<>(16);
        paramMap.put("client_id","8P.~gR%");
        paramMap.put("client_secret", "sentiment");
        paramMap.put("grant_type", "password");
        paramMap.put("username", loginUser.getUserName());
        paramMap.put("password", loginUser.getPassword());
        String post = HttpUtil.post(loginUrl+"/oauth/token", paramMap);
        JSONObject jsonObject = JSONObject.parseObject(post);
        String accessToken = jsonObject.get("access_token").toString();
        if(StringUtils.isEmpty(accessToken)){
            throw new ServiceException("操作失败");
        }
        return accessToken;
    }
}
