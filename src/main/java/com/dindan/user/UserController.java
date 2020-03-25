package com.dindan.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author：十亿少女的梦
 * @Date：2020/3/23 15:35
 */
@Controller
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;


    /**
     * 登录接口
     * @param request
     * @param response
     * @param name
     * @param pwd
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Object login(HttpServletRequest request,HttpServletResponse response, String name, String pwd){
        return service.login(request,response,name,pwd);
    }

    @RequestMapping("/logout")
    @ResponseBody
    public Object logout(HttpServletRequest request,HttpServletResponse response,String name){
        return service.logout(request,response,name);
    }
}
