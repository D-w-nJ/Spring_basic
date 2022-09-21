package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberserviceImpl;
import hello.core.member.MemoryMemberRepository;

public class AppConfig {

    public MemberService memberService() {
        return new MemberserviceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
