import { createStore } from 'vuex'
import ModuleUser from './user'

export default createStore({
  // 存数据
  state: {
  },

  //需要计算的内容
  getters: {
  },

//对于state的修改的方式
  mutations: {
  },

  //各种操作
  actions: {
  },

  //对state进行分割
  modules: {
    user: ModuleUser,
  }
});
