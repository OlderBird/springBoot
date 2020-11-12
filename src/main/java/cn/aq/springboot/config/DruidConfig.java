package cn.aq.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

/**我们自己来创建一个数据源
 * 将属性绑定的注解  @ConfigurationProperties
 * spring.datasource：绑定属性的前缀*/
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
//        将数据源返回出去
        return new DruidDataSource();
    }

/**配置 Druid 的监控
 * 1、配置一个管理后台的 Servlet*/
    @Bean
    public ServletRegistrationBean statViewServlet() {
//        urlMappings：我们处理 druid 下的所有请求
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/");
//        配置初始化参数
        Map<String,String> initParams = new HashMap<>();
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","123456");
        initParams.put("allow",""); //默认就是允许所有访问
//        initParams.put("deny","local address")：拒绝访问
        servletRegistrationBean.setInitParameters(initParams);

        return servletRegistrationBean;
    }

/**2、配置一个 web 监控的 filter*/
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        我们要注册哪个 Filter，把这个 filter 设置进去
        filterRegistrationBean.setFilter(new WebStatFilter());
//        Filter 的初始化参数
        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");  //排除拦截哪些请求？
        filterRegistrationBean.setInitParameters(initParams);
//        Bean 拦截所有请求
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));

        return filterRegistrationBean;
    }

}
