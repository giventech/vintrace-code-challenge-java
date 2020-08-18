import {useEffect, useState} from 'react';
import axios from 'axios';

export const API_URL = 'http://localhost:8080/'
export default function useGetWine(wineId) {

    const initialUserState = {
        wineDetail: {},
        id:  wineId
    }
    // Getter and setter for user state
    const [wineDetail, setWineDetail] = useState(initialUserState);
    
    useEffect(()=>{
        axios({
            method:'GET',
            url:`${API_URL}/details/${wineId}`,
        }).then(res =>{
            setWineDetail({wineDetail: res.data,id:wineDetail.id});
        })
    },[wineId]);
    
    return {wineDetail};
  
}

