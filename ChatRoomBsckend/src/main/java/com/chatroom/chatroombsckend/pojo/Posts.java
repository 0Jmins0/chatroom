package com.chatroom.chatroombsckend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //自动添加get、set、equal的public接口函数
@NoArgsConstructor //无参构造函数
@AllArgsConstructor //有参构造函数
public class Posts {
    private Integer  id;
    private String post;
    private Integer pid;
}

