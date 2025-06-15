package com.example.librarymanagementsystem.service.interfaces;

import com.example.librarymanagementsystem.model.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    List<Member> getAllMembers();
    Optional<Member> getMemberById(Long id);
    Member createMember(Member member);
    Member updateMember(Long id, Member member);
    String deleteMember(Long id);
}
