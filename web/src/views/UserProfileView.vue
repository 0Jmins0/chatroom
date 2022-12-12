<template>
  <ContentBase>
    <div class="row">
      <div class="col-3">
        <UserProfileInfo @follow="follow" @unfollow="unfollow" :user = "user"></UserProfileInfo>
        <UserProfileWrite v-if="is_me" @post_a_post="post_a_post" ></UserProfileWrite>
      </div>
      <div class="col-9">
        <UserProfilePosts :posts = "posts"></UserProfilePosts>
      </div>

    </div>
  </ContentBase>
</template>


<script>
import ContentBase from '../components/ContentBase';
import UserProfileInfo from '../components/UserProfileInfo';
import UserProfilePosts from '../components/UserProfilePosts';
import UserProfileWrite from '../components/UserProfileWrite';
import { reactive } from 'vue';
import { useRoute } from 'vue-router';
import $ from 'jquery';
import { useStore } from 'vuex';
import { computed } from 'vue';

export default {
  name: 'UserProfile',
  components: {
    ContentBase,
    UserProfileInfo,
    UserProfilePosts,
    UserProfileWrite,
  },
  setup() {
    const store = useStore();
    const route = useRoute();
    const userId = parseInt(route.params.userId);
    const user = reactive({});
    const posts = reactive({});

    $.ajax({
      url:'http://localhost:3000/user/Id',
      type: "GET",
      data:{
        userId:userId,
      },
      success(resp){
        console.log(resp);
        user.id = resp.id;
        user.username = resp.username;
        user.photo = resp.photo;
        user.followercount = resp.followercount;
        user.is_followed = false;
        user.postscount = resp.postscount;
        
      }
    });


    $.ajax({
      url:'http://localhost:3000/user/getposts',
      type:"GET",
      data:{
        userId: userId,
      },
      success(resp){
       
        posts.posts = resp;
        // console.log(posts.posts);
      }
    });

    // const post=reactive({});
    // $.ajax({
    //   url:'http://localhost:3000/user/putposts',
    //   type:"GET",
    //   data:{
    //     userId: userId,
    //     post: post,
    //   },
    //   success(resp){
    //     console.log(resp);
    //   }
    // });


    const follow = () =>{
      if(user.is_followed) return ;
      user.is_followed = true;
      user.FolowerCount++;
    };
    const unfollow = () =>{
      if(!user.is_followed) return ;
      user.is_followed = false;
      user.FolowerCount--;
    };

    const post_a_post = (post) =>{
      user.postscount ++;
      posts.posts.unshift(
        {
          id:user.id,
          post: post,
          pid: posts.count,
        },
      );
      $.ajax({
        url:"http://localhost:3000/user/putposts",
        type:"get",
        data:{
          userId:user.id,
          post:post,
          pid:user.postscount,
        }
      })
    };
    // console.log(userId,store.state.user.id);
    const is_me = computed(() => userId == store.state.user.id);

    return {
      user,
      follow,
      unfollow,
      posts,
      post_a_post,
      is_me,
    }
  }
}
</script>

<style scoped>
</style>