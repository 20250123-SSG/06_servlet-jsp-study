package com.johnth.servlet.section06.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/board/*")
public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("======EncodingFilter======");

        if("POST".equals(((HttpServletRequest)servletRequest).getMethod().toLowerCase())){
            System.out.println("POST ENCODING");
            servletRequest.setCharacterEncoding("UTF-8");
        }

        filterChain.doFilter(servletRequest, servletResponse); // 다음 Filter 및 Servlet 실행
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
