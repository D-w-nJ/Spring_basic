package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

//    리턴값 : 할인 금액
    int discount(Member member, int price);
}
