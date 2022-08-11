package com.sentiment.controller;

import com.sentiment.model.UserInfo;
import com.sentiment.service.IUserInfoService;
import com.sentiment.utils.Result;
import com.sentiment.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/11 15:33
 */
@RestController
@RequestMapping("/auth/user")
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;

    @GetMapping("/userinfo")
    public Result<?> getUserInfo(){
        UserInfo userInfo = userInfoService.getUserInfo(SecurityUtil.getUserName());
        return Result.ok(userInfo);
    }
}
