package com.aloha.security5.controller;

import java.security.Principal;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.aloha.security5.dto.Users;
import com.aloha.security5.service.UserService;

import lombok.extern.slf4j.Slf4j;




@Slf4j
@Controller
public class HomeController {

    @Autowired
    private UserService userService;
    
    /**
     * 메인 화면
     * @param model
     * @param Principal
     * @return
     */
    @GetMapping({"", "/"})
    public String home(Model model, Principal Principal) {
        // Principal : 현재 로그인 한 사용자 정보를 확인하는 인터페이스
        String loginId = Principal != null ? Principal.getName() : "guest";
        model.addAttribute("loginId", loginId);
        return "index";
    }

    /**
     * 인증 예외 페이지 (접근 거부 에러 페이지)
     * @param auth
     * @param model
     * @return
     */
    @GetMapping("/exception")
    public String exception(Authentication auth, Model model) {
        log.info("인증 예외 처리...");
        log.info("auth : " + auth.toString());
        model.addAttribute("msg", "인증 거부 : " + auth.toString());
        return "/exception";
    }
    
    /**
     * 로그인 화면
     * @return
     */
    @GetMapping("/login")
    public String login(
            @CookieValue(value = "remember-id", required = false) Cookie cookie
            ,Model model) {
        // @CookieValue(value="쿠키명", required="필수 여부")
        // - required=true (default)    : 쿠키를 필수로 가져옴 ➡ 쿠키가 없으면 에러
        // - required=false             : 쿠키 필수 ❌ ➡ 쿠키가 없어도 에러 ❌
        log.info("로그인 페이지...");
        
        String userId = "";
        boolean rememberId = false;

        if(cookie != null){
            log.info("CookieName : " + cookie.getName());
            log.info("CookieValue : " + cookie.getValue());
            userId = cookie.getValue();
            rememberId = true;
        }

        model.addAttribute("userId", userId);
        model.addAttribute("rememberId", rememberId);

        return "/login";
    }
    
    /*
     * 회원가입 화면
     */
    @GetMapping("/join")
    public String join() {
        log.info("회원가입 화면...");
        return "/join";
    }

    @PostMapping("/join")
    public String joinPro(Users user
                        , HttpServletRequest request) throws Exception {
        
        // 회원 가입 요청
        int result = userService.join(user);

        // 회원가입 성공
        if (result > 0 ) {
            // ⭐ 바로 로그인
            userService.login(user, request);
            return "redirect:/";

            // ➡ 로그인 페이지로 이동
            // return "redirect:/login";
        }
        
        return "redirect:/join?error" ;
    }

}
