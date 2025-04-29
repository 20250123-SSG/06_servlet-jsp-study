package com.kyungbae.servlet.section06.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class LifeCycleFilter implements Filter {

    public LifeCycleFilter(){
        System.out.println("___LifeCycleFilter 생성자 실행___");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("___LifeCycleFilter init()___");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // Servlet 실행 전 실행할 코드
        System.out.println("doFilter() - Servlet 실행 전");

        filterChain.doFilter(servletRequest, servletResponse); // 다음 필터 및 servlet 실행

        // Servlet 실행 후 실행할 코드
        System.out.println("doFilter() - Servlet 실행 후");

    }

    @Override
    public void destroy() {
        System.out.println("___LifeCycleFilter destroy() 메소드 실행___");
    }

}
