// 리듀서 정의
import {handleActions} from 'redux-actions';
import { DECREMENT, INCREMENT } from './actionTypes';

// 상태 초기화
const initilaState = {
    count : 0
}

// 리듀서
const counterReducer = handleActions(
    {
        [INCREMENT] : (state) => ({count: state.count + 1}),        
        [DECREMENT] : (state) => ({count: state.count - 1}),        
    },
    initilaState
)

export default counterReducer;