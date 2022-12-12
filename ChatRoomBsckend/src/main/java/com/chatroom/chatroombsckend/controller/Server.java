//package com.chatroom.chatroombsckend.controller;
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.Socket;
//
////启动线程
//public class Server extends java.lang.Thread {
//    Socket socketclink = null ;//要连接的客户端对象
//    Socket socketservice = null;//要连接服务器对象
//    int cnt;//自己是第几个客户端
//
//    public Server(Socket s,int num) throws Exception{ //构造函数
//        socketservice = s;//要连接到的服务器
//        cnt = num;
//        System.out.println("客户端"+num+"加入群聊！");
////        DataOutputStream os = new DataOutputStream(socketservice.getOutputStream());///////
////        os.writeUTF(Integer.toString(num));
////        os.flush();//刷新缓冲区
//    }
//    public void run() {
//        try{
//            DataInputStream is = new DataInputStream(socketservice.getInputStream());
//            if(is.available()>0){//如果有输入
//                String receive = is.readUTF();//放到输入流里
//
////            String[] incontent = recive.split(":");//从输入流中获取用户编号和内容
////            String outcontent =incontent[1];
//                for(int i=1;i<Center.servernum;i++){
//                    socketclink = Center.socket[i];//发送的目标
//                    DataOutputStream os = new DataOutputStream(socketclink.getOutputStream());
//                    os.writeUTF(receive);
//                    os.flush();
//                }
//            }
//        }
//        catch (Exception e){
//            System.out.println(e);
//        }·  14
//    }
//
//
//}
