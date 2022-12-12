<template>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container">
    <router-link class="navbar-brand" :to="{name: 'home'}">TALK ROOM </router-link>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <router-link class="nav-link" :to="{name: 'home'}">首页</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" :to="{name: 'userlist'}">好友列表</router-link>
        </li>
        <li class="nav-item"  v-if="!$store.state.user.is_login">
          <router-link class="nav-link" :to="{name: 'user_account_login'}">聊天室</router-link>
        </li>       
        <li class="nav-item" v-else>
          <router-link class="nav-link" 
          :to="{name: 'talkroom',params:{userId:$store.state.user.id} }"
          >聊天室
        </router-link>
        </li>   
      </ul>
      <ul class="navbar-nav" v-if="!$store.state.user.is_login">
        <li class="nav-item">
          <router-link class="nav-link" :to="{name: 'user_account_login'}">登录</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" :to="{name: 'user_account_register'}">注册</router-link>
        </li>
      </ul>  
      <ul class="navbar-nav" v-else>
        
        <li class="nav-item">
          <router-link 
            class="nav-link" 
            :to="{name: 'userprofile',params:{userId:$store.state.user.id}}"
            >
            {{ $store.state.user.username }}
          </router-link>
        </li>
        <li class="nav-item">
          <a class="nav-link" style="cursor:pointer" @click="logout">退出</a>
        </li>
      </ul>     
    </div>
  </div>
</nav>
</template>



<script>
import{ useStore } from 'vuex';

export default{
    name:"NavBar",
    setup(){
      const store = useStore();
      const logout = () =>{
        store.dispatch("logout");
      };

      return {
        logout,
      }
    }
}
</script>



<style scoped>

</style>
