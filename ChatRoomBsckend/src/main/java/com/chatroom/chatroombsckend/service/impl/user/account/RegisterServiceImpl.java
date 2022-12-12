package com.chatroom.chatroombsckend.service.impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chatroom.chatroombsckend.mapper.UserMapper;
import com.chatroom.chatroombsckend.pojo.User;
import com.chatroom.chatroombsckend.service.user.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterServiceImpl implements RegisterService {

    //注入数据库
    @Autowired
    private UserMapper  userMapper;

    //注入加密方法
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Map<String, String> register(String username, String password, String confirmedPassword) {
        Map<String, String> map = new HashMap<>();

//<----------------------------------------特判注册信息是否合法--------------------------------------------->
        if (username == null) {
            map.put("error_message", "用户名不能为空");
            return map;
        }
        if (password == null){
            map.put("error_message","密码不能为空");
            return map;
        }

        username = username.trim();//删除首尾空白字符
        if(username.length() == 0){
            map.put("error_message","用户名不能为空");
            return map;
        }

        if(password.length() == 0 || confirmedPassword.length() == 0){
            map.put("error_message","密码不能为空");
            return map;
        }
        if(username.length()>100){
            map.put("error_message","用户名长度不能超过100");
            return map;
        }

        if(password.length()>100||confirmedPassword.length()>100){
            map.put("error_message","密码长度不能超过100");
            return map;
        }

        if(!password.equals(confirmedPassword)){
            map.put("error_message","两次输入的密码不一致");
            return map;
        }

        //定义比较条件,判断用户名是否存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        List<User> users = userMapper.selectList(queryWrapper);

        if(!users.isEmpty()){
            map.put("error_message","用户名已存在");
            return map;
        }

//<----------------------------------------密码加密存储--------------------------------------------->

        String encodePassword = passwordEncoder.encode(password);
        String photo = "https://cdn.acwing.com/media/user/profile/photo/172159_lg_3805580276.jpg";
        User user = new User(null ,username,encodePassword,photo,0,0);
        userMapper.insert(user);
        System.out.println( "用户：" + username +" 注册成功");
        map.put("error_message","success");
        return map;
    }
}
