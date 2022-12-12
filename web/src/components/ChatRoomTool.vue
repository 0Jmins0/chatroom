<template>
    <div class="row">
        
        <div class="col-10">
            <input type="file" class="form-control" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" aria-label="Upload">
        </div>
        <div class="col-2">
            <button class="btn btn-outline-secondary" type="button" id="inputGroupFileAddon04">上传</button>
        </div>
    </div>
    

        <!-- <input class="form-control form-control-sm" id="formFileSm" type="file" style="margin-top:10px"> -->
</template>


<script>
export default{
    name: "ChatRoomTool",
}
</script>


<style scoped>
.card{
    height:40px;
    margin-top: 10px;
}

.row{
    margin-top:10px;
}
.col-2{
    width:100px;
}
</style>