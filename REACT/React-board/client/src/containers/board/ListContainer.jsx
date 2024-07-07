import React, { useEffect, useState } from 'react'
import List from '../../components/board/List'
import * as boards from '../../apis/board'

const ListContainer = () => {

  const [boardList, setBoardList] = useState([])

  const getBoardList = async() => {
    const response = await boards.list()  
    const data = await response.data      
    setBoardList(data)
  }

  useEffect( () => {
    getBoardList()  
  }, [])
  return (
    <>
      <List boardList={boardList} />
    </>
  )
}

export default ListContainer