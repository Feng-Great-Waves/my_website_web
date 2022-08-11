package com.sentiment.utils;

import com.sentiment.model.SysUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/11 15:15
 */
public class SecurityUtil {

    public static String getUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SysUserDetails principal = (SysUserDetails) authentication.getPrincipal();
        return principal.getUsername();
    }
}
