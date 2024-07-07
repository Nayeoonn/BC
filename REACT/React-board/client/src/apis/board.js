import axios from 'axios';

// API 기본 URL 설정
const api = axios.create({
  baseURL: 'http://localhost:8080', // 서버의 URL과 포트를 설정
});

// 게시글 목록
export const list = () => api.get('/boards');

// 게시글 조회
export const select = (no) => api.get(`/boards/${no}`);

// 게시글 등록
export const insert = (title, writer, content) => api.post('/boards', { title, writer, content });

// 게시글 수정
export const update = (no, title, writer, content) => api.put('/boards', { no, title, writer, content });

// 게시글 삭제
export const remove = (no) => api.delete(`/boards/${no}`);
