package com.sentiment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.sentiment.model.Share;
import com.sentiment.model.dto.ShareDto;
import com.sentiment.model.vo.ShareVo;

import java.util.List;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/12 15:48
 */
public interface ShareService extends IService<Share> {

    /**
     * 根据类型获取全部文章数据
     * @param tag 类型
     * @return
     */
    List<ShareVo> allShareVoList(String tag);

    /**
     * 分页数据
     * @param shareDto
     * @return
     */
    PageInfo<ShareVo> pageShareVoList(ShareDto shareDto);
}
