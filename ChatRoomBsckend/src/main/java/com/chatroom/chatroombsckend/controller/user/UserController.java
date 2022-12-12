package com.chatroom.chatroombsckend.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chatroom.chatroombsckend.mapper.PostsMapper;
import com.chatroom.chatroombsckend.mapper.UserMapper;
import com.chatroom.chatroombsckend.pojo.Posts;
import com.chatroom.chatroombsckend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;//引用接口
    //  https://baomidou.com/pages/49cc81/#service-crud-%E6%8E%A5%E5%8F%A3  接口用法官网



//  //  @RequestMapping //把所有类型的请求都映射出来
//    @GetMapping("/user/all/") //只映射Get类型的请求
//    public List<User>  getAll(){
//        return userMapper.selectList(null);//查询所有
//    }


    //查询
    @GetMapping("/user/Id")
    public User getuser(int userId){

        System.out.println(userId);
        //封装选择器
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",userId);//列id = userId
//        queryWrapper.ge("id",2).le("id",3);// 查询 2<=id<=3 的所有用户
        return userMapper.selectOne(queryWrapper);//根据查询条件返回
        //return userMapper.selectById(userId); //和上方等效
    }

    //查询全部
    @GetMapping("/user/all")
    public List<User> getall(){
        //封装选择器
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*");//列id = userId
//        queryWrapper.ge("id",2).le("id",3);// 查询 2<=id<=3 的所有用户
        return userMapper.selectList(queryWrapper);//根据查询条件返回
        //return userMapper.selectById(userId); //和上方等效
    }



    @Autowired
    PostsMapper postsMapper;//引用接口

    @GetMapping("/user/getposts")
    public List<Posts> getpost(int userId){
        QueryWrapper<Posts> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",userId);//列id = userId
        return postsMapper.selectList(queryWrapper);
    }

    @GetMapping("/user/putposts")
    public String putpost(int userId,String post,int pid){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",userId);//列id = userId
//        queryWrapper.ge("id",2).le("id",3);// 查询 2<=id<=3 的所有用户
        User user = userMapper.selectOne(queryWrapper);//根据查询条件返回
        System.out.println(user);
        userMapper.delete(queryWrapper);
        user.setPostscount(pid);


        Posts posts = new Posts (userId,post,pid);
        postsMapper.insert(posts);
        userMapper.insert(user);
        System.out.println(user);
        return "Add User Successfully!";
    }

//    //插入
//    // 访问 http://localhost:8080/user/add/5/e/pe/ 即可插入{5,e,pe}
//    @GetMapping("/user/add/{userId}/{username}/{password}/")
//    public String addUser(
//            @PathVariable int userId,
//            @PathVariable String username,
//            @PathVariable String password ){
//
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodePassword = passwordEncoder.encode(password);
//        User user = new User(userId,username,encodePassword);
//        userMapper.insert(user);//插入一行
//        return "Add User Successfully!";
//    }
//
//    //删除
//    @GetMapping("/user/delete/{userId}")
//    public String deleteUser(@PathVariable int userId){
//        userMapper.deleteById(userId);
//        return "Delete User Successfully!";
//    }
}
