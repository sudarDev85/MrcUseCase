import axios from 'axios';

export const api=(headers,params)=>{
    const heaverVal={
        ...headers,
        'Cache-control':'no-cache',
        Pragma:'no-cache',
        Expires:'Sat, 01 Jan 2000 00:00:00 GMT'
    };

    const serviceInstance = axios.create({
        baseURL: 'http://localhost:8080/',
        headers:{...heaverVal},
        params: params
    })

    return serviceInstance;
}