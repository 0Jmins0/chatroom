package com.chatroom.chatroombsckend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.management.remote.JMXAuthenticator;
import java.sql.SQLOutput;

@SpringBootTest
class ChatRoomBsckendApplicationTests {
    @Autowired
    private AuthenticationManager authenticationManager;//验证用户是否已经登录

    @Test
    void contextLoads() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("pyxc"));
        System.out.println(passwordEncoder.encode("pb"));
        System.out.println(passwordEncoder.encode("pc"));
        System.out.println(passwordEncoder.encode("pd"));
        System.out.println(passwordEncoder.encode("pe"));
//
//        String username = "yxc";
//        String password = "pyxc";
//        UsernamePasswordAuthenticationToken authenticationToken =
//                new UsernamePasswordAuthenticationToken(username, password);
////        验证是否可以正常登录,登录失败会报异常并退出
//        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
////        System.out.println(authenticationToken);
//


//        System.out.println(passwordEncoder.matches("pyxc","$2a$10$yUl4U5CNH8AU3EPU4GAC2.QQRw5x2ATUewPGlmETavVbSu3ZZFPyO"));
////        System.out.println(passwordEncoder.encode("pyxc"));
////        System.out.println(passwordEncoder.encode("pyxc"));
    }

}
