import React from 'react'
import {Link} from 'react-router-dom'

const Index = () => {
  return (
    <div className='container'>
        <h1>메인 화면</h1>
        <h3>react - 게시판</h3>
        <Link to="/boards">게시판</Link>
    </div>
  )
}

export default Index
