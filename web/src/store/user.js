import router from '@/router';
import $ from 'jquery';
// import jwt_decode from 'jwt-decode';

const ModuleUser ={
  // 存数据
  state: {
    id: "",
    username: "",
    pthoto: "",
    followercount: "",
    // access:"",
    // refresh:"",
    is_login: false,
    token:"",
  },

  //需要计算的内容
  getters: {
  },

//对于state的修改的方式
  mutations: {
    updateUser(state,user){
        state.id = user.id;
        state.username = user.username;
        state.photo = user.photo;
        state.followercount = user.followercount;
        // state.access = user.access;
        // state.refresh = user.refresh;
        state.is_login = user.is_login;
    },
    // updateAccess(state, access){
    //     state.access = access; 
    // },
    // logout(state){
    //     state.id = '';
    //     state.username = '';
    //     state.photo = '';
    //     state.followerCount = 0;
    //     // state.access = '';
    //     state.refresh = '';
    //     state.is_login = false;
    // },
    updateToken(state,token){
        state.token = token;
    },
    logout(state){
        state.id = "";
        state.username = "";
        state.photo = "";
        state.followercount = "";
        // state.access = user.access;
        state.refresh = "";
        state.is_login = false;
    }
  },

  //各种操作
  actions: {
    login: (context, data) =>{
        $.ajax({
            url: "http://127.0.0.1:3000/user/account/token/",
            type:"post",
            data:{
                username: data.username,
                password: data.password,
            },
            success(resp){
                if(resp.error_message === "success"){
                    localStorage.setItem("jwt_token",resp.token);//实现刷新后仍然能够保持登录状态
                    context.commit("updateToken",resp.token);     
                    data.success(resp);              
                }else{
                    console.log("dad");
                    data.error(resp);
                }
            },
            error(resp){
                data.error(resp);
            }
        });
    },
    getinfo(context,data){
        $.ajax({
            url:"http://127.0.0.1:3000/user/account/info/",
            type:"get",
            headers:{
                Authorization:"Bearer "+ context.state.token,
            },
            success(resp){
                if(resp.error_message === "success"){
                    context.commit("updateUser",{
                        ...resp,
                        is_login:true,
                    });
                    data.success(resp);                    
                }else{
                    data.error(resp);
                }
            },
            error(resp){
                data.error(resp);
            }
        })
    },
    logout(context){
        localStorage.removeItem("jwt_token");
        context.commit("logout");
        router.push({name:"home"});
    }
  },

  //对state进行分割
  modules: {
  }
};
export default ModuleUser;