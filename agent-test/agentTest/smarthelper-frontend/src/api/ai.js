import request from './request'
export function CheckHealth(){
    return request.get('/ai/health')
}
