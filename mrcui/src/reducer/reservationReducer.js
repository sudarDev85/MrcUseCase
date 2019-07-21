import {RESERVATION_ACTIONS} from '../actions/reservationAction';

const initState={
  customerDetail:{hotelId:1},
}

export function reservationReducer(state=initState,action){
    switch(action.type){
        case RESERVATION_ACTIONS.saveCustomerDetail:
            return {...state,customerDetail:{...state.customerDetail,[action.id]:action.payload}
            }
            default:
                return state;
    }
}