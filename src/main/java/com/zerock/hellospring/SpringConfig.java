package com.zerock.hellospring;

import com.zerock.hellospring.aop.TimeTraceAop;
import com.zerock.hellospring.repository.JdbcMemberRepository;
import com.zerock.hellospring.repository.JpaMemberRepository;
import com.zerock.hellospring.repository.MemberRepository;
import com.zerock.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new JdbcMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
