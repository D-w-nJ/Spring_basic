package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class  MemberApp {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // @bean 지정된걸 다 컨테이너에 넣어준다.
        //이제는 스프링 컨테이너를 통해 객체를 가져온다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        //"memberService" 객체를 가져올거고 타입은 MemberService야

        Member memberA = new Member(1L, "memberA", Grade.BASIC);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("memberA = " + memberA.getName());
        System.out.println("findmember = " + findMember.getName());

    }
}
