package com.ssg.gallery.account.helper;

import com.ssg.gallery.account.dto.AccountJoinRequest;
import com.ssg.gallery.account.dto.AccountLoginRequest;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AccountHelper {


    //회원 가입
    void join(AccountJoinRequest joinRequest);

    //로그인
    String login(AccountLoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response);

    //회원 아이디 조회
    Integer getMemberId(HttpServletRequest request);

    //로그인 여부 확인
    boolean isLoggedIn(HttpServletRequest request);

    //로그아웃
    void logout(HttpServletRequest request, HttpServletResponse response);

}
