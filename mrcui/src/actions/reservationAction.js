import { reservation} from '../service/reservationService'

export const RESERVATION_ACTIONS={
    saveCustomerDetail:'SAVE_CUSTOMER_DETAIL',
}

export function reservAction(history){
    return (dispatch,getstate)=>{
        reservation(getstate().reservationReducer.customerDetail).then((data)=>{
            history.push("/confirmation");
        })
    }

}
export function reservHandleChange(key,value){
    return(dispatch)=>{
        dispatch({
             type:RESERVATION_ACTIONS.saveCustomerDetail,
             id:key,
             payload: value
   })
}
}