package com.johnth.servlet.section06.filter;


import jakarta.servlet.*;

import java.io.IOException;

public class LifeCycleFilter implements Filter {

    public LifeCycleFilter(){
        System.out.println("LifeCycleFilter 기본 생성자 실행");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
        System.out.println("LifecycleFilter init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("서블릿 실행 전 Before filterChain LifecycleFilter doFilter()");
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {
//        Filter.super.destroy();
        System.out.println("LifecycleFilter destroy()");
    }
}
