package com.sentiment.model.dto;

import com.sentiment.model.Page;
import lombok.Data;

import java.util.List;


/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/13 14:29
 */
@Data
public class ShareDto extends Page {
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
}
