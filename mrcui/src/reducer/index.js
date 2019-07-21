import {combineReducers} from 'redux';
import {reservationReducer} from './reservationReducer';
import {searchAndFilterReducer} from './searchAndFilterReducer';
import { connectRouter } from 'connected-react-router'
 
export default (history)=>combineReducers({
    reservationReducer,
    searchAndFilterReducer,
    router: connectRouter(history),
}

);