package cn.aq.springboot.component;


import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 点击链接切换国际化
 * 可以在链接上携带区域信息
 * */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
//        获取页面参数的值
        String l = httpServletRequest.getParameter("language");
        Locale locale = Locale.getDefault();
//        如果不为空，带来区域信息
        if (!StringUtils.isEmpty(l)) {
//            从下划线开始分割
            String[] split = l.split("_");
//            第一个参数传语言代码，第二个传国家代码
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
