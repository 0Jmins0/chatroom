import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue';
import UserListView from '../views/UserListView';
import UserProfileView from '../views/UserProfileView';
// import LoginView from '../views/LoginView';
// import RegisterView from '../views/RegisterView';
import NotFoundView from '../views/NotFoundView';
import TalkRoomView from '../views/TalkRoomView';
import UserAccountLoginView from '../views/users/account/UserAccountLoginView'
import UserAccountRegisterView from '../views/users/account/UserAccountRegisterView'
import store from '../store/index'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: '/userlist/',
    name: 'userlist',
    component: UserListView,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: '/userprofile/:userId/',
    name: 'userprofile',
    component: UserProfileView,
    meta: {
      requestAuth: true,
    }
  },
  // {
  //   path: '/login/',
  //   name: 'login',
  //   component: LoginView
  // },
  // {
  //   path: '/register/',
  //   name: 'register',
  //   component: RegisterView
  // },
  {
    path: '/user/account/login/',
    name: 'user_account_login',
    component: UserAccountLoginView,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: '/user/account/register/',
    name: 'user_account_register',
    component: UserAccountRegisterView,
    meta: {
      requestAuth: false,
    }
  },

  {
    path: '/404/',
    name: '404',
    component: NotFoundView,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: '/talkroom/:userId/',
    name: 'talkroom',
    component: TalkRoomView,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: '/:catchAll(.*)',
    redirect:'/404'
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to,from,next) => {
  if(to.meta.requestAuth && !store.state.user.is_login){
    next({name: "user_account_login"});
  }else{
    next();
  }
})
export default router
