package com.huibo.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        // 获得在下面代码中要用的request,response,session对象
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();
        //获取登陆用户的用户名
        String userName = servletRequest.getParameter("name");
        if(userName == null || userName.equals("")) {
        	//解决css和图片不显示的问题
        	StringBuffer fileURL = servletRequest.getRequestURL(); 
            if (fileURL.indexOf(".jpg") > 0 || fileURL.indexOf(".bmp") > 0 
                || fileURL.indexOf(".gif") > 0|| fileURL.indexOf(".css") > 0 || fileURL.indexOf(".png") > 0) { 
                    chain.doFilter(servletRequest, servletResponse); 
                    return; 
                   } 
        }else {
        	//把用户名放入到session中
        	session.setAttribute("name", userName);
        	//设置session的最大有效时间（单位秒）
        	session.setMaxInactiveInterval(300);
        }
        
        // 获得用户请求的URI
        String path = servletRequest.getRequestURI();
        //System.out.println(path);
        
        // 从session里取用户信息
        String name = (String) session.getAttribute("name");
        
        // 登陆页面无需过滤
        if(path.indexOf("/index.html") > -1) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 判断如果没有取到用户信息,就跳转到登陆页面
        if (name == null || "".equals(name)) {
            // 跳转到登陆页面
            servletResponse.sendRedirect("/UserLogin/index.html");
        } else {
            // 已经登陆,继续此次请求
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

}