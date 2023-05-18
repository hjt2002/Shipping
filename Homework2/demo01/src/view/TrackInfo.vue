<template>
    <div class="main">
        <!-- <div>this is a div in welcome</div> -->
        <!-- <div class="root"> -->
            <div class="form-div">
                <el-form :inline="true" :model="formInline" class="demo-form-inline">
                    <el-form-item label="Shipper ID">
                        <el-input v-model="formInline.shipperId" placeholder="Shipper ID" />
                    </el-form-item>
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
                </el-form>
            </div>
            
            <div class="track-table-div">
                <el-table :data="tracktableData" style="width: 100%">
                    <el-table-column prop="shipperId" label="Shipper ID" width="180" />
                    <el-table-column prop="shipmentId" label="Shipment ID" width="180" />
                    <el-table-column prop="shipDate" label="Ship Date" width="180"/>
                    <el-table-column prop="deliveryDate" label="Delivery Date" width="180"/>
                    <el-table-column prop="status" label="Status" width="180"/>
                </el-table>
            </div>

            <div class="trackinfo-table-div">
                <el-table :data="trackInfotableData" style="width: 100%">
                    <el-table-column prop="shipment_id" label="Shipment ID" width="180" />
                    <el-table-column prop="tracking_datetime" label="Track Datetime" width="180" />
                    <el-table-column prop="location" label="Location" width="180"/>
                    <el-table-column prop="status" label="status" width="180"/>
                </el-table>
            </div>
        <!-- </div> -->
    </div>
</template>

<script lang="ts" setup>
import { Search} from '@element-plus/icons-vue';
import { reactive,ref} from 'vue'
import trackInfoApi from '../api/trackinfo'
import { ElMessage } from 'element-plus';

const formInline = reactive({
  shipmentId: null,
  shipperId: null
})
const tracktableData = ref<Array<string|undefined>>([])
const trackInfotableData = ref<Array<string|undefined>>([])

const onSubmit = async () => {
    if(formInline.shipmentId!=null && formInline.shipperId!=null){
        // 查询两个表格
        const trackRes = await trackInfoApi.getTrackById(formInline)
        const trackinfoRes = await trackInfoApi.getTrackInfoById(formInline)

        tracktableData.value.push(trackRes.data.data)
        trackInfotableData.value.push(trackinfoRes.data.data)
        
    }else if(formInline.shipperId==null && formInline.shipmentId!=null){
        // 查询trackinfo
        const trackinfoRes = await trackInfoApi.getTrackInfoById(formInline)
        trackinfoRes.data.data.forEach(element => {
            trackInfotableData.value.push(element)
        });
        console.log(trackInfotableData)

    }else if(formInline.shipmentId==null){
        // shipmentid为空
        ElMessage.warning("请填写Shipment ID字段");
    }



    // if(formInline.shipmentId!=null){
    //     if(formInline.shipperId!=null){

    //         // 填写了shipmentID 和 shipperId 可查询货运详细信息
    //         const trackRes = await trackInfoApi.getTrackById(formInline)
    //         const trackInfoRes = await trackInfoApi.getTrackInfoById(formInline)
    //         console.log(trackInfoRes)
            
    //         trackInfotableData.value.push(trackInfoRes.data.data)
    //         tracktableData.value.push(trackRes.data.data)
            

    //     }else if(formInline.shipperId==null){
    //         // 只填写了shipmentId 可查询物流信息
    //         const trackInfoRes = await trackInfoApi.getTrackInfoById(formInline);
    //         trackInfotableData.value.push(trackInfoRes.data.data)
    //     }  
    // }else{
    //     ElMessage.warning("请填写Shipment ID字段");
    // }
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
.track-table-div{
    margin: 10px;
}
.trackinfo-table-div{
    margin: 10px;
}
</style>