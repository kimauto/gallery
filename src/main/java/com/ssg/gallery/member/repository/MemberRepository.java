package com.ssg.gallery.member.repository;

import com.ssg.gallery.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

        Optional<Member> findByLoginIdAndLoginPw(String loginId, String loginPw);
}
