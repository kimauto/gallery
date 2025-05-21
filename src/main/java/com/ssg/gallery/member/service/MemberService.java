package com.ssg.gallery.member.service;

import com.ssg.gallery.member.entity.Member;

public interface MemberService {

    void save(String name, String loginId, String password);

    Member find(String loginId, String password);
}
