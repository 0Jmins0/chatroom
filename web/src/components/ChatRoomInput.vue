<template>
    <div class="card">
        <div class="card-body" >
            <textarea v-model="content" class="form-control text" aria-label="With textarea" style=" height:80px; overflow-y:auto"></textarea>
            <div class="row">
                <div class="col-10">
                    <div @click="post_a_post" v-if="error_message === 'wrong'">
                        请输入内容！
                    </div>
                </div>
                <div class="col-2">
                    <button  @click="post_a_post" type="button" class="btn btn-outline-primary btn-sm">发送</button>
                </div>
            </div>
            <!-- <div class="error_message"></div>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">

                

            </div> -->
        </div>
    </div>
</template>



<script>

import {ref} from "vue";
export default{
    name: "ChatRoomInput",
    setup(props,context) {

        let error_message = ref('');
        let content = ref('');

        const post_a_post = () =>{
            error_message.value ='';
            if(content.value ===""){
                error_message.value ="wrong";
            }
            else{
                context.emit('post_a_post',content.value);              
                content.value = "";
                error_message.value= '';
            }
        }

        return {
            content,
            post_a_post,
            error_message,
        }
    }
}
</script>


<style scoped>
.card{
    height:150px;
    margin-top:10px;
}
.text{
    height: 80px;
}

button{
    height: 30px;
    margin-top: 10px;
    width: 90px;
}
.col-10{
    margin-top: 12px;
    color:rgba(255, 0, 0, 0.692);
}
</style>