import React  from "react";
import {connect} from 'react-redux';
import {InputText} from "primereact/inputtext";
import {reservAction,reservHandleChange} from '../actions/reservationAction';
import {history} from '../store';
import {Button} from 'primereact/button';
class Reservation extends React.Component{

  constructor(props){
    super(props);
    this.reservAction =this.reservAction.bind(this);
    this.handleInputchange= this.handleInputchange.bind(this);
  }
   reservAction(){
    this.props.reservAction(history);
   }
   handleInputchange(key,value){
    this.props.reservHandleChange(key,value);
   }
    render(){
        return(
            <div className="content-section implementation ">
            <div className="p-grid p-fluid">
                    <div className="p-col-6 p-md-4">
                        <span className="p-float-label">
                                        <InputText id="firstName" type="text" size="30" value={this.props.customerDetail.firstName} 
                                        onChange={(e) => this.handleInputchange('firstName', e.target.value)} />
                                        <label htmlFor="float-input">First Name</label>
                            </span>
                    </div>
                    <div className="p-col-6 p-md-4">
                        <span className="p-float-label">
                                        <InputText id="lastName" type="text" size="30" value={this.props.customerDetail.lastName} 
                                        onChange={(e) => this.handleInputchange('lastName', e.target.value)} />
                                        <label htmlFor="float-input">Last Name</label>
                            </span>
                    </div>
                    <div className="p-col-6 p-md-4">
                        <span className="p-float-label">
                                        <InputText id="addressLine1" type="text" size="30" value={this.props.customerDetail.addressLine1} 
                                        onChange={(e) => this.handleInputchange('addressLine1', e.target.value)} />
                                        <label htmlFor="float-input">Address Line1</label>
                            </span>
                    </div>
                    <div className="p-col-6 p-md-4">
                        <span className="p-float-label">
                                        <InputText id="addressLine2" type="text" size="30" value={this.props.customerDetail.addressLine2} 
                                        onChange={(e) => this.handleInputchange('addressLine2', e.target.value)} />
                                        <label htmlFor="float-input">Address Line1</label>
                            </span>
                    </div>
                    <div className="p-col-6 p-md-4">
                        <span className="p-float-label">
                                        <InputText id="city" type="text" size="30" value={this.props.customerDetail.city} 
                                        onChange={(e) => this.handleInputchange('city', e.target.value)} />
                                        <label htmlFor="float-input">City</label>
                            </span>
                    </div>
                    <div className="p-col-6 p-md-4">
                        <span className="p-float-label">
                                        <InputText id="state" type="text" size="30" value={this.props.customerDetail.state} 
                                        onChange={(e) => this.handleInputchange('state', e.target.value)} />
                                        <label htmlFor="float-input">State</label>
                            </span>
                    </div>
                    <div className="p-col-6 p-md-4">
                        <span className="p-float-label">
                                        <InputText id="zipcode" type="text" size="30" value={this.props.customerDetail.zipcode} 
                                        onChange={(e) => this.handleInputchange('zipcode', e.target.value)} />
                                        <label htmlFor="float-input">zipcode</label>
                            </span>
                    </div>
                    <div className="p-col-6 p-md-4">
                        <span className="p-float-label">
                                        <InputText id="country" type="text" size="30" value={this.props.customerDetail.country} 
                                        onChange={(e) => this.handleInputchange('country', e.target.value)} />
                                        <label htmlFor="float-input">Country</label>
                            </span>
                    </div>

             </div>
             <div className="p-col-4 p-md-4">   
                <Button label="Confirm" onClick={this.reservAction}/>
                </div>
          </div>          
        )
    } 
 }
 function mapDispatchToState(state){
    return{
        customerDetail: state.reservationReducer.customerDetail
    }
}
function mapDispatchToProps(dispatch){
   return{
       reservAction: (history) => dispatch(reservAction(history)),
       reservHandleChange:(key,value) => dispatch(reservHandleChange(key,value))
       
   }

}
 export default  connect(mapDispatchToState,mapDispatchToProps)(Reservation);