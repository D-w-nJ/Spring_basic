package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) //자동으로 빈으로 추가함, appconfig에 있는 빈 자동 추가하면 안되므로 exclude
//그러므로 @Bean으로 등록하는 클래스가 없다.
public class AutoAppConfig {


}
