import React, { createContext, useEffect, useState } from 'react'
import Cookies from 'js-cookie'
import api from '../apis/api'
import * as auth from '../apis/auth'
import { useNavigate } from 'react-router-dom'

// 컨텍스트 생성
export const LoginContext = createContext()

const LoginContextProvider = ({ children }) => {

	/* -----------------------[State]-------------------------- */
	// 로그인 여부
	const [isLogin, setLogin] = useState(false);
	// 유저 정보
	const [userInfo, setUserInfo] = useState(null)
	// 권한 정보
	const [roles, setRoles] = useState({isUser : false, isAmdin : false})
	/* -------------------------------------------------------- */

	// 페이지 이동
	const navigate = useNavigate()

    // 🍪➡💍 로그인 체크 (쿠키를 가져와서 쿠키 안에 jwt가 있는지 확인)
    const loginCheck = async () => {
        // 🍪 accessToken 쿠키 확인
        const accessToken = Cookies.get("accessToken")
        console.log(`accessToken : ${accessToken}`);

        // 💍 in 🍪 ❌
        if ( !accessToken ) {
            console.log(`쿠키에 accessToken(jwt)가 없음`);
			// 로그아웃 세팅
			logoutSetting()
			return
        }

        // 💍 in 🍪 ⭕
        console.log(`쿠키에 jwt(accessToken) 이 저장되어 있음`);
        // axios common header 에 등록
        api.defaults.headers.common.Authorization = `Bearer ${accessToken}` // jwt 토큰 담겨서 등록

        // 사용자 정보 요청
        let response
        let data 

        try {
            response = await auth.info()
        } catch (error) {
            console.log(`error : ${errpr}`);
			console.log(`status : ${response.status}`);
			return
        }
        
		data = response.data	// data = 사용자 정보
		console.log(`data : ${data}`);

		// 인증 실패
		if(data == 'UNAUTOHRIZED' || response.status == 401){
			console.log(`accessToken(jwt) 이 만료되었거나 인증에 실패하였습니다.`);
			return
		}
		
		// 인증 성공
		console.log(`accessToken(jwt) 토큰으로 사용자 정보 요청 성공!`);

		// 로그인 세팅 -> 로그인 여부, 유저 정보, 권한 정보 세팅
		loginSetting(data, accessToken)		
    }

	// 로그인
	const login = async (username, password) => {
		console.log(`username: ${username}`);
		console.log(`password: ${password}`);

		try {
			const response = await auth.login(username, password)
			const data = response.data
			const status = response.status
			const headers = response.headers
			const authorization = headers.Authorization
			// JWT
			const accessToken = authorization.replace("Bearer ","")

			console.log(`data : ${data}`);
            console.log(`status : ${status}`);
            console.log(`headers : ${headers}`);
            console.log(`jwt : ${accessToken}`);

			// 로그인 성공
			if(status == 200){
				Cookies.set("accessToken", accessToken)

				// 로그인 체크
				loginCheck()

				// 메인 페이지로 이동
				navigate("/")


			}

		} catch (error) {
			console.log(`로그인 실패`);
		}
	}

	// 로그인 세팅 함수
	// userData, accessToken(jwt)
	const loginSetting = (userData, accessToken) => {
		const {no, userId, authList} = userData	   			// Users(DTO) [JSON]
		const roleList = authList.map((auth) => auth.auth)	// [ROLE_USER, ROLE_ADMIN]

		console.log(`no : ${no}`);
		console.log(`userId : ${userId}`);
		console.log(`authList : ${authList}`);
		console.log(`roleList : ${roleList}`);

		// axios common header - Authorization 헤더에 jwt 등록
		api.defaults.common.headers.Authorization = `Bearer ${accessToken}`

		// Context에 정보 등록
		// 로그인 여부 세팅
		setLogin(true)
		
		// 유저 정보 세팅
		const updatedUserInfo = {no, userId, roleList}
		setUserInfo(updatedUserInfo)

		// 권한 정보 세팅
		const updatedRoles = {isUser : false, isAmdin : false}
		roleList.forEach((role) => {
			if(role == 'ROLE_USER') updatedRoles.isUser = true
			if(role == 'ROLE_Admin') updatedRoles.isAmdin = true
		})
		setRoles(updatedRoles)
	}

	// 로그아웃 세팅
    const logoutSetting = () => {
        // 🚀❌ axios 헤더 초기화
        api.defaults.headers.common.Authorization = undefined;

        // 🍪❌ 쿠키 초기화
        Cookies.remove("accessToken")

        // 🔐❌ 로그인 여부 : false
        setLogin(false)

        // 👩‍💼❌ 유저 정보 초기화
        setUserInfo(null)

        // 👮‍♀️❌ 권한 정보 초기화
        setRoles(null)
    }

    return (
        // 컨텍스트 값 지정
        <LoginContext.Provider value={{ }}>
            {children}
        </LoginContext.Provider>
    )
}

export default LoginContextProvider