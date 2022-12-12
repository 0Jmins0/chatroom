package com.chatroom.chatroombsckend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //自动添加get、set、equal的public接口函数
@NoArgsConstructor //无参构造函数
@AllArgsConstructor //有参构造函数
public class User {
    @TableId(type = IdType.AUTO)//ID自新增
    private Integer  id;
    private String username;
    private String password;
    private String photo;
    private Integer followercount;
    private Integer postscount;
}

