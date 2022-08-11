package com.sentiment.service;

import com.sentiment.model.dto.LoginUserDto;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/11 10:22
 */
public interface IUserLoginService {

    /**
     * 登入
     * @param loginUser 用户信息
     * @return
     */
    String login(LoginUserDto loginUser);
}
