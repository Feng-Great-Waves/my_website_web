package com.sentiment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sentiment.mapper.SysRoleMapper;
import com.sentiment.model.SysRole;
import com.sentiment.service.ISysRoleService;
import org.springframework.stereotype.Service;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/22 15:14
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
}
