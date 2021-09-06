import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ListCosmtumerComponent from './components/ListCosmtumerComponent';
import HeaderComponent from './components/HeaderComponent';
import CreateCostumerComponent from './components/CreateCostumerComponent';
import UpdateCostumerComponent from './components/UpdateCostumerComponent';



function App()  { 
  return (
    <div>
       <Router>
          <div className='container'>
            <HeaderComponent />
            <div className="container">
               <Switch> 
                    <Route path = "/" exact component= {ListCosmtumerComponent}></Route>
                    <Route path = "/costumers" component = {ListCosmtumerComponent}></Route>
                    <Route path = "/add-costumer" component = {CreateCostumerComponent}></Route>
                    <Route path = "/update-costumer/:id" component = {UpdateCostumerComponent}></Route>
                    <Route path = "/delete-costumer/:id" component = {ListCosmtumerComponent}></Route>
               </Switch>
            </div>
          </div>
       </Router>
    </div>
  );
}

export default App;