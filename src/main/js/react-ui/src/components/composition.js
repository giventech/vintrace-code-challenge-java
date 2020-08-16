import React, { useState } from 'react';
import useGetCompositionBreakDown from '../hooks/useGetCompositions/usGetCompositionBreakDown';
import { Link } from 'react-router-dom';

const Composition =  (props) => {
    const allFiles   = props.numbers;
    const wineId  = !!(props?.match?.params?.id) ? props?.match?.params?.id:  props.wineId;  
    //lotCode is are passed down from the Details components (with the <Link)
    const lotCode  = props.location.state.id; 
    const compositionType  = !!(props?.match?.params?.compositionType) ? props?.match?.params?.compositionType: props.compositionType;
    const [compositionTypeState, setCompositionTypeState] =  useState(compositionType);
    let  {breakDown} = useGetCompositionBreakDown(compositionTypeState, wineId);

    console.log(breakDown.breakDown);
    console.log(compositionType);
    const objectList =  Object.entries(breakDown.breakDown).map(([key,value]) => {
      return <>
       <>   
       <tr>
          <td>{value}</td> 
          <td>{key}</td> 
       </tr></>
      </>
    })

    const  onValueChange = (event) => {
      setCompositionTypeState(event.target.value);
    }
    
    console.log(objectList);
    

    return (
        <>
         {<h2>Lot code: {lotCode}</h2> }
        <p><Link to={`/details/${wineId}`}>See details</Link></p>
        <form>

        <div className="form-check form-check-inline">
            <input className="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" 
                value="YEAR"
                checked={compositionTypeState === 'YEAR' }
                onChange={onValueChange}/>
            <label class="form-check-label" for="inlineRadio1">YEAR</label>
        </div>
        <div className="form-check form-check-inline">
            <input className="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" 
                value="REGION"
                checked={compositionTypeState === 'REGION' }
                onChange={onValueChange}/>
            <label class="form-check-label" for="inlineRadio1">REGION</label>
        </div>
        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" 
            value="VARIETY"
            checked={compositionTypeState === 'VARIETY' }
            onChange={onValueChange}/>
          <label class="form-check-label" for="inlineRadio3">VARIETY</label>
        </div>

        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio4" 
            value="YEAR_VARIETY"
            checked={compositionTypeState === 'YEAR_VARIETY' }
            onChange={onValueChange}/>
          <label class="form-check-label" for="inlineRadio4">YEAR_VARIETY</label>
        </div>
        </form>


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
