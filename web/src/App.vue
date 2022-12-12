<template>
  <NavBar />
  <router-view :key="$route.fullPath"/>
</template>

<script>
// import { exportDefaultSpecifier } from '@babel/types';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap';
import NavBar from './components/NavBar';
// import $ from 'jquery'

export default{
  name: "App",
  components:{
    NavBar,
  },
  setup(){
    // $.ajax({
    //   url: "http://127.0.0.1:3000/user/account/token/",
    //   type: "post",
    //   data: {
    //     username: 'b',
    //     password: 'pb',
    //   },
    //   success(resp){
    //     console.log(resp);
    //   },
    //   error(resp){
    //     console.log(resp);
    //   }
    // });

    // $.ajax({
    //   url:"http://127.0.0.1:3000/user/account/info/",
    //   type:"get",
    //   headers:{
    //     Authorization:"Bearer "+"eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI3NGFjMjJkNWRiNGE0YmJlOTM5Y2ZmZDcxZjQxNGEzZiIsInN1YiI6IjIiLCJpc3MiOiJzZyIsImlhdCI6MTY3MDQzMzE4NCwiZXhwIjoxNjcxNjQyNzg0fQ.48DX6IAVUbN-oik7TkCBtbEE_q7Jzt2fV9XdHJlBQTc"
    //   },
    //   success(resp){
    //     console.log(resp);
    //   },
    //   error(resp){
    //     console.log(resp);
    //   }
    // });

    // $.ajax({
    //   url:"http://127.0.0.1:3000/user/account/register/",
    //   type:"post",
    //   data:{
    //     username:"zxy",
    //     password:"pzxy",
    //     confirmedPassword:"pzxy",
    //   },
    //   success(resp){
    //     console.log(resp);
    //   },
    //   error(resp){
    //     console.log(resp);
    //   }
    // })
  }
}
</script>



<style>
</style>
