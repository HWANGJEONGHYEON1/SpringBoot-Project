package com.zerock.hellospring;

import com.zerock.hellospring.repository.JdbcMemberRepository;
import com.zerock.hellospring.repository.MemberRepository;
import com.zerock.hellospring.repository.MemoryMemberRepository;
import com.zerock.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcMemberRepository(dataSource);
    }
}
