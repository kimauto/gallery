package com.ssg.gallery.member.service;

import com.ssg.gallery.member.entity.Member;
import com.ssg.gallery.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BaseMemberService implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void save(String name, String loginId, String password) {
            memberRepository.save(new Member(name,loginId,password));
    }

    @Override
    public Member find(String loginId, String password) {
        Optional<Member> member = memberRepository.findByLoginIdAndLoginPw(loginId,password);
        return member.orElse(null);
    }
}
