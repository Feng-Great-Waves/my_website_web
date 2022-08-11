package com.sentiment.controller;

import com.sentiment.model.SysUserDetails;
import com.sentiment.model.dto.LoginUserDto;
import com.sentiment.service.IUserLoginService;
import com.sentiment.utils.Result;
import com.sentiment.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/10 17:35
 */
@RestController
@RequestMapping("/auth/user")
public class LoginController {
    @Autowired
    private IUserLoginService userLoginService;

    @PostMapping("/login")
    public Result<?> userLogin(@RequestBody LoginUserDto loginUser){
        String token = userLoginService.login(loginUser);
        if(token==null) {
            return Result.fail("登入失败");
        }
        return Result.ok(token,"登入成功");
    }
}
