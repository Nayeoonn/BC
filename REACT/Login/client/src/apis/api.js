import axios from 'axios'

// api라는 이름으로 서버가 실행되고 난 다음에 axios 요청을 api 객체로만 할것임
// axios 객체 생성
const api = axios.create()

export default api