 import React, { Component } from 'react'
 
 export default class HeaderComponent extends Component {
     constructor(props){
        super(props)
        this.state = {
             
        }
        }


     render() {
         return (
             <div>
                <header>
                   <nav className="navbar navar-expand-md  navbar-dark bg-dark">
                       <div>
                         <h3 className="text-light">Costumer Management System</h3>
                       </div>
                   </nav>   
                </header> 
             </div>
         )
     }
 }
 