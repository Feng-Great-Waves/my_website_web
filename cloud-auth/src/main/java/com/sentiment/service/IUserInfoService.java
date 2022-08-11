package com.sentiment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sentiment.model.UserInfo;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/11 15:31
 */
public interface IUserInfoService extends IService<UserInfo> {

    /**
     * 根据当前登入获取用户信息
     * @param userName 用户名
     * @return
     */
    UserInfo getUserInfo(String userName);

}
