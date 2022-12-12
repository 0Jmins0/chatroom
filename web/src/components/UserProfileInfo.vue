<template>
    <div class="card">
        <div class="card-body">
            <div class="row">
                <div class="col-3 img-field">
                    <img class="img-fluid" :src="user.photo" alt="">
                    <!-- <router-link>  -->
                        <!-- <form action="post">
                            <input type="file" id="file" name="file">
                        </form> -->
                    <!-- </router-link> -->
                </div>
                <div class="col-9">
                    <div class="username"> {{ user.username }}</div>
                    <div class="fans">粉丝：{{ user.followercount }}</div>
                    <button @click="follow" v-if="!user.is_followed" type="button" class="btn btn-secondary btn-sm">+关注</button>
                    <button @click="unfollow" v-if="user.is_followed" type="button" class="btn btn-secondary btn-sm">取消关注</button>
                </div>
            </div>            
        </div>
    </div>
</template>


<script>
export default{
    name:"UserProfileInfo",
    props:{
        user:{
            type: Object,
            required: true,
        },
    },
    setup(props,context){
        const follow = () => {
            // console.log("follow");
            context.emit('follow');
        }

        const unfollow = () => {
            // console.log("unfollow");
            context.emit('unfollow');
        }

        return {
            follow,
            unfollow,
        }
    }
}
</script>



<style scoped>
img{
    border-radius: 50%;
}
.username{
    font-weight:bold;
}

.fans{
    font-size:12px;
    color:gray;
}

button{
    padding: 2px 4px;
    font-size:12px;
}

.img-field{
    display:flex;
    flex-direction: column;
    justify-content: center;
}
</style>
