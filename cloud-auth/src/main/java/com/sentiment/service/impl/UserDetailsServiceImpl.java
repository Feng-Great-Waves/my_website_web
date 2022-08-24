package com.sentiment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sentiment.constant.UserConstant;
import com.sentiment.mapper.SysPermissionMapper;
import com.sentiment.model.SysUser;
import com.sentiment.model.SysUserDetails;
import com.sentiment.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/10 15:41
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private SysPermissionMapper sysPermissionMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user = sysUserService.getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUserName, s));
        if(user == null){
            throw new UsernameNotFoundException("账户不存在");
        }
        if(UserConstant.DISABLE_STATUS == user.getStatus()){
            throw new UsernameNotFoundException("账户被禁用");
        }
        List<String> authorities = sysPermissionMapper.getAuthorities(user.getId());
        Collection<GrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (String authority : authorities) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(authority));
        }
        return new SysUserDetails(s, user.getPassword(), simpleGrantedAuthorities);
    }
}
