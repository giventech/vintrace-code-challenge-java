import {useEffect, useState} from 'react';
import axios from 'axios';

export const API_URL = 'http://localhost:8080'
export default function useGetCompositionBreakDown(compositionType, wineId, pageNumber, offset) {
    const initialUserState = {
        breakDown: {},
        id:  wineId,
        pageNumber: pageNumber,
        offset : offset,
        compositionType:compositionType
    }
    // Getter and setter for user state
    const [breakDown, setBreakDown] = useState(initialUserState);
    useEffect(()=>{
        axios({
            method:'GET',
            url:`${API_URL}/composition/${compositionType}/${wineId}`,
            params: {
                pageNumber: pageNumber,
                offset: offset
            }
        }).then(res =>{
            var size  =  [...Object.entries(res.data)].length;
            var pn = parseInt(pageNumber,10) 
            var ofs = parseInt(offset,10);
            var previousArray = pn == 1 ? [] :[...Object.entries(breakDown.breakDown)];
            var arrayFromBackEnd = [...Object.entries(res.data)];
            var expandedArray = arrayFromBackEnd.splice((pn -1) * ofs, ofs);
            var concatenated = Object.fromEntries([...previousArray,...expandedArray]);
            setBreakDown({breakDown: concatenated, id:breakDown.id, pageNumber:pn, offset:ofs,compositionType:compositionType});
        })
    },[compositionType, wineId, pageNumber, offset]); //re-load if compositionType, wineId, pageNumber or offset change
    
    return {breakDown};
}

