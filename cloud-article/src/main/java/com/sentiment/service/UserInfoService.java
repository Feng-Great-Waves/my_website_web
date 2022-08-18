package com.sentiment.service;

import com.sentiment.feign.model.UserInfoFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/12 17:16
 */
@Service
@FeignClient(value = "cloud-auth",path = "/auth/feign")
public interface UserInfoService {
    /**
     * 获取当前登入用户昵称
     * @return
     */
    @GetMapping("/userinfo")
    UserInfoFeign getUserInfo();
}
