package com.chatroom.chatroombsckend.service.impl.utils;

import com.chatroom.chatroombsckend.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


//用来去数据库里匹配用户名密码
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsImpl  implements UserDetails {

    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //是否没有被锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //授权是否过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //用户是否被启用
    @Override
    public boolean isEnabled() {
        return true;
    }
}
