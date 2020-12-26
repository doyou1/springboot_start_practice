package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// 자바 코드로 직접 스프링 빈 등록하기
// XML 설정 방법도 있으나, 요즘은 자주 사용하지 않음
// 직접 등록시 DB 등의 API 변경시 약간의 수정으로 변경 가능
//@Configuration
public class SpringConfig {
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }
//
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
}