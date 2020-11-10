package cn.aq.springboot.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*要成为一个标准的 Servlet，就要继承 HttpServlet*/
public class MyMvcConfig extends HttpServlet {

//    处理get请求，重写方法
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
//        调用doPost
        doPost(req,resp);
    }

//    处理post请求
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
//        在浏览器输出一句话
        resp.getWriter().write("Hello MyServlet");
//        如何使用？光写在这可不行，我们要使用 SpringBoot 提供的方式注册在容器中：ServletRegistrationBean
//        在 MyServerConfig 中
    }



}
