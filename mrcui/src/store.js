import {createStore,applyMiddleware,compose} from 'redux'
import {routerMiddleware} from 'connected-react-router'
import thunk from 'redux-thunk'
import {createBrowserHistory} from 'history';
import rootReducer from './reducer/index';
 export const history = createBrowserHistory();

 export function configureStore(){

    const middleware=[thunk,routerMiddleware(history)]
    const composedEnhancers=compose(applyMiddleware(...middleware));
    const store = createStore((rootReducer(history)),{},composedEnhancers);

    return {
        store:store,
        history: history
    }
 }