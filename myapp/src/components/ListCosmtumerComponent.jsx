import React, { Component } from 'react'
import CostumerService from '../services/CostumerService'

export default class ListCosmtumerComponent extends Component {
    constructor(props){
        super(props)
        this.state = {
             costumers:  [],
             search: ''
        }
        this.addCostumer = this.addCostumer.bind(this);
        this.editCostumer = this.editCostumer.bind(this);
        this.deleteCostumer = this.deleteCostumer.bind(this);
         
    }
    editCostumer(id){
        this.props.history.push(`/update-costumer/${id}`)
    }
    deleteCostumer(id){

       CostumerService.deleteCostumer(id).then((res) =>{
         this.setState({costumers: this.state.costumers.filter(costumer => costumer.id !==id ) });
        });
    }
    componentDidMount(){
        CostumerService.getCostumers().then((res) =>{
         this.setState({ costumers: res.data});
        });
    }

    addCostumer(){
        this.props.history.push('/add-costumer');
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Costumers List</h2>
                <div>
                    <input 
                        type="text" 
                        placeholder="Search..." 
                        onChange={event => {this.setState({search: event.target.value})}}
                        style={{
                            marginRight: '30px',
                            display: 'inline'
                        }}
                        className = "row"
                    />
                    <button className="btn btn-primary" onClick={this.addCostumer}>Add Costumer</button>
                </div>
                <div className= "row">
                    <table className= "table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Costumer name</th>
                                <th>Costumer PhoneNumber</th>
                                <th>Costumer address </th>
                                <th>Actions</th>                
                            </tr> 
                        </thead>   
                        <tbody> 
                            {
                                this.state.costumers
                                .filter(costumer => {
                                    if(this.state.search===''){return true;}
                                    return costumer.name.toLowerCase().startsWith(this.state.search.toLowerCase()) })
                                .map(
                                  costumer =>
                                  <tr key={costumer.id}>
                                        <td>{costumer.name}</td>
                                        <td>{costumer.phoneNumber}</td>
                                        <td>{costumer.address}</td>
                                        <td>
                                            <button
                                                onClick = {() => this.editCostumer(costumer.id)} 
                                                className = "btn btn-info" 
                                                style={{marginRight: '30px'}}
                                            >    
                                                Update
                                            </button>
                                            <button onClick = {() => this.deleteCostumer(costumer.id)} className = "btn btn-danger">
                                                Delete
                                            </button>
                                        </td>
                                    </tr>
                                )
                            }
                        </tbody>
                     </table>
                     </div>  
            </div>
        )
    }
}
