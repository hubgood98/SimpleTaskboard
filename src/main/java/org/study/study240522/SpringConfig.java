package org.study.study240522;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.study.study240522.aop.TimeTraceAop;
import org.study.study240522.repository.MemberRepository;
import org.study.study240522.service.MemberService;

@Configuration //Aop는 인지하여 쓰기 위해서 Bean으로 개별 등록해주는게 좋다
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService()
    {
        return new MemberService(memberRepository);
    }

}
