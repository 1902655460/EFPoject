package com.dindan.user;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */
public class LogCostFilter implements HandlerInterceptor {

    /**
     * 在请求被处理之前调用
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 检查每个到来的请求对应的session域中是否有登录标识
        System.out.println("拦截器");
        User user = (User)request.getSession().getAttribute("user");
        if (user==null) {
            // 未登录，重定向到登录页
            System.out.println("被拦截");
            response.sendRedirect("/");
            return false;
        }
        System.out.println("放行");
        return true;
    }

}
