package cn.aq.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class loginController {

    /**
     *    表示我们要映射一个post请求，类似的有get、put、delete请求
     *    @DeleteMapping
     *    @PutMapping
     *    @GetMapping*/
    @PostMapping
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession httpSession){

//         如果用户名不为空，且密码正确
        if(!StringUtils.isEmpty(username) && "123".equals(password)) {
            httpSession.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        else {
            map.put("msg","用户名或密码错误");
            return "login";
        }

    }
}
