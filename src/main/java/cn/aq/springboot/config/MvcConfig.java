package cn.aq.springboot.config;

import cn.aq.springboot.component.LoginHandlerInterceptor;
import cn.aq.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
//        页面的重定向
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");

            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                super.addInterceptors( registry );
                /**平台资源： *css。*js
                 * SpringBoot已经做好了静态资源映射，不用对静态资源 进行拦截
                 * 2.0以上版本自动拦截静态文件，加上 "/asserts/**" */
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login","/asserts/**");

            }
        };
        return webMvcConfigurer;
    }

    /*为了让区域解析器生效，加在容器中*/
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}