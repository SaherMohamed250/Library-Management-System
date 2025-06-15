package com.example.librarymanagementsystem.service.Implementation;

import com.example.librarymanagementsystem.model.Member;
import com.example.librarymanagementsystem.repository.MemberRepository;
import com.example.librarymanagementsystem.service.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
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
    public Member updateMember(Long id, Member member) {
        Member existingMember = memberRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Member not found"));

        existingMember.setName(member.getName());
        existingMember.setPhone(member.getPhone());
        return memberRepository.save(existingMember);
    }

    @Override
    public String deleteMember(Long id) {
        memberRepository.deleteById(id);
        return "deleted";
    }
}
