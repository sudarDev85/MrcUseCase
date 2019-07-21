import  React  from "react";
import {connect} from 'react-redux';
import {InputText} from "primereact/inputtext";
import {Calendar} from 'primereact/calendar';
import {searchAction,handleChange} from '../actions/searchAndFilterAction';
import {Button} from 'primereact/button';
import date from 'date-and-time';
class SearchBar extends React.Component{

    constructor(props){
        super(props);
       this.handleInputchange = this.handleInputchange.bind(this);
       this.submitAction=this.submitAction.bind(this);
      }
      handleInputchange(key,value){
          if(key==='checkinDate' || key==='checkoutDate' ){
              const temdateDate= new Date(value);              ;
              this.props.handleChange(key,date.format(temdateDate,'DD/MM/YYYY'));
          }else{
          this.props.handleChange(key,value);
        }
      }
      submitAction(){
         this.props.searchAction();
      }

    render(){
        return(
            <div id="layout-content">

                <div className="content-section introduction">
                                    <div className="feature-intro">
                                        <h1>ABC Travel</h1>
                                        <p>Make your Trip here</p>
                                    </div>
                                </div>
            <div className="content-section implementation ">
                <div className="p-grid p-fluid">
                <div className="p-col-6 p-md-4">
                    <span className="p-float-label">
                                    <InputText id="location" type="text" size="30" value={this.props.searchVals.location} 
                                    onChange={(e) => this.handleInputchange('location', e.target.value)} />
                                    <label htmlFor="float-input">Location</label>
                        </span>
                </div>
                <div className="p-col-4 p-md-4"> 
                <h5>Check-In Date</h5>       
                <Calendar dateFormat="dd/mm/yy" value={ this.props.searchVals.checkinDate} onChange={(e) => this.handleInputchange('checkinDate', e.value)} showIcon={true} />
                </div>
                <div className="p-col-4 p-md-4">   
                <h5>Check-Out Date</h5>     
                <Calendar dateFormat="dd/mm/yy" value={this.props.searchVals.checkoutDate} onChange={(e) => this.handleInputchange('checkoutDate', e.value)} showIcon={true} />
                </div>
                </div>
                <div className="p-col-4 p-md-4">   
                <Button label="Search" onClick={this.submitAction}/>
                </div>
             </div>   
           </div>  
        )
    } 
 }

 function mapDispatchToState(state){
     return{
     searchVals: state.searchAndFilterReducer.search
     }
 }
 function mapDispatchToProps(dispatch){
    return{
        searchAction: () => dispatch(searchAction()),
        handleChange: (key,value)=>dispatch(handleChange(key,value))
    }

}
 export default connect(mapDispatchToState,mapDispatchToProps)(SearchBar);