import http from '../utils/http/http.js'

const getShipperById = (data)=>{
    return http.get("getShipperById",data)
}
export default{
    getShipperById
}