<template>
    <div class="card">
        <div class="card-body"  style=" height:400px; overflow-y:auto">
            <div v-for="message in messagelist" :key="message.userId">
                <div :key="message.error_maessage" v-if="message.error_message === 'accept_message'" class="d-grid gap-2 d-md-block">
                    {{message.username}} : {{message.message}}
                </div>
                <div v-else class="d-grid gap-2 d-md-flex justify-content-md-end">
                    {{message.message}} : {{message.username}}
                </div>
            </div>
        </div>
    </div>
</template>


<script>
export default{
    name: "ChatRoomShow",
    props:{
        messagelist:{
            type: Object,
            required: true,
        }
    },
}
</script>


<style scoped>
.card{
    height:400px;
}

</style>