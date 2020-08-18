import React, { useState } from 'react';
import useGetCompositionBreakDown from '../hooks/useGetCompositions/usGetCompositionBreakDown';
import { Link } from 'react-router-dom';
import CompositionTypes from '../model';

const Composition =  (props) => {
    const allFiles   = props.numbers;
    const pageNumber   = props.pageNumber;
    const itemPerPage   = props.offset;
    const wineId  = !!(props?.match?.params?.id) ? props?.match?.params?.id:  props.wineId;  
    const lotCode  = !!lotCodeState ? lotCodeState:props?.location?.state?.id; 
    //lotCode is are passed down from the Details components (with the <Link)
    
    const compositionType  = !!(props?.match?.params?.compositionType) ? props?.match?.params?.compositionType: props.compositionType;
    const [compositionTypeState, setCompositionTypeState] =  useState(compositionType);
    const [wineIdState, setWineIdState] =  useState(wineId);
    const [pageNumberState, setPageNumberState] =  useState(pageNumber);
    const [itemPerPageState, setItemPerPageState] =  useState(itemPerPage);
    const [lotCodeState, setLotCodeState] =  useState(lotCode);
    let  {breakDown} = useGetCompositionBreakDown(compositionTypeState, wineIdState, pageNumberState,itemPerPageState);

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
      setPageNumberState("1");
      setCompositionTypeState(event.target.value);
    }

    const  loadMore = () => {
      setPageNumberState(breakDown.pageNumber + 1);
      setCompositionTypeState(breakDown.compositionType);
      setWineIdState(breakDown.id);
      setItemPerPageState(breakDown.offset);
      setLotCodeState(lotCodeState);
    }
    return (
        <>
         {<h2>Lot code: {lotCode}</h2> }
        <p><Link to={`/details/${wineId}`}>Show details</Link></p>
        <form>

          <div className="form-check form-check-inline">
              <input className="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" 
                  value= {CompositionTypes.YEAR}
                  checked={compositionTypeState === CompositionTypes.YEAR }
                  onChange={onValueChange}/>
              <label className="form-check-label" for="inlineRadio1">Year</label>
          </div>

          <div className="form-check form-check-inline">
              <input className="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" 
                  value={CompositionTypes.REGION}
                  checked={compositionTypeState === CompositionTypes.REGION }
                  onChange={onValueChange}/>
              <label className="form-check-label" for="inlineRadio1">Region</label>
          </div>

          <div class="form-check form-check-inline">
              <input className="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" 
                value={CompositionTypes.VARIETY}
                checked={compositionTypeState === CompositionTypes.VARIETY}
                onChange={onValueChange}/>
              <label className="form-check-label" for="inlineRadio3">Variety</label>
          </div>

          <div className="form-check form-check-inline">
              <input className="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio4" 
                value={CompositionTypes.YEAR_VARIETY}
                checked={compositionTypeState === CompositionTypes.YEAR_VARIETY }
                onChange={onValueChange}/>
              <label className="form-check-label" for="inlineRadio4">Year and variety</label>
          </div>
      

        </form>


        <table className="table">
        <thead>
          <tr>
            <th>%(Percent)</th>
            <th>{compositionTypeState}</th>
          </tr>
        </thead>
        <tbody>
            {objectList}
            
      <button  onClick={loadMore}>
        Load more
      </button>
        </tbody>
      </table>

      </>
    );
}



export default Composition;   
