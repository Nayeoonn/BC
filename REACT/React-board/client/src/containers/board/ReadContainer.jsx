import React, { useEffect, useState } from 'react'
import Read from '../../components/board/Read'
import * as boards from '../../apis/board'

const ReadContainer = ({ no }) => {
    const [board, setBoard] = useState({})
  
    const getBoard = async () => {
      const response = await boards.select(no)
      const data = await response.data        
      console.log(data);
      setBoard(data)
    }

    useEffect( () => {
      getBoard()
    },[])
  
    return (
      <>
        <Read no={no} board={board} />
      </>
    )
  }
  
  export default ReadContainer