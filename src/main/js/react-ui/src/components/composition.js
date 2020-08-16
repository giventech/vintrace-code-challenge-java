import React from 'react';
import useGetCompositionBreakDown from '../hooks/useGetCompositions/usGetCompositionBreakDown';
import { Link } from 'react-router-dom';

const Composition =  (props) => {
    const allFiles   = props.numbers;
    const wineId  = !!(props?.match?.params?.id) ? props?.match?.params?.id:  props.wineId;
    const compositionType  = !!(props?.match?.params?.compositionType) ? props?.match?.params?.compositionType: props.compositionType;
     
    const {breakDown} = useGetCompositionBreakDown(compositionType, wineId);
    console.log("This is the composition breakdown");
    console.log(breakDown.breakDown);
    console.log("Composition");
    console.log(compositionType);
    const objectList =  Object.keys(breakDown.breakDown).map(key  =>{
       console.log( key);
       console.log( breakDown.breakDown[key]);
    //    <tr>
    //      <td> {key}</td> 
    //     <td> {breakDown[key]}</td> 
    //   </tr>
    });
    
    console.log(objectList);


    return (
        <>
        <p><Link to={`/details/${wineId}`}>See details</Link></p>
          {/* <div className="radio">
            <label>
              <input
                type="radio"
                value="year"
                checked={this.state.selectedOption === "YEAR"}
                onChange={this.onValueChange}
              />
              Male
            </label>
          </div>
          <div className="radio">
            <label>
              <input
                type="radio"
                value="region"
                checked={this.state.selectedOption === "REGION"}
                onChange={this.onValueChange}
              />
              Female
            </label>
          </div>
          <div className="radio">
            <label>
              <input
                type="radio"
                value="variety"
                checked={this.state.selectedOption === "VARIETY"}
                onChange={this.onValueChange}
              />
              Other
            </label>
          </div> */}


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
