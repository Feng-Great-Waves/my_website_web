package com.sentiment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sentiment.mapper.UserInfoMapper;
import com.sentiment.model.UserInfo;
import com.sentiment.service.IUserInfoService;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/11 15:31
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    /**
     * 获取用户信息
     * @param userName 用户名
     * @return
     */
    @Override
    public UserInfo getUserInfo(String userName) {
        UserInfo userInfo = getOne(new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getUserName, userName));
        if(Objects.isNull(userInfo)){
            return null;
        }
        return userInfo;
    }
}
