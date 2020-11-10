package cn.aq.springboot.config;

import cn.aq.springboot.listener.MyListener;
import cn.aq.springboot.servlet.MyMvcConfig;
import cn.aq.springboot.filter.MyFilter;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServerConfig {

//    注册三大组件
    /*注册 servlet*/
    @Bean
    public ServletRegistrationBean<MyMvcConfig> initServletRegistrationBean() {
//        <映射文件>
        ServletRegistrationBean<MyMvcConfig> servletServletRegistrationBean = new ServletRegistrationBean<>();
        servletServletRegistrationBean.setServlet(new MyMvcConfig());
//        映射路径
        servletServletRegistrationBean.addUrlMappings("/MyMvcConfig");
        return servletServletRegistrationBean;
    }

    /*注册 filter*/
    @Bean
    public FilterRegistrationBean<MyFilter> initFilterFilterRegistrationBean() {
        FilterRegistrationBean<MyFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new MyFilter());
//        映射路径
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/MyFilterConfig1","/MyFilterConfig2"));
        return filterFilterRegistrationBean;
    }

    /*注册 listener*/
    @Bean
    public ServletListenerRegistrationBean<MyListener> initServletListenerRegistrationBean() {
        ServletListenerRegistrationBean<MyListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>();
        servletListenerRegistrationBean.setListener(new MyListener());
        return servletListenerRegistrationBean;
    }

















    //    @Bean 表示加入到容器中，这样 SpringBoot 才能知道配置的存在
    @Bean
    /*配置嵌入式的 Servlet 容器*/
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            //            定制嵌入式的 Servlet 容器的相关规则
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                //factory.setPort(8083);
            }
        };
    }


}
