package com.sentiment.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/22 15:07
 */
@Data
@TableName("sys_role_permission")
public class SysRolePermission {
    private Long roleId;
    private Long permissionId;
}
