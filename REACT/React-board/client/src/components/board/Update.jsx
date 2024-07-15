import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

const Update = ({ no, board, onUpdate, onDelete }) => {
  // state
  const [title, setTitle] = useState('');
  const [writer, setWriter] = useState('');
  const [content, setContent] = useState('');

  // 이벤트 함수
  const handleChangeTitle = (e) => {
    setTitle(e.target.value);
  };
  const handleChangeWriter = (e) => {
    setWriter(e.target.value);
  };
  const handleChangeContent = (e) => {
    setContent(e.target.value);
  };

  const handleSubmit = () => {
    onUpdate(no, title, writer, content);
  };

  const handleDelete = () => {
    const check = window.confirm('정말로 삭제하시겠습니까?');
    if (check) {
      onDelete(no);
    }
  };

  // 부모로부터 내려왔을 때 세팅
  useEffect( () => {
    if( board ) {
      setTitle(board.title)
      setWriter(board.writer)
      setContent(board.content)
    }
  }, [board])

  return (
    <div className='container'>
      <h1 className='title'>게시글 수정</h1>

      {
        board && (
          <table>
            <tbody>
              <tr>
                <td>번호</td>
                <td>
                  <input type="text" value={no} readOnly />
                </td>
              </tr>
              <tr>
                <td>제목</td>
                <td>
                  <input type="text" 
                        value={title}
                        onChange={handleChangeTitle} />
                </td>
              </tr>
              <tr>
                <td>작성자</td>
                <td>
                  <input type="text" 
                        value={writer}
                        onChange={handleChangeWriter} />
                </td>
              </tr>
              <tr>
                <td colSpan={2}>내용</td>
              </tr>
              <tr>
                <td colSpan={2}>
                  <textarea cols="40" rows="10" 
                            value={content}
                            onChange={handleChangeContent}></textarea>
                </td>
              </tr>
            </tbody>
          </table>
        )
      }

      <div className="btn-box">
        <Link to="/boards" className='btn'>목록</Link>
        <button className='btn' onClick={handleDelete}>삭제</button>
        <button className='btn' onClick={handleSubmit}>수정</button>
      </div>
    </div>
  )
}
export default Update;