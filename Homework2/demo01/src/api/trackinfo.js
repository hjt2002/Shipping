import http from '../utils/http/http.js'

const getTrackById = (data)=>{
    return http.get("getTrackById",data)
}

const getTrackInfoById = (data) =>{
    return http.get("getTrackInfoById",data)
}
export default{
    getTrackById,getTrackInfoById
}