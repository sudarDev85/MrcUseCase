import React from 'react';
import {Route,Switch} from 'react-router';
import Home from './pages/home';
import Confirmation from './pages/confirmation'
import Reservation from './pages/reservation'
export const routes=[
    {
      path:"/",
      component:Home,
      exact:true
    },
    {
      path:"/reservation",
      component:Reservation,
      exact:true
    },
    {
      path:"/confirmation",
      component:Confirmation,
      exact:true
    },
    
  ]
  const  AppRoute=()=>{
    return(
      <Switch>
        {
          routes.map((route)=>(
            <Route key={route.path} {...route}/>
          ))
        }
        </Switch>
    )
  }
  export default  AppRoute