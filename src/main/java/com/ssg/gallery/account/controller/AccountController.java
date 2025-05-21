package com.ssg.gallery.account.controller;


import ch.qos.logback.core.util.StringUtil;
import com.ssg.gallery.account.dto.AccountJoinRequest;
import com.ssg.gallery.account.dto.AccountLoginRequest;
import com.ssg.gallery.account.helper.AccountHelper;
import com.ssg.gallery.member.entity.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class AccountController {

    private final AccountHelper accountHelper;

    @PostMapping("api/account/join")
    public ResponseEntity<?> join(@RequestBody AccountJoinRequest request) {
        if (!StringUtils.hasLength(request.getName()) || !StringUtils.hasLength(request.getLoginId()) || !StringUtils.hasLength(request.getLoginPw()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        accountHelper.join(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("api/account/login")
    public ResponseEntity<?> login(@RequestBody AccountLoginRequest accountLoginRequest, HttpServletRequest request, HttpServletResponse response) {
        if (!StringUtils.hasLength(accountLoginRequest.getLoginId()) || !StringUtils.hasLength(accountLoginRequest.getLoginPw()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        String login = accountHelper.login(accountLoginRequest, request, response);

        if (login == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(login, HttpStatus.OK);
    }


    //로그아웃
    @PostMapping("api/account/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
        accountHelper.logout(request, response);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("api/account/check")
    public ResponseEntity<?> check(HttpServletRequest request){
        boolean loggedIn = accountHelper.isLoggedIn(request);

        if (loggedIn){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
