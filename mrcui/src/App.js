import React from 'react';
import {render} from 'react-dom';
import {Provider} from 'react-redux';
import {ConnectedRouter} from 'connected-react-router';
import SearchBar from './component/searchBar';
import {configureStore} from './store';
import AppRoute from './routes';
import 'primereact/resources/themes/nova-light/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';
import './App.css';
const  {store,history} = configureStore();
render(
  <Provider store={store}>
    <ConnectedRouter history={ history}>
       <div>
          <SearchBar/>
          <AppRoute/>
        </div>
    </ConnectedRouter>
  </Provider>,
  document.querySelector('#index')
)
