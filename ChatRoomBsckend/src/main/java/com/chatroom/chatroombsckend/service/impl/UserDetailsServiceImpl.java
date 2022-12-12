package com.chatroom.chatroombsckend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chatroom.chatroombsckend.mapper.UserMapper;
import com.chatroom.chatroombsckend.pojo.User;
import com.chatroom.chatroombsckend.service.impl.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


//用来去数据库里匹配用户名密码
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    //需要对接数据库
    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        User user = userMapper.selectOne(queryWrapper);
        if(user == null){
            throw new RuntimeException("用户不存在");
        }
        return new UserDetailsImpl(user);
    }
}
