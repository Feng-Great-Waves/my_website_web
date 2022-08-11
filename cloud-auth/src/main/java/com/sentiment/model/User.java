package com.sentiment.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/10 15:38
 */
@Data
@TableName("sys_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String userName;
    private String password;
    private Integer isDeleted;
    private String userIdentity;
    private Long userId;
    private Integer status;
    private String userType;
    private Date createTime;
    private Date updateTime;
}
