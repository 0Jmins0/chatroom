//package com.chatroom.chatroombsckend.controller;
//
//import com.chatroom.chatroombsckend.service.memssage.SendMessageService;
//import com.chatroom.chatroombsckend.service.user.account.LoginService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//public class SendMessageController {
//    @Autowired
//    private SendMessageService SendMassageService;
//
//    @PostMapping ("/message/sendmessage/")
//    public Map<String ,String> getToken(@RequestParam Map<String,String> map){
//        String userid = map.get("userid");
//        String content = map.get("content");
//        return SendMassageService.sendmessage(userid,content);
//    }
//}
