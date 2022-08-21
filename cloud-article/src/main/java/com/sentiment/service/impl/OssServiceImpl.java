package com.sentiment.service.impl;

import com.sentiment.constant.ServiceConstant;
import com.sentiment.service.OssService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/19 9:27
 */
@Component
public class OssServiceImpl implements OssService {
    @Override
    public String uploadImage(MultipartFile file, String userId) {
        return ServiceConstant.SERVICE_NOT_FOUND;
    }
}
