import {api} from './api';


export const reservation = (customerDetail) =>{
    const header={'Content-type':'application/json'}
     
   return api(header).post(`/reserve`,customerDetail).then(
        (res) =>{
            
            return res.data;
        }
    )
}