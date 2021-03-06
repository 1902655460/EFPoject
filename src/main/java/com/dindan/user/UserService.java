package com.dindan.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author：十亿少女的梦
 * @Date：2020/3/23 15:11
 */
@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    Map<String,Object> map;

    public Object login(HttpServletRequest request,HttpServletResponse response,String name,String pwd){
        map = new HashMap<>(0);
        try{
            User user = mapper.selectOne(new QueryWrapper<User>().eq("name",name).eq("pwd",pwd));
            if(user != null){
                map.put("code",user.getStute().toString());
               // Cookie cookie = new Cookie(user.getName(),user.getStute().toString());
                //cookie.setPath("/");
               // cookie.setMaxAge(3600);
               // response.addCookie(cookie);
            }else{
                map.put("code",-1);
            }
        }catch (Exception e){
            map.put("code",-1);
            //e.printStackTrace();
        }
        return map;
    }

    public Object logout(HttpServletRequest request,HttpServletResponse response,String name){
        map = new HashMap<>(0);
        Cookie[] cookies = request.getCookies();//获取cookie数组
        for (Cookie c:cookies) {   //遍历cookie

            if (c.getName().equals(name)) {
                Cookie cookie = new Cookie(c.getName(), null);//删除前必须要new 一个valu为空；
                cookie.setPath("/");//路径要相同
                cookie.setMaxAge(0);//生命周期设置为0
                response.addCookie(cookie);
                break;
            }
        }
        map.put("code",0);
        return map;
    }
}
