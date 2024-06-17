import React, {useEffect, useState} from 'react'
import { Link } from 'react-router-dom'

const UpdateForm = ({no, board, onUpdate, onDelete, isLoading}) => {
  // state
  const [title, setTitle] = useState('')
  const [writer, setWriter] = useState('')
  const [content, setContent] = useState('')
  // 초기값을 빈 문자열로 세팅

  // 이벤트 함수
  const handleChangeTitle = (e) => {
    setTitle(e.target.value)
  }
  const handleChangeWriter = (e) => {
    setWriter(e.target.value)
  }
  const handleChangeContent = (e) => {
    setContent(e.target.value)
  }

  const onSubmit = () => {
    // 유효성 검사 (생략)
    onUpdate(no, title, writer, content)
  }

  const handleDelete = () => {
    const check = window.confirm("정말로 삭제하시겠습니까?")
    if(check){
      onDelete(no)
    }
  }

  // 부모로부터 내려왔을 때 세팅
  useEffect(() => {
    if(board){
      setTitle(board.title)
      setWriter(board.writer)
      setContent(board.content)
    }
  }, [board])
  // 의존성 배열 []에 board를 넣어주어야함 -> [의존하는 객체]
  // props를 updateContainer에서 내려 받을 때 처음엔 비어있기 때문에 
  // 요청을 날려서 가져와야함
  // 마운트시 데이터가 없기 때문에 의존하는 객체나 데이터를 넣어주면 변화가 일어났을 때 함수가 다시 돌아감
  // : 지정한 객체가 변화했을 때, 다시 useEffect를 실행
  

  return (
    <div className="container">
      <h1 className="title">게시글 수정</h1>
      <h3>번호 : {no}</h3>
      <hr />
      {
        isLoading && 
        <div>
          <img src="/img/loading.webp" width="100%" alt="loading" />
        </div>
      }
      {
        !isLoading && board && (
          <table>
            <tbod>
            <tr>
              <td>번호</td>
              <td>
                <input type="text" value={no} readOnly />
              </td>
            </tr>
            {/* <tr>
              <td>등록일자</td>
              <td>
                <input type="text" value={'2024.01.01 12:00:00'} readOnly />
              </td>
            </tr> */}
            <tr>
              <td>제목</td>
              <td>
                {/* <input type="text" value={board.title} onChange={handleChangeTitle}/> */}
                {/* value={board.title} -> 부모에게 받은 고정된 값 */}
                <input type="text" value={title} onChange={handleChangeTitle}/>
                {/* value={title} 은 위에 초기값으로 씀 */}
              </td>
            </tr>
            <tr>
              <td>작성자</td>
              <td>
                <input type="text" value={writer} onChange={handleChangeWriter}/>
              </td>
            </tr>
            <tr>
              <td colSpan={2} >내용</td>
            </tr>
            <tr>
              <td colSpan={2}>
                <textarea cols="40" rows="10" value={content} onChange={handleChangeContent}></textarea>
              </td>
            </tr>
            </tbod>
          </table>
        )}
      <hr />
      <div className="btn-box">
        <Link to="/boards" className='btn'>목록</Link>
        <button className='btn' onClick={handleDelete}>삭제</button>
        <button className='btn' onClick={onSubmit}>수정</button>
      </div>
    </div>
  )
}

export default UpdateForm