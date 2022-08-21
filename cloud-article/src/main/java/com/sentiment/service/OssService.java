package com.sentiment.service;

import com.sentiment.service.impl.OssServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/18 14:29
 */
@Service
@FeignClient(value = "cloud-oss",path = "/oss/image",fallback = OssServiceImpl.class)
public interface OssService {
    /**
     * 上传图片
     * @param file 文件
     * @param userId 用户id
     * @return
     */
    @PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadImage(@RequestPart("file") MultipartFile file,@RequestParam("userId") String userId);
}
