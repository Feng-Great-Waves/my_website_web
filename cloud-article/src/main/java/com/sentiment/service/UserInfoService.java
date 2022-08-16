package com.sentiment.service;

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

    @GetMapping("/usernick")
    String getUserNick();
}
