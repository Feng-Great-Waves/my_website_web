package com.sentiment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sentiment.mapper.SysPermissionMapper;
import com.sentiment.model.SysPermission;
import com.sentiment.service.ISysPermissionService;
import org.springframework.stereotype.Service;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/22 15:20
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission>  implements ISysPermissionService {
}
