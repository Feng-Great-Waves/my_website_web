package com.sentiment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sentiment.mapper.SysUserMapper;
import com.sentiment.model.SysUser;
import com.sentiment.service.ISysUserService;
import org.springframework.stereotype.Service;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/22 14:58
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
}
