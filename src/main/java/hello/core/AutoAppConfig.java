package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member", //이러면 이하 패키지에서만 Component 찾아서 등록,
        // 어디서부터 찾을지 지정 가능 이거 안하면 모든 코드 다뒤짐
        //패키지 지정하지 않으면 @ComponentScan이 붙은 클래스의 패키지가 시작 위치가 됨

        //권장 방법 -> @ComponentScan을 프로젝트 최상위에 두는것!!, 스프링 부트도 이 방법 사용한다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) //자동으로 빈으로 추가함, appconfig에 있는 빈 자동 추가하면 안되므로 exclude
//그러므로 @Bean으로 등록하는 클래스가 없다.
public class AutoAppConfig {


}