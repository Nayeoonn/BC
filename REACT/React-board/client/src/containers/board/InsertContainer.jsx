import React from 'react'
import Insert from '../../components/board/Insert'
import * as boards from '../../apis/board'
import { useNavigate } from 'react-router-dom'

const InsertContainer = () => {
  const navigate = useNavigate();

  const onInsert = async (title, writer, content) => {
    try{
      const response = await boards.insert(title, writer, content)
      const status = await response.status
      console.log(`게시글 등록 요청 결과 : ${status}`);
      alert("게시글 등록 완료!")

      navigate("/boards")
    }catch(error){
      console.log(error);
    }
  }
  return (
    <>
      <Insert onInsert={onInsert} />
    </>
  )
}

export default InsertContainer