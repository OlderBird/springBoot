package cn.aq.springboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**自定义异常处理器*/
@ControllerAdvice
public class MyExceptionHandler {

    /**利用 SpringMVC ExceptionHandler 机制，捕获异常以后，捕获json数据用 @ResponseBody 显示出来*/
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest httpServletRequest) {
        Map<String, Object> map = new HashMap<>();

        //传入我们自己的错误状态码，4xx，5xx
        httpServletRequest.setAttribute("javax.servlet.error.status_code",400);

        map.put("code","user.notexist");
        map.put("message","用户出错啦");
//         map.put("message",e.getMessage());

        httpServletRequest.setAttribute("ext",map);
        return "forward:/error";
    }
}
