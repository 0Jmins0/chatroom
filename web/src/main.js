import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import 'element-plus/dist/index.css';
import ElementPlus from 'element-plus';
// import VueSocketIO from 'vue-3-socket.io'
// import io from 'socket.io-client';
// const socketio = new VueSocketIO({
//     debug: true,
//     connection: io('http://localhost:8081',{ transports : ['websocket'] }),
// 	//http:自己的服务：端口
//     extraHeaders: {"Access-Control-Allow-Origin": '*'},
// });
const app = createApp(App)
// app.use().use(
//     new VueSocketIO({
//       debug: true, // debug调试，生产建议关闭
//       connection: "http://localhost:8081",
//       options: {     //Optional options, 
//         autoConnect:false, //关闭自动连接，在用户登录后在连接。
//       }
//     })
//   );
app.use(store)
app.use(router)
// app.use(socketio)
app.use(ElementPlus)
app.mount('#app')
