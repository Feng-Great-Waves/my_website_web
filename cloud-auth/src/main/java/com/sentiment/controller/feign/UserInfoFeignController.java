package com.sentiment.controller.feign;

import com.sentiment.feign.model.UserInfoFeign;
import com.sentiment.model.UserInfo;
import com.sentiment.service.IUserInfoService;
import com.sentiment.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/13 13:51
 */
@RestController
@RequestMapping("/auth/feign")
public class UserInfoFeignController {
    @Autowired
    private IUserInfoService userInfoService;

    @GetMapping("/userinfo")
    public UserInfoFeign getUserNick(){
        UserInfo userInfo = userInfoService.getById(SecurityUtil.getUserId());
        return new UserInfoFeign(userInfo.getId(), userInfo.getUserName(), userInfo.getNickName());
    }

/*    @GetMapping("/usernick")
    public String getUserNick(){
        UserInfo userInfo = userInfoService.getUserInfo(SecurityUtil.getUserName());
        return userInfo.getNickName();
    }*/
}
