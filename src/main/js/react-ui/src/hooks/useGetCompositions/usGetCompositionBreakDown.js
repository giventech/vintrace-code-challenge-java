import {useEffect, useState} from 'react';
import axios from 'axios';

export const API_URL = 'http://localhost:8080'
export default function useGetCompositionBreakDown(compositionType, wineId) {

    const initialUserState = {
        breakDown: {},
        id:  wineId
    }
    // Getter and setter for user state
    const [breakDown, setBreakDown] = useState(initialUserState);
    
    useEffect(()=>{
        axios({
            method:'GET',
            url:`${API_URL}/composition/${compositionType}/${wineId}`,

        }).then(res =>{
            console.log('composition type has changed' + compositionType +'wine Id'+  wineId);
            console.log(res.data);
            setBreakDown({breakDown: res.data,id:breakDown.id});
        })
    },[compositionType, wineId]);
    return {breakDown};
}

