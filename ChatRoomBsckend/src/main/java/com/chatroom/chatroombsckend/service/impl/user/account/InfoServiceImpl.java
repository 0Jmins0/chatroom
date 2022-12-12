package com.chatroom.chatroombsckend.service.impl.user.account;

import com.chatroom.chatroombsckend.pojo.User;
import com.chatroom.chatroombsckend.service.impl.utils.UserDetailsImpl;
import com.chatroom.chatroombsckend.service.user.account.InfoService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;



@Service
public class InfoServiceImpl implements InfoService {
    @Override
    public Map<String, String> getinfo() {
        System.out.println("getinfo");
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();


        User user = loginUser.getUser();

        Map<String ,String > map = new HashMap<>();
        map.put("error_message","success");
        map.put("id",user.getId().toString());
        map.put("username",user.getUsername());
//        map.put("photo", user.getPhoto());
//        map.put("followerCount",user.getFollowerCount());
        System.out.println( "用户：" + user.getUsername()+" 获取信息成功");
        return map;
    }
}
