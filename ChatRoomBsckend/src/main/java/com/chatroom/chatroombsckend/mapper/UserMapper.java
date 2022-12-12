package com.chatroom.chatroombsckend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chatroom.chatroombsckend.pojo.User;
import com.fasterxml.jackson.databind.JsonSerializable;
import org.apache.ibatis.annotations.Mapper;


//集成之后可以不写SQL语句
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
