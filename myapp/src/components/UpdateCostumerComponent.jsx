import React, { Component } from 'react'
import CostumerService from '../services/CostumerService';

export default class UpdateCostumerComponent extends Component {
    constructor(props){
        super(props)
        this.state = {
            id: this.props.match.params.id,
            name: '',
            phoneNumber: '',
            address: '' 
        }
        this.changenameHandler = this.changenameHandler.bind(this);
        this.changephoneNumberHandler = this.changephoneNumberHandler.bind(this);
        this.updateCostumer = this.updateCostumer.bind(this);
    }

    componentDidMount(){
        CostumerService.getCostumersById(this.state.id).then((res) =>{
            let costumer = res.data;
            this.setState({
                name: costumer.name,
                phoneNumber: costumer.phoneNumber,
                address: costumer.address
            });
        });
    }

        updateCostumer = (e)=> {
        let costumer = {name: this.state.name, phoneNumber: this.state.phoneNumber,address: this.state.address};
        CostumerService.updateCostumer(costumer, this.state.id).then(res =>{
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
                        <h3 className="text-center">Update Costumer</h3>
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

                                 <button className="btn btn-success" onClick={this.updateCostumer}>Save</button>
                                 <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: '10px'}}>cancel</button>
                            </form>
                        </div>

                    </div>
                
                </div> 
            </div>
        )
    }
}
