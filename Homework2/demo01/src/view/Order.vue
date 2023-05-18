<template>
    <div class="main">
        <!-- <div>this is a div in welcome</div> -->
        <!-- <div class="root"> -->
            <div class="form-div">
                <el-form :inline="true" :model="formInline" class="demo-form-inline">
                    <el-form-item label="Shipment ID">
                        <el-input v-model="formInline.shipmentId" placeholder="Shipment ID" />
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
                      <!-- 创建订单 -->
                      <el-form-item>
                        <el-button type="primary" :icon="Plus" @click="dialogFormVisible = true">Create</el-button>
                    </el-form-item>
                    <!-- 表单数据 -->
                    <el-dialog 
                        v-model="dialogFormVisible" 
                        title="Create Order"
                        align-center
                    >
                        <el-form :model="form">
                            <el-form-item label="Consignee Name" :label-width="formLabelWidth">
                                <el-input v-model="form.consigneeName" autocomplete="off" />
                            </el-form-item>
                            <el-form-item label="Consignee Address" :label-width="formLabelWidth">
                                <el-input v-model="form.consigneeAddress" autocomplete="off" />
                            </el-form-item>
                            <el-form-item label="Description" :label-width="formLabelWidth">
                                <el-input v-model="form.description" autocomplete="off" />
                            </el-form-item>
                            <el-form-item label="Weight" :label-width="formLabelWidth">
                                <el-input v-model="form.weight" autocomplete="off" />
                            </el-form-item>
                        </el-form>

                        <template #footer>
                            <span class="dialog-footer">
                                <el-button @click="dialogFormVisible = false">Close</el-button>
                                <el-button type="primary" @click="createOrder" :icon="Upload">Confirm</el-button>
                            </span>
                        </template>
                    </el-dialog>
                </el-form>
            </div>
            
            <div class="table-div">
                <el-table :data="tableData" style="width: 100%">
                    <el-table-column prop="shipmentId" label="Shipment ID" width="180" />
                    <el-table-column prop="consigneeName" label="Consignee Name" width="180" />
                    <el-table-column prop="consigneeAddress" label="Consignee Address" width="180"/>
                    <el-table-column prop="description" label="Description" width="180"/>
                    <el-table-column prop="weigth" label="Weight" width="180"/>

                </el-table>
            </div>

            <div class="billings-table-div">
                <el-table :data="billingstableData" style="width: 100%">
                    <el-table-column prop="shipment_id" label="Shipment ID" width="180" />
                    <el-table-column prop="amount" label="Amount" width="180" />
                    <el-table-column prop="duedate" label="duedate" width="180"/>
                    <el-table-column prop="status" label="status" width="180"/>
                </el-table>
            </div>
        <!-- </div> -->
    </div>
</template>

<script lang="ts" setup>
import { reactive,ref } from 'vue'
import { Plus, Search, Upload } from '@element-plus/icons-vue';
import orderApi from '../api/order'
import order from '../api/order';
import { ElMessage } from 'element-plus'

const formInline = reactive({
    shipmentId: '',
})

// 获取订单
const tableData = ref<Array<string|undefined>>([])
// 订单费用
const billingstableData = ref<Array<string|undefined>>([])
const onSubmit = async () => {
    const res = await orderApi.getOrderById(formInline);   
    const billingsRes = await orderApi.getBillings(formInline);
    console.log(billingsRes)

    tableData.value.push(res.data.data)
    billingstableData.value.push(billingsRes.data.data)
}

const formLabelWidth = '150px'
const form = reactive({
    shipmentId:'',
    consigneeName:'',
    consigneeAddress:'',
    description:'',
    weight:''
})
const dialogFormVisible = ref(false)

//获取Id
const getId = async()=>{
    const res = await orderApi.getId();
    console.log(res.data.data)
    form.shipmentId = res.data.data;
    console.log(form.shipmentId)
}

// 创建订单
const createOrder = async ()=>{
    await getId()
    console.log(form)
    if(form.consigneeAddress!=null && form.consigneeName!=null && form.weight!=null){
        const res = order.createOrder(form);
        console.log(res)
    }else{
        ElMessage.warning("必选字段未填!")
    }
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