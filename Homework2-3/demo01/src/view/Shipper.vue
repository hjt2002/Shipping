<template>
    <div class="main">
        <!-- <div>this is a div in welcome</div> -->
        <!-- <div class="root"> -->
            <div class="form-div">
                <el-form :inline="true" :model="formInline" class="demo-form-inline">
                    <el-form-item label="Shipper ID">
                        <el-input v-model="formInline.shipperId" placeholder="Shipper ID" />
                    </el-form-item>

                    <!-- <el-form-item label="Activity zone">
                        <el-select v-model="formInline.region" placeholder="Activity zone">
                            <el-option label="Zone one" value="shanghai" />
                            <el-option label="Zone two" value="beijing" />
                        </el-select>
                    </el-form-item> -->

                    <el-form-item>
                        <el-button type="primary" :icon="Search" @click="onSubmit">Query</el-button>
                    </el-form-item>
                </el-form>
            </div>
            
            <div class="table-div">
                <el-table :data="tableData" style="width: 100%">
                    <el-table-column prop="shipperId" label="Shipper ID" width="180" />
                    <el-table-column prop="shipperName" label="Shipper Name" width="180" />
                    <el-table-column prop="email" label="Email" width="180"/>
                    <el-table-column prop="shipperAddress" label="Address" width="180"/>
                    <el-table-column prop="password" label="Password" width="180"/>
                </el-table>
            </div>
        <!-- </div> -->
    </div>
</template>

<script lang="ts" setup>
import { Search} from '@element-plus/icons-vue';
import { reactive,ref} from 'vue'
import shipperApi from '../api/shipper'

const formInline = reactive({
  shipperId: '',
})
const tableData = ref<Array<string|undefined>>([])
// 获取船员信息By Id
const onSubmit = async () => {
    const res = await shipperApi.getShipperById(formInline)
    // 给tabledata赋值h
    tableData.value.push(res.data.data)
}

</script>

<style  scoped>
.main {
    /* text-align: center; */
    padding: 5px;
    background: white;
    height: 100%;
    /* background-image: url("../assets/img/index.gif"); */
    background-repeat: no-repeat;
    background-size: 100% 100%;
    background-position-y: bottom; 
}
.form-div{
    margin-top: 5px;
    margin-left: 5px;
}
</style>