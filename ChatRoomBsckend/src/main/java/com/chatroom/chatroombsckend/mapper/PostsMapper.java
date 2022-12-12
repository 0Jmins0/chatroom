package com.chatroom.chatroombsckend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chatroom.chatroombsckend.pojo.Posts;
import org.apache.ibatis.annotations.Mapper;


//集成之后可以不写SQL语句
@Mapper
public interface PostsMapper extends BaseMapper<Posts> {

}
