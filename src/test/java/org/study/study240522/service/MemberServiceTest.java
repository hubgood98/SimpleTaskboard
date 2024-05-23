package org.study.study240522.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.study.study240522.domain.Member;
import org.study.study240522.repository.MemberRepository;
import org.study.study240522.repository.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemberRepository memberRepository;


    @BeforeEach
    void setup() //메서드 실행전
    {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach //메서드 실행 이후
    void After()
    {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given <- 테스트를 위해 준비하는 과정, 테스트에 사용하는 변수,입력값을 정의
        Member member = new Member();
        member.setName("hee");
        //when - 실행
        Long saveId =  memberService.join(member);
        //then - 검증
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertEquals("hee", findMember.getName());
    }

    @Test
    void 중복회원_예외() {
        Member member1 = new Member();
        member1.setName("hee");

        Member member2 = new Member();
        member2.setName("hee");

        //when
        memberService.join(member1);
        try {
            memberService.join(member2);
        }catch (IllegalStateException e){
            Assertions.assertEquals(e.getMessage(),"이미 존재하는 회원입니다.");
        }
    }

    @Test
    void findOne() {
    }
}