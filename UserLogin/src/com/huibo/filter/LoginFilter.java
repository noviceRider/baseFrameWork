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
        // ��������������Ҫ�õ�request,response,session����
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();
        //��ȡ��½�û����û���
        String userName = servletRequest.getParameter("name");
        if(userName == null || userName.equals("")) {
        	//���css��ͼƬ����ʾ������
        	StringBuffer fileURL = servletRequest.getRequestURL(); 
            if (fileURL.indexOf(".jpg") > 0 || fileURL.indexOf(".bmp") > 0 
                || fileURL.indexOf(".gif") > 0|| fileURL.indexOf(".css") > 0 || fileURL.indexOf(".png") > 0) { 
                    chain.doFilter(servletRequest, servletResponse); 
                    return; 
                   } 
        }else {
        	//���û������뵽session��
        	session.setAttribute("name", userName);
        	//����session�������Чʱ�䣨��λ�룩
        	session.setMaxInactiveInterval(300);
        }
        
        // ����û������URI
        String path = servletRequest.getRequestURI();
        //System.out.println(path);
        
        // ��session��ȡ�û���Ϣ
        String name = (String) session.getAttribute("name");
        
        // ��½ҳ���������
        if(path.indexOf("/index.html") > -1) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }

        // �ж����û��ȡ���û���Ϣ,����ת����½ҳ��
        if (name == null || "".equals(name)) {
            // ��ת����½ҳ��
            servletResponse.sendRedirect("/UserLogin/index.html");
        } else {
            // �Ѿ���½,�����˴�����
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

}