package org.study.study240522.service;

import org.study.study240522.domain.Member;
import org.study.study240522.repository.MemberRepository;
import org.study.study240522.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
/**
 회원가입
**/

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public Long join(Member member) {

        DuplicateNameCheck(member); //중복이름 검사
        memberRepository.save(member);
        return member.getId();
    }

    private void DuplicateNameCheck(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {throw new IllegalArgumentException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long id) {
        return memberRepository.findById(id);
    }
}
