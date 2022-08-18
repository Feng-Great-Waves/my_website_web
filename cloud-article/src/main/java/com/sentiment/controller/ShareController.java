package com.sentiment.controller;

import com.github.pagehelper.PageInfo;
import com.sentiment.model.Page;
import com.sentiment.model.Share;
import com.sentiment.model.dto.ShareDto;
import com.sentiment.model.vo.ShareVo;
import com.sentiment.service.ShareService;
import com.sentiment.service.UserInfoService;
import com.sentiment.utils.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/12 15:44
 */
@RestController
@RequestMapping("/article/share")
public class ShareController {
    @Autowired
    private ShareService shareService;
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/alllist/{tag}")
    public Result<?> getAllShareList(@PathVariable String tag){
        List<ShareVo> listPageInfo = shareService.allShareVoList(tag);
        System.out.println(userInfoService.getUserInfo());
        return Result.ok(listPageInfo);
    }

    @GetMapping("/pagelist")
    public Result<?> getPageShareList(@RequestBody ShareDto shareDto){
        PageInfo<ShareVo> listPageInfo = shareService.pageShareVoList(shareDto);
        return Result.ok(listPageInfo);
    }
}
