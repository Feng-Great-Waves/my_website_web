package com.sentiment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sentiment.mapper.UserMapper;
import com.sentiment.model.User;
import com.sentiment.service.ISysUserService;
import org.springframework.stereotype.Service;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/10 15:40
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<UserMapper, User> implements ISysUserService {
}
