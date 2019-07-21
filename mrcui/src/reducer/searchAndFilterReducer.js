import {SEARCH_FILTER_ACTIONS} from '../actions/searchAndFilterAction';

const initState={
    search:{
        location:'',
        checkinDate:'',
        checkoutDate:''
    },
    filter:{
        fq:'',
        minPirce:'',
        maxPrice:''
    },
    results:{}
}

export function searchAndFilterReducer(state=initState,action){
    switch(action.type){
        case SEARCH_FILTER_ACTIONS.searchchange:
            return {...state,search:{...state.search,[action.id]:action.payload}
            }
        case SEARCH_FILTER_ACTIONS.filterchange:
                    return {...state,filter:{...state.filter,[action.id]:action.payload}
                    }   
        case SEARCH_FILTER_ACTIONS.saveResults:
                return {...state,results:{...action.payload}} 
            default:
                return state;
    }
}