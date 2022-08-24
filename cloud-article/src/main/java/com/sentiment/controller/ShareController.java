package com.sentiment.controller;

import com.alibaba.fastjson2.JSON;
import com.github.pagehelper.PageInfo;
import com.sentiment.constant.FileConstant;
import com.sentiment.exception.ServiceException;
import com.sentiment.model.Share;
import com.sentiment.model.dto.ShareDto;
import com.sentiment.model.vo.ShareVo;
import com.sentiment.service.OssService;
import com.sentiment.service.ShareService;
import com.sentiment.utils.Result;
import com.sentiment.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/12 15:44
 */
@RestController
@RequestMapping("/article/share/list")
@CrossOrigin
public class ShareController {
    @Autowired
    private ShareService shareService;
    @Autowired
    private OssService ossService;

    @GetMapping("/{tag}")
    public Result<?> getAllShareList(@PathVariable String tag){
        List<ShareVo> listPageInfo = shareService.allShareVoList(tag);
        return Result.ok(listPageInfo);
    }

    @GetMapping("/{id}")
    public Result<?> selectById(@PathVariable List<String> id){
        Share share = shareService.getById(id.get(0));
        ShareVo shareVo = new ShareVo();
        BeanUtils.copyProperties(share,shareVo);
        return Result.ok(shareVo);
    }

    @GetMapping()
    public Result<?> getPageShareList(ShareDto shareDto){
        PageInfo<ShareVo> listPageInfo = shareService.pageShareVoList(shareDto);
        return Result.ok(listPageInfo);
    }

    @PostMapping("/pub")
    public Result<?> publishShare(@RequestParam(value = "file",required = false) MultipartFile file
            ,@RequestParam("share")String share){
        Share object = JSON.parseObject(share, Share.class);
        if (file.isEmpty()){
            object.setCover(FileConstant.THE_DEFAULT_IMAGE);
        }
        String oldFilename = file.getOriginalFilename();
        String extension = oldFilename.substring(oldFilename.lastIndexOf("."));
        if(!(FileConstant.JPG_SUFFIX.equals(extension)
                ||FileConstant.PNG_SUFFIX.equals(extension)
                ||FileConstant.GIF_SUFFIX.equals(extension))){
            throw new ServiceException("操作失败");
        }
        String s = ossService.uploadImage(file,"1");
        if (StringUtils.isEmpty(s)){
            throw new ServiceException("操作失败");
        }
        object.setCover(s);
        shareService.save(object);
        return Result.ok("操作成功");
    }
}
