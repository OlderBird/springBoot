package cn.aq.springboot.controller;

import cn.aq.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    //    测试“用户不存在异常” hello?user=aaa
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user){
        if(user.equals("aaa"))
            throw new UserNotExistException();
        return "Hello World";
    }

    //查出一些数据，在页面展示
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","艾琦");
        map.put("change","我被替换了");
        map.put("users", Arrays.asList("员工1","员工2","员工3"));
        return "success";
    }

    //默认首页public，如此写就是访问templates里的某个页面
    @RequestMapping({"/","login.html"})
    public String login(){
        return "login";
    }



}
