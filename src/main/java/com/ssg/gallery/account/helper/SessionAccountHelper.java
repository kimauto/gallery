package com.ssg.gallery.account.helper;

import com.ssg.gallery.account.dto.AccountJoinRequest;
import com.ssg.gallery.account.dto.AccountLoginRequest;
import com.ssg.gallery.account.etc.AccountConstants;
import com.ssg.gallery.common.util.HttpUtils;
import com.ssg.gallery.member.entity.Member;
import com.ssg.gallery.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SessionAccountHelper implements AccountHelper {

    private  final MemberService memberService;
    @Override
    public void join(AccountJoinRequest joinRequest) {

            memberService.save(joinRequest.getName(),joinRequest.getLoginId(),joinRequest.getLoginPw());
    }

    @Override
    public String login(AccountLoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response) {
        Member member = memberService.find(loginRequest.getLoginId(), loginRequest.getLoginPw());

        if (member == null) {
            return null;
        }
        HttpUtils.setSession(request, AccountConstants.Member_ID_NAME, member);
        return member.getLoginId();
    }

    @Override
    public Integer getMemberId(HttpServletRequest request) {
            Object memberId = HttpUtils.getSessionValue(request, AccountConstants.Member_ID_NAME);
            if (memberId != null) {
                return (int)memberId;
            }
            return null;
    }

    @Override
    public boolean isLoggedIn(HttpServletRequest request) {
        return getMemberId(request) != null;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
            HttpUtils.removeSession(request, AccountConstants.Member_ID_NAME);
    }
}
