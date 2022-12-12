package com.chatroom.chatroombsckend.controller.message;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping
public class IndexController {
    @RequestMapping("/message/index")
    public String index(){ return "message/index.html";}
}
