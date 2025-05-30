package com.example.librarymangmentsystem.services;

import com.example.librarymangmentsystem.models.Member;
import com.example.librarymangmentsystem.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MemberServiceIml implements MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Member createMember(Member member) {
        Member Member1 = new Member();
        Member1.setName(member.getName());
        Member1.setPhone(member.getPhone());
        return memberRepository.save(Member1);
    }

    @Override
    public Member updateMember(Long id, Member updatedMember) {
        Member existingMember = memberRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Member not found"));

        existingMember.setName(updatedMember.getName());
        existingMember.setPhone(updatedMember.getPhone());
        return memberRepository.save(existingMember);
    }


    @Override
    public String deleteMember(Long id) {
        memberRepository.deleteById(id);
        return "DELETED";
    }
}
