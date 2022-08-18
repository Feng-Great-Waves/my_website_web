package com.sentiment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sentiment.constant.UserConstant;
import com.sentiment.model.SysUserDetails;
import com.sentiment.model.User;
import com.sentiment.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/10 15:41
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private ISysUserService sysUserService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = sysUserService.getOne(new LambdaQueryWrapper<User>().eq(User::getUserName, s));
        if(user == null){
            throw new UsernameNotFoundException("账户不存在");
        }
        if(UserConstant.DISABLE_STATUS == user.getStatus()){
            throw new UsernameNotFoundException("账户被禁用");
        }
        ArrayList<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority(UserConstant.ROLE_PREFIX+user.getUserIdentity()));
        return new SysUserDetails(user.getId(),s, user.getPassword(), simpleGrantedAuthorities);
    }
}
