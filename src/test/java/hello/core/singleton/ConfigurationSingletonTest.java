package hello.core.singleton;

import hello.core.member.MemberRepository;
import hello.core.member.MemberserviceImpl;
import hello.core.order.AppConfig;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberserviceImpl memberService = ac.getBean("memberService", MemberserviceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository1 = " + memberRepository1);
        System.out.println("orderService -> memberRepository1 = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);
        //같은 값이 나온다. 모두 같은 인스턴스를 공유함

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);

    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
        //값이 bean = class hello.core.order.AppConfig$$EnhancerBySpringCGLIB$$a41bd21e
        //같이 그냥 클래스가 아닌것을 볼 수 있다.

        /*
         AppConfig를 상속받는 다른 클래스(AppConfig@CGLIB)를 만들고 스프링 빈으로 등록, 이를 조작하여 싱글톤을 보장하도록 한다.
         AppConfig를 조회했을 때 나오는 이유는 자식 타입도 딸려나오므로 나온 것이다.
         @Configuration이 없어도 스프링 컨테이너에 스프링 빈으로 등록됨, BUT, CGLIB기술을 사용하지 않아 모든 객체가 중복 호출되고
         싱글톤이 해제됨
         */
    }
}
