package com.sentiment.model.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/12 17:03
 */
@Data
public class ShareVo {
    /**
     * 文章id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 作者
     */
    private String author;
    /**
     * 文章标签
     */
    private List<String> tags;
    /**
     * 文章封面
     */
    private String cover;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章描述
     */
    private String abstracts;
    /**
     * 文章游览次数
     */
    private Integer tourNum;
    /**
     * 文章点赞次数
     */
    private Integer thumbsUp;
    /**
     * 文章详情
     */
    private String details;
    /**
     * 文章发表时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 文章是否游览
     */
    private Integer whetherToVisit;
    /**
     * 文章是否点赞
     */
    private Integer whetherToLike;
}
