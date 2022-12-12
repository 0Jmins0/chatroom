package com.chatroom.chatroombsckend.controller.message;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Server extends Thread{

    Server (Socket socket,int num) throws IOException {
        Socket clientsocket = socket;

        System.out.println("--------Client " + num + " have connected! ---------");
        String line = "You Are Client -- ";
        DataOutputStream os = new DataOutputStream(socket.getOutputStream()); //创建输出流，给想私聊的对象
//        os.writeUTF(line + num); //把内容放到os里面
        os.writeUTF(Integer.toString(num)); //把内容放到os里面
        os.flush(); //直接刷新，让对面看到
    }
    public void run(){


    }

}
