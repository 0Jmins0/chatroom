//package com.chatroom.chatroombsckend.controller;
//
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class Center {
//    static int servernum = 1;//当前在线人数+1，用来循环监听时，直接存储到socket[servernum]
//    public static Socket[] socket = new Socket[100];//存储当前连接的用户的socket
//    public static void main(String args[]) throws Exception{
//        ServerSocket sc = null;
//        try{
//            sc = new ServerSocket(9000);   //创建监听端口
//        }
//        catch (IOException e){
//            System.out.println("Failed!");
//            System.exit(-1);
//        }
//        while (true){
//            socket[servernum] = sc.accept();//存储socket
//            new Server(socket[servernum],servernum).start();//启动线程
//            servernum ++;//在线线程++
//        }
//    }
//}
