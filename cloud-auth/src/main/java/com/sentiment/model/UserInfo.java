package com.sentiment.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/11 15:26
 */
@Data
@TableName("sys_user_info")
public class UserInfo {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String userName;
    private String nickName;
    private String sex;
    private Date createTime;
    private Date updateTime;
}
