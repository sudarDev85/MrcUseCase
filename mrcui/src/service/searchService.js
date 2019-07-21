import {api} from './api';
import queryString from 'query-string'

export const search = (search) =>{
    const header={'Content-type':'application/json'}
     const query=queryString.stringify(search);
   return api(header).get(`/search?${query}`).then(
        (res) =>{
            
            return res.data;
        }
    )
}