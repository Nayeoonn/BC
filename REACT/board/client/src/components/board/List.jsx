import { Link } from 'react-router-dom'
import React from 'react'

const List = () => {
  return (
    <>
      <h1>게시글 목록</h1>
      <Link to="/board/insert">글쓰기</Link>
      <hr />
      <Link to="/board/10">게시글 조회</Link>
    </>
  )
}

export default List