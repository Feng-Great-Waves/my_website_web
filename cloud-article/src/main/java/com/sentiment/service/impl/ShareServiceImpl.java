package com.sentiment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sentiment.mapper.ShareMapper;
import com.sentiment.model.Share;
import com.sentiment.model.dto.ShareDto;
import com.sentiment.model.vo.ShareVo;
import com.sentiment.service.ShareService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/12 15:49
 */
@Service
public class ShareServiceImpl extends ServiceImpl<ShareMapper, Share> implements ShareService {

    /**
     * 根据类型获取文章数据
     * @param tag 类型
     * @return
     */
    @Override
    public List<ShareVo> allShareVoList(String tag) {
        List<Share> list = list();
        return list.stream().map(item -> {
            ShareVo shareVo = new ShareVo();
            for (String itemTag : item.getTags()) {
                if (itemTag.equals(tag)) {
                    BeanUtils.copyProperties(item, shareVo);
                }
            }
            return shareVo;
        })
                .filter(s->s.getId()!=null)
                .sorted(Comparator.comparing(ShareVo::getUpdateTime).reversed())
                .collect(Collectors.toList());
    }

    /**
     * 分页数据
     * @param shareDto
     * @return
     */
    @Override
    public PageInfo<ShareVo> pageShareVoList(ShareDto shareDto) {
        PageHelper.startPage(shareDto.getPageNum(),shareDto.getPageSize());
       return new PageInfo<>(list(new LambdaQueryWrapper<Share>().orderByDesc(Share::getUpdateTime)).stream().map(item->{
            ShareVo shareVo = new ShareVo();
            BeanUtils.copyProperties(item,shareVo);
            return shareVo;
        }).collect(Collectors.toList()));
    }
}
