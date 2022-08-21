package com.sentiment.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/12 15:15
 */
@Data
@TableName(value = "share",autoResultMap = true)
public class Share {
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String author;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> tags;
    private String cover;
    private String title;
    private String abstracts;
    @TableField(fill = FieldFill.INSERT)
    private Integer tourNum;
    @TableField(fill = FieldFill.INSERT)
    private Integer toExamine;
    @TableField(fill = FieldFill.INSERT)
    private Integer thumbsUp;
    private String details;
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDeleted;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
