package com.chatroom.chatroombsckend.service.impl.user.account;

import com.chatroom.chatroombsckend.pojo.User;
import com.chatroom.chatroombsckend.service.impl.utils.UserDetailsImpl;
import com.chatroom.chatroombsckend.service.user.account.LoginService;
import com.chatroom.chatroombsckend.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

//实现 40min
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;//验证用户是否已经登录

    @Override
    public Map<String, String> getToken(String username, String password) {
        //将明文封装成加密字符串
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);


        System.out.println(authenticationToken.getPrincipal());
        Authentication authenticate;
        //验证是否可以正常登录,登录失败会报异常并退出
//        try {
            authenticate = authenticationManager.authenticate(authenticationToken);
//        } finally {
        System.out.println("GetToken2"+username+" "+password);
//        };



        //提取用户信息
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticate.getPrincipal();
        User user = loginUser.getUser();
        //将用户的ID提取出来并封装成JWT
        String jwt = JwtUtil.createJWT(user.getId().toString());
//        System.out.println(username+" "+password);
        Map<String ,String> map = new HashMap<>();
        map.put("error_message","success");
        map.put("token",jwt);
        System.out.println( "用户：" + username +" 登录成功");
        return map;
    }
}
