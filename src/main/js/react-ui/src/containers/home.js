import React from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router-dom';
import Details from '../components/details';
import Composition from '../components/composition';
/**
 * Home page where file can be chosen
 * @param {*} props 
 */

export default function Home(props) {
    const numbers = props.numbers;
    const componsitionType = props.componsitionType;
    const wineId  = !!(props?.match?.params?.id) ? props?.match?.params?.id:  props.wineId;
    console.log("wined id"+wineId);
    const listItems = numbers?.map((number) =>
         <td>
             <Link to={`/details/${number}`}>{number}</Link> 
        </td>
       );
    return (
        <>

<Details numbers={listItems}
            wineId={wineId}/>
        {/* <div class="container">
            <table className="table">
                <tbody>
                    <tr align="center">
                    {listItems}
                    </tr>
                </tbody>
            </table>
         <Details numbers={listItems}
            wineId={wineId}/>
        </div> */}
           
        </>
    )
  }