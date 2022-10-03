package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberserviceImpl;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //app의 설정정보
public class AppConfig {

    // 함수가 호출될 떄마다 new로 객체가 생성됨 -> 싱글톤이 해제? NO, AppConfig를 상속받아 새로만든 클래스에서 객체가 있다면 생략,
    // 없다면 새로 생성하는 방식으로 싱글톤 보장

    @Bean // 스프링 컨테이너에 등록이 됨
    public MemberService memberService() {
        return new MemberserviceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy(); // 할인정책 바꾸기(구성영역만 수정하는것, 사용영역의 어떤 부분도 수정 x)
    }
}
