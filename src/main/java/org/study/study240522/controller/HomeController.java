package org.study.study240522.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.study.study240522.domain.Member;
import org.study.study240522.service.MemberService;

@Controller
public class HomeController {

    private final MemberService memberService;

    public HomeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String home()
    {
        return "home";
    }




}
