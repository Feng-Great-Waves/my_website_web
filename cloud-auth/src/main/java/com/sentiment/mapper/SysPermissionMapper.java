package com.sentiment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sentiment.model.SysPermission;

import java.util.List;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/22 15:20
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    /**
     * 根据用户id获取权限
     * @param userId 用户id
     * @return
     */
    List<String> getAuthorities(Long userId);

}
