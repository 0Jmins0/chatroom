<template>
  <ContentBase >
    <div class="row justify-content-md-center" id="show">
          <div class="col-8"> 
            <ChatRoomShow :messagelist = "messagelist">

            </ChatRoomShow>
          </div>
    </div>
    <div class="row justify-content-md-center" id="tool">
       <div class="col-8"> 
        <ChatRoomTool @post_a_file="post_a_file"></ChatRoomTool>
       </div>
    </div>

    <div class="row justify-content-md-center" id="input">
       <div class="col-8"> 
        <ChatRoomInput @post_a_post="post_a_post" ></ChatRoomInput>
       </div>
       
    </div>

  </ContentBase>
</template>

<script>
import ContentBase from '../components/ContentBase';
import ChatRoomShow from '../components/ChatRoomShow';
import ChatRoomInput from '../components/ChatRoomInput';
import ChatRoomTool from '../components/ChatRoomTool';
import {  reactive } from 'vue';
// import { reactive  } from 'vue';
import $ from 'jquery';
import { computed } from 'vue';
import { useStore } from 'vuex';
import { useRoute } from 'vue-router';
// import socket from '@/store/socket';
// import socket from '../store/socket.js';
// import{ io } from "socket.io-client"

export default {
  name: 'TalkRoomView',
  components: {
    ContentBase,
    ChatRoomShow,
    ChatRoomInput,
    ChatRoomTool,
  },
  setup() {
    // const transferMessage = (data) =>{
    //   console.log(data);
    // }
    // const start = () =>{
    //   socket.emit("start","开始");
    // };

    // const stop = () => {
    //   socket.emit("stop","暂停");
    // }
    const store = useStore();
    const route = useRoute();
    const userId = parseInt(route.params.userId);
    const user = reactive({});
    let messagelist = reactive([]);

    $.ajax({
      url:'http://localhost:3000/user/Id',
      type: "GET",
      data:{
        userId:userId,
      },
      success(resp){
        
        user.id = resp.id;
        user.username = resp.username;
        user.photo = resp.photo;
        user.followercount = resp.followercount;
        user.is_followed = false;
        user.postscount = resp.postscount;
        console.log(user);
      }
    },300);

    // console.log(userId,store.state.user.id);
    const is_me = computed(() => userId == store.state.user.id);

    console.log("user:"+user);
    
    let socketurl = "ws://localhost:3000/websocket/"+store.state.user.username;

    console.log(socketurl);

    let socket;
    socket = new WebSocket(socketurl);
      socket.onpen = function(){
      console.log("socket已打开");
      }
    //  浏览器端收消息，获得从服务端发送过来的文本消息
    socket.onmessage = function (msg) {
         console.log("收到数据====" + msg.data)
          let data = JSON.parse(msg.data)
          
          if(data.error_message === "connect success"){
          console.log(data);
          }else if(data.error_message === "accept_message" || data.error_message === "send_message"){
            messagelist.push(data);
            console.log("list:"+messagelist[0].username);
            console.log("data:"+data.message);
          }
    };      
    const post_a_post = (post) =>{
      console.log("post_a_post");
      socket.send(post);
      
    }
    const post_a_file = (post) =>{
      console.log("post_a_file");
      socket.send(post);
    }
    const disconnect = () =>{
      socket.onclose = function(){
        console.log("连接已断开");
      }
    }
    // socket.onclose = function(){
    //   console.log("连接已断开");

    // socket.sendMessage("sdasd");
    // }

    // if (typeof (WebSocket) == "undefined") {
    //       console.log("您的浏览器不支持WebSocket");
    //     } else {
    //       console.log("您的浏览器支持WebSocket");
    //       let socketUrl = "ws://localhost:8888/socket/" + this.user;
    //       if (socket != null) {
    //         socket.close();
    //         socket = null;
    //       }
    //       // 开启一个websocket服务
    //       socket = new WebSocket(socketUrl);
    //       //打开事件
    //       socket.onopen = function () {
    //         console.log("websocket已打开");
    //       }}

    return {
      user,
      is_me,
      disconnect,
      post_a_post,
      messagelist,
      post_a_file,
      // start,
      // stop,
      // sendMessage,
      // transferMessage,
    }
  }
}
</script>

<style scoped>

</style>