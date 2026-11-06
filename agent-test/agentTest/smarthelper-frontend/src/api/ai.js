import request from './request'
export function sendMsg(){
    return request.post('/ai/send')
}

