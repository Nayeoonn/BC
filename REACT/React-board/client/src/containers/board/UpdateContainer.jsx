import React, {useEffect, useState} from 'react'
import { useNavigate } from 'react-router-dom'
import * as boards from '../../apis/board'
import Update from '../../components/board/Update'

const UpdateForm = ({no}) => {

  const [board, setBoard] = useState({})

  const navigate = useNavigate()

  const getBoard = async () => {
    const response = await boards.select(no)
    const data = await response.data        
    console.log(data);
  }

  
  const onUpdate = async (no, title, writer, content) => {
    try {
      const response = await boards.update(no, title, writer, content)
      const status = await response.status
      console.log(`게시글 수정 요청 결과 : ${status}`);
      alert("게시글 수정 완료!")

      // ➡ 게시글 목록으로 이동
      navigate("/boards")

    } catch (error) {
      console.log(error);
    }
  }

  const onDelete = async (no) => {
    const response = await boards.remove(no)
    const status = await response.status
    console.log(`게시글 삭제 요청 결과 : ${status}`);
    alert("삭제 완료!")

    // ➡ 게시글 목록으로 이동
    navigate("/boards")
  }

  // ❓ hook
  useEffect( () => {
    getBoard()
  },[])

  return (
    <>
      <Update no={no} 
              board={board} 
              onUpdate={onUpdate}
              onDelete={onDelete}/>
    </>
  )
}

export default UpdateForm