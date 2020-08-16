import React, { useState } from 'react';
import useGetWine from '../hooks/useGetWine/useGetWine';
import { Link } from 'react-router-dom';
import Composition from './composition';
 

/**
 * Home page where file can be chosen
 * @param {*} props 
 */


const Details =  (props) => {
    
const allFiles   = props.numbers;
const wineId  = !!(props?.match?.params?.id) ? props?.match?.params?.id:props.wineId;
const {wineDetail} = useGetWine(wineId)
const [descriptionFormValue, setDescriptionFormValue] = useState('')  ;

const handleSubmit = (event) => {
    event.preventDefault();
  }
if(!!wineId) {
  
return ( 

        <>
        <h2>Lot code: {wineDetail.wineDetail.lotCode}</h2>
        <p><Link to={{
                      pathname:`/composition/YEAR/${wineId}`,
                      state: wineDetail
                    }}>Show composition</Link></p>
        <form onSubmit={handleSubmit}>
        <div className="form-group">
            <strong><label htmlFor="description">Description: </label></strong>
            <textarea type="text" 
                    id="description"
                    className="form-control"
                    value={descriptionFormValue?descriptionFormValue :wineDetail.wineDetail.description } 
                    onChange={e => setDescriptionFormValue(e.target.value)} />
        </div>
        <div className="form-group">
        <strong><label htmlFor="volume">Volume: </label></strong>
            <p id="volume">{wineDetail.wineDetail.volume}</p>
        </div>

        <div className="form-group">
          <strong><label htmlFor="tank">Tank: </label></strong>
            <p id="tank">{wineDetail.wineDetail.tankCode}</p>
        </div>

        <div className="form-group">
          <strong><label htmlFor="productState">Product state: </label></strong>
            <p id="productState">{wineDetail.wineDetail.productState}</p>
        </div>

        <div className="form-group">
          <strong><label htmlFor="owner">Owner: </label></strong>
            <p id="owner">{wineDetail.wineDetail.ownerName}</p>
        </div>
        </form>
        </>
        );
     } else {
     return (<div>No content</div>);
     }
}

export default Details;   
    