import React, { useState } from 'react';
import useGetCompositionBreakDown from '../hooks/useGetCompositions/usGetCompositionBreakDown';
import { Link } from 'react-router-dom';





const Composition =  (props) => {
    const allFiles   = props.numbers;
    const wineId  = !!(props?.match?.params?.id) ? props?.match?.params?.id:  props.wineId;  
    //lotCode is are passed down from the Details components (with the <Link)
    const lotCode  = props.location.state.id; 
    const compositionType  = !!(props?.match?.params?.compositionType) ? props?.match?.params?.compositionType: props.compositionType;
    const [compositionTypeState, setCompositionTypeState] =  useState(compositionType)  ;
    

    let  {breakDown} = useGetCompositionBreakDown(compositionTypeState, wineId);

    console.log(breakDown.breakDown);
    console.log(compositionType);
    const objectList =  Object.keys(breakDown.breakDown).map(key  =>{
       console.log( key);
       console.log( breakDown.breakDown[key]);
    //    <tr>
    //      <td> {key}</td> 
    //     <td> {breakDown[key]}</td> 
    //   </tr>
    });

    const  onValueChange = (event) => {
      setCompositionTypeState(event.target.value);
    }
    
    console.log(objectList);
     
    

    return (
        <>
         {<h2>Lot code: {lotCode}</h2> }
        <p><Link to={`/details/${wineId}`}>See details</Link></p>
          <div className="radio">
            <label className="radio-inline">
              <input
                type="radio"
                value="YEAR"
                checked={compositionTypeState === 'YEAR' }
                defaultChecked={true} 
                onChange={onValueChange}
              />
              YEAR
            </label>
          </div>
          <div className="radio">
          <label className="radio-inline">
              <input
                type="radio"
                value="REGION"
                checked={compositionTypeState === 'REGION'}
                onChange={onValueChange}
              />
              REGION
            </label>
          </div>
          <div className="radio">
          <label className="radio-inline">
              <input
                type="radio"
                value="VARIETY"
                checked={compositionTypeState === 'VARIETY'}
                onChange={onValueChange}
              />
              VARIETY
            </label>
          </div> 


        <table class="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">First</th>
            <th scope="col">Last</th>
            <th scope="col">Handle</th>
          </tr>
        </thead>
        <tbody>
            {objectList}
        </tbody>
      </table>
      </>
    );
}



export default Composition;   
