package com.chatroom.chatroombsckend.controller.message;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/websocket/{username}")
@Slf4j
public class WebSocketServer {

    //当前人数
    public static Integer cnt = 0;

    private Session session;

    //记录连接的sesson
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();

    private String username ="";

    @OnOpen
    public void OnOpen(Session session,@PathParam("username") String username){
        this.session = session;
        this.username = username;
        webSocketSet.add(this);
        cnt ++;
        System.out.println("clint:" + username + "已连接");
        try{
            Map<String,String> m=new HashMap<>();
            m.put("error_message","connect success");
            SendMessage(session,tojson(m));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @OnMessage
    public void OnMessage(String message,Session session) throws IOException {
        System.out.println("收到来自" + username + "的消息:" +message);
        char mm[] =new char[100000] ;
        mm = message.toCharArray();
        String s[] = new String[2];
        s=message.split(":");

        System.out.println(s[0]);
       if(!s[0].equals("All")&&s.length>1){
           for(WebSocketServer obj : webSocketSet){

               if(obj.username.equals(s[0])){
                   Map <String ,String> m = new HashMap<>();
                   m.put("username",this.username);
                   m.put("error_message","accept_message");
                   m.put("message",s[1]);
                   SendMessage(obj.session,tojson(m));
                   System.out.println("to"+obj.username);
               }
               else if (obj.session == session){
                   Map <String ,String> m = new HashMap<>();
                   m.put("username",this.username);
                   m.put("error_message","send_message");
                   m.put("message",s[1]);
                   SendMessage(obj.session,tojson(m));
                   System.out.println("from"+obj.username);
               }
           }
        }
        else {
            if(s.length==1)
            SendAll(s[0], session);
            else {
                SendAll(s[1], session);
            }
        }
    }
    @OnClose
    public void OnClose(Session session,@PathParam("userId") String userId){
        webSocketSet.remove(this);
        cnt -- ;
        System.out.println("clint:" + username + "已断开");
        try{
            Map<String,String> m=new HashMap<>();
            m.put("error_message","disconnect success");
            SendMessage(session,tojson(m));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void SendAll(String message,Session session) throws IOException {
        for (WebSocketServer obj : webSocketSet){
            if(obj.session != session){
                Map <String ,String> m = new HashMap<>();
                m.put("username",this.username);
                m.put("error_message","accept_message");
                m.put("message",message);
                SendMessage(obj.session,tojson(m));
            }
            else {
                Map <String ,String> m = new HashMap<>();
                m.put("username",this.username);
                m.put("error_message","send_message");
                m.put("message",message);
                SendMessage(obj.session,tojson(m));
            }
        }
    }
    public void SendMessage(Session session,String msg) throws IOException {
        session.getBasicRemote().sendText(msg);
    }
    //发送消息前，转成string
    public String tojson(Map<String,String> map){
        return JSON.toJSONString(map);
    }

    //接收消息后，转回map处理
    public Map<String,String> tomap(String msg){
        return (Map)JSON.parse(msg);
    }
}
