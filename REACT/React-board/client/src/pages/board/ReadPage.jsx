import React from 'react'
import ReadContainer from '../../containers/board/ReadContainer'
import { useParams } from 'react-router-dom'

const ReadPage = () => {
    // 파라미터 가져오기
    const {no} = useParams()
    console.log(`no : ${no}`);
  return (
    <>
        <ReadContainer no={no}/>
    </>
  )
}

export default ReadPage
