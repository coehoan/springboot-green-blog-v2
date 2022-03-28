package site.metacoding.blogv2.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import site.metacoding.blogv2.config.filter.MyFilter1;
import site.metacoding.blogv2.config.filter.MyFilter2;

//@Configuration
public class FilterConfig {
    public FilterConfig() {
        System.out.println("필터 설정파일 IoC 컨테이너 등록완료");
    }

    @Bean // IoC 컨테이너에 띄우기 위해 필요한 어노테이션
    public FilterRegistrationBean<?> filter1() {
        FilterRegistrationBean<MyFilter1> bean = new FilterRegistrationBean<>(new MyFilter1());
        bean.addUrlPatterns("/*"); // / 뒤로 들어오는 모든 주소는 필터를 거친다.
        bean.setOrder(1); // 필터의 순서. 낮은 번호부터 실행됨
        return bean;
    }

    @Bean
    public FilterRegistrationBean<?> filter2() {
        FilterRegistrationBean<MyFilter2> bean = new FilterRegistrationBean<>(new MyFilter2());
        bean.addUrlPatterns("/*");
        bean.setOrder(2);
        return bean;
    }
}