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

    /**利用 SpringMVC ExceptionHandler 机制，
     * 捕获 UserNotExistException 异常以后，捕获json数据用 @ResponseBody 显示出来*/
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest httpServletRequest) {
        Map<String, Object> map = new HashMap<>();

//       传入我们自己的错误状态码，4xx，5xx
        httpServletRequest.setAttribute("javax.servlet.error.status_code",400);

        map.put("code","user.notexist");
        map.put("message","用户出错啦"); //异常消息
//        map.put("message",e.getMessage());

        /**出现错误以后，会来到 /error 请求，会被 BasicErrorController 处理，
         * 响应出去可以获取的数据是由 getErrorAttributes 得到的（是 AbstractErrorController(ErrorController)规定的方法）
         *
         * 1、（不使用）所以我们可以完全来编写一个 ErrorController 的实现类【或者是编写 AbstractErrorController】，放在容器中（太复杂）
         * 2、页面上能用的数据，或者是json返回能用的数据都是通过 errorAttributes.getErrorAttribute
         *      容器中 DefaultErrorAttributes.getErrorAttributes(); 默认进行数据处理的
         * */
        httpServletRequest.setAttribute("ext",map);
        return "forward:/error";
    }
}
