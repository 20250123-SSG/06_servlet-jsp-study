package com.kyungbae.servlet.section06.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/board/*")
public class EncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("===EncodingFilter 동작===");
        if("post".equals( ((HttpServletRequest)servletRequest).getMethod().toLowerCase() )){
            System.out.println("post 방식확인");
            servletRequest.setCharacterEncoding("utf-8");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
