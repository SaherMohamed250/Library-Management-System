package com.example.librarymangmentsystem.services;

import com.example.librarymangmentsystem.models.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    List<Member> getAllMembers();
    Optional<Member> getMemberById(Long id);
    Member createMember(Member member);
    Member updateMember(Long id, Member member);
    String deleteMember(Long id);
}
