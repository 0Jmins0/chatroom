<template>
    <div class="card">
        <div class="card-body">
            <!-- 帖子列表 -->
            
            <div v-for="post in posts.posts" :key="post.id">
                <div class="card single-post">
                    <div class="cart-body">
                        {{post.post}}
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>


<script>
export default{
    name: "UserProfilePosts",
    props:{
        posts: {
            type: Object,
            required: true,
        },
    }
}
</script>


<style scoped>
.single-post{
    margin-bottom: 15px;
    font-size: 15px;
}
</style>
