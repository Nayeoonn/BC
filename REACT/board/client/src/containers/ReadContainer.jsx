import React, { useEffect, useState } from 'react'
import Read from '../components/board/Read'
import * as boards from '../apis/boards'

const ReadContainer = ({no}) => { // 구조분해할당으로 no 가져오기
  // state
  const [board, setBoard] = useState({})
  // useState({}) -> 여러 속성을 가진 단일 객체 상태를 초기화
  const [isLoading, setLoading] = useState(false)
  
  // 이벤트 함수
  const getBoard = async() => {
    // ⌚ 로딩 시작
    setLoading(true)
    const response = await boards.select(no)
    const data = await response.data            // board
    console.log(data);    
    setBoard(data)
    setLoading(false)
    // ⌚ 로딩 끝
  }

  // hook
  useEffect(() => {
    getBoard()
  }, [])

  // lifeCycle의 의존성 배열 
  return (
    <>
      <Read no={no} board={board} isLoading={isLoading}/>   
      {/* props로 받아서 내리기 */}
    </>
  )
}

export default ReadContainer