package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberserviceImpl;

public class  MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberserviceImpl();
        Member memberA = new Member(1L, "memberA", Grade.BASIC);
        memberService.join(memberA);

         System.out.println("memberA = " + memberA.getName());
        System.out.println("findmember = " + findmember.getName());

    }
}
