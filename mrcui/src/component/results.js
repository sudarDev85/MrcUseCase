import React from "react";
import {connect} from 'react-redux';
import {DataScroller} from 'primereact/datascroller';
import {Button} from 'primereact/button';
import { history } from '../store';
class Results extends React.Component{
    constructor(props) {
        super(props);
       
        this.resultsTemplate = this.resultsTemplate.bind(this);
        this.navigate= this.navigate.bind(this);
    }
    navigate(){
    history.push("/reservation");
    }
    resultsTemplate(hotel) {
        if (!hotel) {
            return;
        }

        const src = "images/" + hotel.hotelId + ".jpg";

        return (
            <div className="p-grid hotel-item">
                <div className="p-col-12 p-md-3">
                    <img src={src} alt="Hotel" height="100" width="100"/>
                </div>
                <div className="p-col-12 p-md-9">
                    <div className="p-grid">
                        
                       <div className="p-col-12 p-sm-8"  style={{'fontWeight': 'bold' }}>{hotel.name}</div>

                        <div className="p-col-2 p-sm-6">Features: </div>
                        <div className="p-col-10 p-sm-6">{hotel.feature}</div>
                        
                        <div className="p-col-2 p-sm-6">Available Rooms: </div>
                        <div className="p-col-10 p-sm-6">{hotel.availableRooms}</div>
            
                                    <div className="p-col-2 p-sm-6">Price: </div>
                        <div className="p-col-10 p-sm-6">INR {hotel.price}</div>
                        
                        <div className="p-col-10 p-sm-6"><Button label="Reseve" onClick={this.navigate}/></div>           
                        
                    </div>
                </div>
            </div>
        );
    }

    render() {
        return (
            <div className="datascroll-result">
                 <div className="content-section implementation">
                    <DataScroller value={this.props.resultsVals} itemTemplate={this.resultsTemplate} rows={10} inline={true} scrollHeight="500px" header="Hotels Available" />
                </div>
                
            </div>
        );
    }

   
}
function mapDispatchToState(state){
    return{
        resultsVals: state.searchAndFilterReducer.results
    }
}
function mapDispatchToProps(dispatch){
   return{
       resever: () => dispatch(),
       
   }

}
export default connect(mapDispatchToState,mapDispatchToProps)(Results);
 