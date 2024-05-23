package org.study.study240522.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.study.study240522.service.MemberService;

@Controller //Spring Container이 이 애노테이션을 보고나서 객체를 넣어두고 관리하게 된다.
public class MemberController {

    //스프링 컨테이너로부터 받아쓸 수 있도록 구현
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
