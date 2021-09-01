import React, { Component } from 'react'
import CostumerService from '../services/CostumerService';

export default class CreateCostumerComponent extends Component {
    constructor(props){
        super(props)
        this.state = {
            name: '',
            phoneNumber: '',
            address: '' 
        }
        this.changenameHandler = this.changenameHandler.bind(this);
        this.changephoneNumberHandler = this.changephoneNumberHandler.bind(this);
        this.saveCostumer = this.saveCostumer.bind(this);
    }

        saveCostumer = (e)=> {
        e.preventDefault();
        let costumer = {name: this.state.name, phoneNumber: this.state.phoneNumber,address: this.state.address};
        console.log('costumer => ' + JSON.stringify(costumer));

        CostumerService.createCostumer(costumer).then(res => {
            this.props.history.push('/costumers');
        });
    }
    changenameHandler= (event) => {
        this.setState({name: event.target.value});
    }
    changephoneNumberHandler= (event) => {
        this.setState({phoneNumber: event.target.value});
    }
    changeaddressHandler= (event) => {
        this.setState({address: event.target.value});
    }
    cancel(){
        this.props.history.push('/costumers');
    }
    render() {
        return (
            <div className = "container">
                <div className = "row">
                    <div className ="card col-md-6 offset-md-3 offst-md-3">
                        <h3 className="text-center">Add Costumer</h3>
                        <div className = "card-body">

                            <form>
                                <div className = "form-group">
                                    <label>Name</label>
                                    <input placeholder="Name" name="name" className= "form-control"
                                          value={this.state.name} onChange={this.changenameHandler}/>
                                </div>
    
                                <div className = "form-group">
                                    <label>Phone Number</label>
                                    <input placeholder="Phone Number" name="phoneNumber" className= "form-control"
                                          value={this.state.phoneNumber} onChange={this.changephoneNumberHandler}/>
                                </div>

                                <div className = "form-group">
                                    <label>Address</label>
                                    <input placeholder="Address" name="address" className= "form-control"
                                          value={this.state.address} onChange={this.changeaddressHandler}/>
                                </div>

                                 <button className="btn btn-success" onClick={this.saveCostumer}>Save</button>
                                 <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: '10px'}}>cancel</button>
                            </form>
                        </div>

                    </div>
                
                </div> 
            </div>
        )
    }
}
