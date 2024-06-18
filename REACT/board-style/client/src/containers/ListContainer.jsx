import React, { useEffect, useState } from 'react'
import List from '../components/board/List'
import * as boards from '../apis/boards'

const ListContainer = () => {
  // state
  // useState([]) -> 리스트나 컬렉션 상태를 초기화
  const [boardList, setBoardList] = useState([])
  const [isLoading, setLoading] = useState(false)

  // 이벤트 함수
  const getBoardList = async() => {
    // ⌚ 로딩 시작
    setLoading(true)
    const response = await boards.list()  // 데이터 요청
    const data = await response.data      // ⭐boardList
    setBoardList(data)
    setLoading(false)
    // ⌚ 로딩 끝
    
  }

  // hook
  useEffect( () => {
    getBoardList()    // 마운트 될 때 호출 돼서 setBoardList로 인해 state가 바뀌면서 업데이트 됨 -> 리랜더링
    
  }, [])
  return (
    <>
      {/* 게시글 목록 */}
      <List boardList={boardList} isLoading={isLoading}/>
    </>
  )
}

export default ListContainer