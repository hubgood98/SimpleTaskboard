package org.study.study240522.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.study.study240522.domain.Member;
import org.study.study240522.service.MemberService;

import java.util.List;

@Controller //Spring Container이 이 애노테이션을 보고나서 객체를 넣어두고 관리하게 된다.
public class MemberController {

    //스프링 컨테이너로부터 받아쓸 수 있도록 구현
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String newMember() {

        return "members/CreateMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm Form)
    {
        Member member = new Member();
        member.setName(Form.getName());

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String members(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }


}