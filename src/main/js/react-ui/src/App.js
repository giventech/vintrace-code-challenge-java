import React from "react";

import "./styles.css";
import Home from "./containers/home";
import { Switch, Route, Router } from "react-router";
import { Link } from "react-router-dom";
import Composition from "./components/composition";
import Details from "./components/details";


export default function App(props) {

  const files = ['11YVCHAR001', '11YVCHAR002', '15MPPN002-VK'];
  console.log("Intial props   ");
  console.log(props);
  const listItems = files?.map((number) =>
  <td>
      <Link to={`/details/${number}`}>{number}</Link> 
 </td>
  );
  return (
      // Home page display the left most wine detai

      <>
      <div className="container">
      <table className="table">
          <tbody>
              <tr align="center">
              {listItems}
              </tr>
          </tbody>
      </table>
   
      <Switch>
          <Route exact path="/" render={(props) => <Home {...props} numbers={files} wineId={files[0]}/>} />
          <Route path="/details/:id" render={(props) => <Details {...props} numbers={files} />} />
          <Route path="/composition/:compositionType/:id" render={(props) => <Composition {...props} numbers={files} pageNumber="1" offset="5"/>} />
      </Switch>
      </div>
      </>
  )
}





