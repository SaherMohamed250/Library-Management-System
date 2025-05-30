package com.example.librarymangmentsystem.controller;

import com.example.librarymangmentsystem.models.Member;
import com.example.librarymangmentsystem.services.MemberServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/member")
public class memberController {
    @Autowired
    private MemberServiceIml memberService;

    @GetMapping
    public ResponseEntity<?> getAllMembers() {
        List<Member> members = memberService.getAllMembers();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMemberById(@PathVariable Long id) {
        Optional<Member> member = memberService.getMemberById(id);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createMember(@RequestBody Member member) {
        Member created = memberService.createMember(member);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMember(@PathVariable Long id, @RequestBody Member updatedMember) {
        Member updated = memberService.updateMember(id, updatedMember);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable Long id) {
        String result = memberService.deleteMember(id);
        return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
    }
}
