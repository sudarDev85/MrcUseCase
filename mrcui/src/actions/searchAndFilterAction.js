import {search} from '../service/searchService';

export const SEARCH_FILTER_ACTIONS={
     searchchange:'SAVE_SERACH_CHANGE',
     filterchange:'SAVE_FILTER_CHANGE',
     saveResults:'SAVE_RESULTS_CHANGE'
}

export function handleChange(key,value){
     return(dispatch)=>{
          dispatch({
               type:SEARCH_FILTER_ACTIONS.searchchange,
               id:key,
               payload: value
     })
 }
}

export function searchAction(){
     return(dispatch,getSate)=>{
          search(getSate().searchAndFilterReducer.search).then((data)=>{
               dispatch({
                    type:SEARCH_FILTER_ACTIONS.saveResults,
                    payload: data.results});
          }
               
          )
     }

}