import axios from 'axios'

// 업로드
export const upload = (formData, headers) => axios.post(`/files`, formData, headers)


// 다운로드 get 방식은 바디가 없음 헤더. 파일을 받아올 때 {responseType: `blob`} 가 필요
export const download = (no) => axios.get(`/files/${no}`, {responseType: `blob`})