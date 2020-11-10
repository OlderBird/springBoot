package cn.aq.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    /*Filter 的初始化*/
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /*Filter 的过滤*/
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        只要 Filter 执行了我们就来输出一句话
        System.out.println("MyFilter process...");
//        执行完了之后将这个请求放行出去
        filterChain.doFilter(servletRequest,servletResponse);
    }

    /*Filter 的销毁*/
    @Override
    public void destroy() {

    }
}
