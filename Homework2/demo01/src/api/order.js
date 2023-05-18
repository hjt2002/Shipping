import http from '../utils/http/http.js'

const getOrderById = (data)=>{
    return http.get("getOrderById",data)
}
const createOrder = (data) =>{
    return http.post("createOrder",data)
}
const getId = () =>{
    return http.get("getShipmentId")
}
const getBillings = (data)=>{
    return http.get("getBillingsById",data)
}
export default{
    getOrderById,createOrder,getId,getBillings
}