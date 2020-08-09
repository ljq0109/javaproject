package com.lijiaqing.studentmanage.config;

import com.lijiaqing.studentmanage.compnent.LoginHandlerIntceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyViewConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("StuMainPage.html").setViewName("stu/stu_mainPage");
        registry.addViewController("TeaMainPage.html").setViewName("tea/tea_mainPage");
        registry.addViewController("ManMainPage.html").setViewName("man/man_mainPage");
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //spring boot 已经做好了静态资源映射，可以不用处理静态资源
        registry.addInterceptor(new LoginHandlerIntceptor()).addPathPatterns("/**")
                .excludePathPatterns("/", "/login.html", "/login","/css/**","/fonts/**","/images/**","/js/**");
    }
}
