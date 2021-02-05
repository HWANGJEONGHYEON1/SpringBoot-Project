package com.zerock.hellospring;

import com.zerock.hellospring.repository.MemberRepository;
import com.zerock.hellospring.repository.MemoryMemberRepository;
import com.zerock.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
