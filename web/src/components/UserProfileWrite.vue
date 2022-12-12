<template>
  <div class="card edit-field">
    <div class="card-body">
        <!-- <label for="edit-post" class="form-label">编辑帖子</label>
        <textarea v-model="content" class="form-control" id="edit-post" rows="3"></textarea> -->
        <div class="form-floating">
        <textarea  v-model="content" class="form-control" placeholder="Leave a comment here" id="edit-post" style="height: 100px"></textarea>
        <label for="floatingTextarea" color="grey">Comment</label>
        </div>
        <button  @click="post_a_post" type="button" class="btn btn-primary btn-sm">发帖</button>
    </div>
  </div>
</template>



<script>
import { ref } from 'vue';


export default{
    name:"UserProfileWrite",
    setup(props,context) {
        let content = ref('');

        const post_a_post = () =>{
            context.emit('post_a_post',content.value);              
            content.value = "";
        }

        return {
            content,
            post_a_post,
        }
    }
}
</script>




<style scoped>
.edit-field{
    margin-top: 20px;
}
button{
    margin-top: 10px;
}

</style>
